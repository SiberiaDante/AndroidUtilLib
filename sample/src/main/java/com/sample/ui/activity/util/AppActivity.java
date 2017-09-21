package com.sample.ui.activity.util;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        initView();
        initData();
    }

    private void initView() {
        SDLogUtil.d(TAG, "---" + getClass().getSimpleName() + "----------");
        mIvIcon = (ImageView) findViewById(R.id.iv_icon);
        Button mBtnUnInstallApp = (Button) findViewById(R.id.un_install_app);
        Button mBtnInstallApp = (Button) findViewById(R.id.install_app);
        Button mBtnAppSetting = (Button) findViewById(R.id.setting_app);
        mBtnUnInstallApp.setOnClickListener(this);
        mBtnInstallApp.setOnClickListener(this);
        mBtnAppSetting.setOnClickListener(this);
        mIvIcon.setOnClickListener(this);
    }

    private void initData() {
        Log.d(TAG, "initData: " + SDAppUtil.getAppVersionCode());
        Log.d(TAG, "initData: " + SDAppUtil.getAppVersionName());
        Log.d(TAG, "initData: " + SDAppUtil.getAndroidSystemVersion());
        Log.d(TAG, "initData: " + SDAppUtil.getMobilePhoneTypeInfo());
        Log.d(TAG, "initData: " + SDAppUtil.getMobileAndAPPInfo());
        Log.d(TAG, "initData: getAppPackageName:" + SDAppUtil.getAppPackageName());
        Log.d(TAG, "initData: isInstalledApp:" + SDAppUtil.isInstalledApp());
        Log.d(TAG, "initData: AppName:" + SDAppUtil.getAppName());
        Log.d(TAG, "initData: getAppPath:" + SDAppUtil.getAppPath());
        Log.d(TAG, "initData: getAppPath:" + SDAppUtil.getAppPath("com.sample"));
        Log.d(TAG, "initData: isSystemApp:" + SDAppUtil.isSystemApp());
        Log.d(TAG, "initData: isAppDebug:" + SDAppUtil.isAppDebug());
        Log.d(TAG, "initData: isAppRoot:" + SDAppUtil.isAppRoot());
        Log.d(TAG, "initData: getAppSignature:" + SDAppUtil.getAppSignature().toString());
        Log.d(TAG, "initData: getAppSignature:" + String.valueOf(SDAppUtil.getAppSignature("com.shuinsen.zhiri")));
        Log.d(TAG, "initData: getAppSignatureSHA1:" + SDAppUtil.getAppSignatureSHA1());
        Log.d(TAG, "initData: getAppSignatureSHA1:" + SDAppUtil.getAppSignatureSHA1("com.shuinsen.zhiri"));
        Log.d(TAG, "initData: isAppForeground:" + SDAppUtil.isAppInForeground());
        Log.d(TAG, "initData: isAppForeground:" + SDAppUtil.isAppInForeground("com.shuinsen.zhiri"));
//        SDLogUtil.d(TAG, "getApkNameAll=" + getApkAll());
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
                SDAppUtil.openAppDetailsSettings();
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
