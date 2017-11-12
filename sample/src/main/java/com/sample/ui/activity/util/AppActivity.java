package com.sample.ui.activity.util;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.SDAppUtil;
import com.siberiadante.lib.util.SDLogUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AppActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = AppActivity.class.getSimpleName();
    private ImageView mIvIcon;
    private TextView mTvContent;

    @Override
    public int setLayoutId() {
        return R.layout.activity_app;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        SDLogUtil.d(TAG, "---" + getClass().getSimpleName() + "----------");
        mTvContent = (TextView) findViewById(R.id.tv_app_details);
        mIvIcon = (ImageView) findViewById(R.id.iv_icon);
        Button mBtnUnInstallApp = (Button) findViewById(R.id.un_install_app);
        Button mBtnInstallApp = (Button) findViewById(R.id.install_app);
        Button mBtnAppSetting = (Button) findViewById(R.id.setting_app);
        mBtnUnInstallApp.setOnClickListener(this);
        mBtnInstallApp.setOnClickListener(this);
        mBtnAppSetting.setOnClickListener(this);
        mIvIcon.setOnClickListener(this);
    }



    @Override
    public void initData() {
        StringBuilder builder = new StringBuilder();
        builder.append("getAppVersionCode---"+ SDAppUtil.getAppVersionCode()+"\n");
        builder.append("getAppVersionName---"+ SDAppUtil.getAppVersionName()+"\n");
        builder.append("getPackageName---"+ SDAppUtil.getPackageName()+"\n");
        builder.append("isInstalledApp---"+ SDAppUtil.isInstalledApp()+"\n");
        builder.append("getAppName---"+ SDAppUtil.getAppName()+"\n");
        builder.append("getAppPath---"+ SDAppUtil.getAppPath()+"\n");
        builder.append("getAppPath---"+ SDAppUtil.getAppPath("com.sample")+"\n");
        builder.append("isSystemApp---"+ SDAppUtil.isSystemApp()+"\n");
        builder.append("isAppDebug---"+ SDAppUtil.isAppDebug()+"\n");
        builder.append("isAppRoot---"+ SDAppUtil.isAppRoot()+"\n");
        builder.append("getAppSignature---"+ SDAppUtil.getAppSignature().toString()+"\n");
        builder.append("getAppSignature---"+ String.valueOf(SDAppUtil.getAppSignature("com.shuinsen.zhiri"))+"\n");
        builder.append("getAppSignatureSHA1---"+ SDAppUtil.getAppSignatureSHA1()+"\n");
        builder.append("getAppSignatureSHA1---"+ SDAppUtil.getAppSignatureSHA1()+"\n");
        builder.append("getAppSignatureSHA1---"+ SDAppUtil.getAppSignatureSHA1("com.shuinsen.zhiri")+"\n");
        builder.append("isAppInForeground---"+ SDAppUtil.isAppInForeground()+"\n");
        builder.append("isAppInForeground---"+ SDAppUtil.isAppInForeground("com.shuinsen.zhiri")+"\n");

        mTvContent.setText(builder);
        mIvIcon.setImageDrawable(SDAppUtil.getAppIcon("com.shuinsen.zhiri"));
    }

    private String getApkAll() {
        final ArrayList<String> apkNameAll = SDAppUtil.getApkNameAll();
        for (int i = 0; i < apkNameAll.size(); i++) {
            final String s = apkNameAll.get(i);
            SDLogUtil.d(TAG, "name---" + s);
            return s;
        }
        return null;
//        for (String a : apkNameAll) {
//            return a;
//        }
//        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.un_install_app:
//                SDAppUtil.unInstallApp("com.sample");
//                SDAppUtil.unInstallApp(this, "com.sample", 0);
                boolean b = SDAppUtil.uninstallAppSilent("com.shuinsen.zhiri", false);
                Log.d(TAG, "onClick: uninstallAppSilent:" + b);
                break;
            case R.id.install_app:
                InputStream abpath = getClass().getResourceAsStream("/assets/japanStory");
                try {
                    String path = new String(InputStreamToByte(abpath));
                    SDAppUtil.installApp(path, "com.sample.provider");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.setting_app:
                SDAppUtil.openAppSettings();
                break;
            case R.id.iv_icon:
                setResult(10);
                this.finish();
                break;
        }
    }

    private byte[] InputStreamToByte(InputStream is) throws IOException {
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        int ch;
        while ((ch = is.read()) != -1) {
            bytestream.write(ch);
        }
        byte imgdata[] = bytestream.toByteArray();
        bytestream.close();
        return imgdata;
    }


}
