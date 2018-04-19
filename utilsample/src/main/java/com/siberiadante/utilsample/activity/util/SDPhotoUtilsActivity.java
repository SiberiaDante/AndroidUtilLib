package com.siberiadante.utilsample.activity.util;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.androidutil.util.SDPhotoUtil;
import com.siberiadante.androidutil.util.SDStorageUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;
import com.siberiadante.utilsample.listener.RequestPermissionCallBack;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;

public class SDPhotoUtilsActivity extends BaseActivity {

    private static final String TAG = SDPhotoUtilsActivity.class.getSimpleName();
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.btn_camera)
    Button btnCamera;
    @BindView(R.id.btn_alum)
    Button btnAlum;
    private File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/photo.jpg");
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri imageUri;
    private Uri cropImageUri;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdphoto_utils;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @OnClick({R.id.btn_camera, R.id.btn_alum})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_camera:
                chooseCamera();
                break;
            case R.id.btn_alum:
                chooseAlum();
                break;
        }
    }

    private void chooseCamera() {
        requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, new RequestPermissionCallBack() {
            @Override
            public void granted() {
                SDLogUtil.d(TAG, "---------------------");
                if (SDStorageUtil.hasSdcard()) {
                    imageUri = Uri.fromFile(fileUri);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                        //通过FileProvider创建一个content类型的Uri
                        imageUri = FileProvider.getUriForFile(SDPhotoUtilsActivity.this, "com.siberiadante.utilsample.fileProvider", fileUri);
                    SDPhotoUtil.takePicture(SDPhotoUtilsActivity.this, imageUri, CODE_CAMERA_REQUEST);
                } else {
                    Toast.makeText(SDPhotoUtilsActivity.this, "设备没有SD卡！", Toast.LENGTH_SHORT).show();
                    Log.e("asd", "设备没有SD卡");
                }
            }

            @Override
            public void denied() {
                Toast.makeText(SDPhotoUtilsActivity.this, "部分权限获取失败，正常功能受到影响", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void chooseAlum() {
        requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, new RequestPermissionCallBack() {
            @Override
            public void granted() {
                SDPhotoUtil.openPic(SDPhotoUtilsActivity.this, CODE_GALLERY_REQUEST);
            }

            @Override
            public void denied() {
                Toast.makeText(SDPhotoUtilsActivity.this, "部分权限获取失败，正常功能受到影响", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int output_X = 480, output_Y = 480;
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CODE_CAMERA_REQUEST://拍照完成回调
                    if (!fileCropUri.exists()) {
                        try {
                            fileCropUri.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    cropImageUri = Uri.fromFile(fileCropUri);
                    SDPhotoUtil.cropImageUri(this, imageUri, cropImageUri, 1, 1, output_X, output_Y, CODE_RESULT_REQUEST);
                    break;
                case CODE_GALLERY_REQUEST://访问相册完成回调
                    if (!fileCropUri.exists()) {
                        try {
                            fileCropUri.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    cropImageUri = Uri.fromFile(fileCropUri);
                    Uri newUri = Uri.parse(SDPhotoUtil.getPath(this, data.getData()));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                        newUri = FileProvider.getUriForFile(this, "com.siberiadante.utilsample.fileProvider", new File(newUri.getPath()));
                    SDPhotoUtil.cropImageUri(this, newUri, cropImageUri, 1, 1, output_X, output_Y, CODE_RESULT_REQUEST);
                    break;
                case CODE_RESULT_REQUEST:
                    Bitmap bitmap = SDPhotoUtil.getBitmapFromUri(cropImageUri, this);
                    if (bitmap != null) {
                        ivImg.setImageBitmap(bitmap);
                    }
                    break;
            }
        }
    }
}
