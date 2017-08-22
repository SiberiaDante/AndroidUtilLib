package com.sample.ui.activity.util;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.AppUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
        mIvIcon = (ImageView) findViewById(R.id.iv_icon);
        Button mBtnUnInstallApp = (Button) findViewById(R.id.un_install_app);
        Button mBtnInstallApp = (Button) findViewById(R.id.install_app);
        Button mBtnAppSetting = (Button) findViewById(R.id.setting_app);
        mBtnUnInstallApp.setOnClickListener(this);
        mBtnInstallApp.setOnClickListener(this);
        mBtnAppSetting.setOnClickListener(this);
    }

    private void initData() {
        Log.d(TAG, "initData: " + AppUtil.getAppVersionCode());
        Log.d(TAG, "initData: " + AppUtil.getAppVersionName());
        Log.d(TAG, "initData: " + AppUtil.getAndroidSystemVersion());
        Log.d(TAG, "initData: " + AppUtil.getMobilePhoneTypeInfo());
        Log.d(TAG, "initData: " + AppUtil.getMobileAndAPPInfo());
        Log.d(TAG, "initData: getAppPackageName:" + AppUtil.getAppPackageName());
        Log.d(TAG, "initData: isInstalledApp:" + AppUtil.isInstalledApp());
        Log.d(TAG, "initData: AppName:" + AppUtil.getAppName());
        Log.d(TAG, "initData: getAppPath:" + AppUtil.getAppPath());
        Log.d(TAG, "initData: getAppPath:" + AppUtil.getAppPath("com.sample"));
        Log.d(TAG, "initData: isSystemApp:" + AppUtil.isSystemApp());
        Log.d(TAG, "initData: isAppDebug:" + AppUtil.isAppDebug());
        Log.d(TAG, "initData: isAppRoot:" + AppUtil.isAppRoot());
        Log.d(TAG, "initData: getAppSignature:" + AppUtil.getAppSignature().toString());
        Log.d(TAG, "initData: getAppSignature:" + String.valueOf(AppUtil.getAppSignature("com.shuinsen.zhiri")));
        Log.d(TAG, "initData: getAppSignatureSHA1:" + AppUtil.getAppSignatureSHA1());
        Log.d(TAG, "initData: getAppSignatureSHA1:" + AppUtil.getAppSignatureSHA1("com.shuinsen.zhiri"));
        Log.d(TAG, "initData: isAppForeground:" + AppUtil.isAppInForeground());
        Log.d(TAG, "initData: isAppForeground:" + AppUtil.isAppInForeground("com.shuinsen.zhiri"));
        mIvIcon.setImageDrawable(AppUtil.getAppIcon("com.shuinsen.zhiri"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.un_install_app:
//                AppUtil.unInstallApp("com.sample");
//                AppUtil.unInstallApp(this, "com.sample", 0);
                boolean b = AppUtil.uninstallAppSilent("com.shuinsen.zhiri", false);
                Log.d(TAG, "onClick: uninstallAppSilent:"+b);
                break;
            case R.id.install_app:
                InputStream abpath = getClass().getResourceAsStream("/assets/japanStory");
                try {
                    String path = new String(InputStreamToByte(abpath));
                    AppUtil.installApp(path, "com.sample.provider");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.setting_app:
                AppUtil.openAppDetailsSettings();
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
