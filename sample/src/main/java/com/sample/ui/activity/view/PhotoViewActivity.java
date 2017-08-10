//package com.sample.ui.activity.view;
//
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.net.Uri;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.provider.MediaStore;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.view.KeyEvent;
//import android.widget.TextView;
//
//import com.sample.R;
//import com.sample.constants.Constants;
//import com.siberiadante.adapter.PhotoViewAdapter;
//import com.siberiadante.util.ToastUtil;
//import com.siberiadante.widget.PhotoViewPager;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 含图片下载保存
// */
//public class PhotoViewActivity extends AppCompatActivity {
//    private PhotoViewPager mViewPager;
//    private int currentPosition;
//    private PhotoViewAdapter adapter;
//    private TextView mTvImageCount;
//    private TextView mTvSaveImage;
//    private List<String> Urls;
//    private long currentTimeMillis;
//    private static final int SEND_TOAST = 0x01;
//    private Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//
//            switch (msg.what) {
//                case SEND_TOAST:
//                    ToastUtil.showSingletonLong("保存至相册/Image");
//                    break;
//            }
//        }
//    };
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_photo_view);
//        initView();
//    }
//
//    private void initView() {
//        Urls = new ArrayList<>();
//        mViewPager = (PhotoViewPager) findViewById(R.id.view_pager_photo);
//        adapter = new PhotoViewAdapter(Urls, this);
//        mViewPager.setAdapter(adapter);
//        mViewPager.setCurrentItem(currentPosition, false);
//        mTvImageCount.setText(currentPosition + 1 + "/" + Urls.size());
//        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                currentPosition = position;
//                mTvImageCount.setText(currentPosition + 1 + "/" + Urls.size());
//            }
//        });
//    }
//    private void downLoadImageToLocal() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    URL url = new URL(Urls.get(currentPosition));
//                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                    conn.setDoInput(true);
//                    conn.connect();
//                    InputStream inputStream = conn.getInputStream();
//                    Bitmap mbitmap = BitmapFactory.decodeStream(inputStream);
//                    currentTimeMillis = System.currentTimeMillis();
//                    saveFile(mbitmap, currentTimeMillis);
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//    public void saveFile(Bitmap bmp, long currentTimeMillis) {
//        String mFilePath = Constants.ALBUM_PATH + String.valueOf(currentTimeMillis) + ".jpg";
//
//        File tmp = new File(Constants.ALBUM_PATH);
//        if (!tmp.exists()) {
//            tmp.mkdir();
//        }
//        File photoFile = new File(mFilePath);
//        Uri photoUri = Uri.fromFile(photoFile);
//        try {
//            photoFile.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FileOutputStream fOut = null;
//        try {
//            fOut = new FileOutputStream(photoFile);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        bmp.compress(Bitmap.CompressFormat.PNG, 100, fOut);
//        mHandler.sendEmptyMessage(SEND_TOAST);
//        try {
//            fOut.flush();
//            fOut.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            MediaStore.Images.Media.insertImage(getApplicationContext().getContentResolver(),
//                    photoFile.getAbsolutePath(), mFilePath, "");
////            if (photoFile.exists()) {
////                boolean delete = photoFile.delete();
////                Log.d(TAG, "saveFile: delete------"+delete);
////            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        getApplicationContext().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
//                photoUri));
//    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            this.finish();
//            overridePendingTransition(R.anim.photo_activity_before_enter, R.anim.photo_activity_exit);
//        }
//        return false;
//    }
//}
