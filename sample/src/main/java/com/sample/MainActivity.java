package com.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sample.activity.Main2Activity;
import com.siberiadante.util.ActivityUtil;
import com.siberiadante.util.NetWorkUtil;
import com.siberiadante.util.ScreenUtil;
import com.siberiadante.util.ToastUtil;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScreenUtil.init(this);
        ToastUtil.showSingletonLong(String.valueOf(ScreenUtil.ScreenHeight));

        initView();
        testOne();
        testNetworkUtil();
    }

    private void testNetworkUtil() {
        Log.d(TAG, "testNetworkUtil:isNetWorkConnected? " + NetWorkUtil.isNetWorkConnected());
        Log.d(TAG, "testNetworkUtil: isWifiConnected?" + NetWorkUtil.isWifiConnected());
        Log.d(TAG, "testNetworkUtil:getNetworkState= " + NetWorkUtil.getNetworkState());
        Button mBtnOpenSetting = (Button) findViewById(R.id.btn_network_open_setting);
        mBtnOpenSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetWorkUtil.openNetworkSettings();
            }
        });

    }

    private void testOne() {
        boolean activityExists = ActivityUtil.isActivityExists("com.sample", Main2Activity.class.getName());
        Log.d(TAG, "testOne: activityExists:" + Main2Activity.class.getName() + "activityExists???" + activityExists);
    }

    private void initView() {
        Button mBtnStartActivity = (Button) findViewById(R.id.btn_start_other_activity);
        mBtnStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ActivityUtil.launchActivity("com.sample", Main2Activity.class.getName());
                ToastUtil.cancelAll();
            }
        });
        Button mBtnToastImage = (Button) findViewById(R.id.btn_toast_image_center);
        mBtnToastImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ToastUtil.showSingletonImageCenter(R.mipmap.ic_launcher, Toast.LENGTH_SHORT);
                ToastUtil.showImage(R.mipmap.ic_launcher, Toast.LENGTH_SHORT, Gravity.BOTTOM | Gravity.LEFT);
            }
        });
    }

}
