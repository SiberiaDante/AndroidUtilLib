package com.sample.ui.activity.util;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.sample.ui.activity.Main2Activity;
import com.siberiadante.util.ActivityUtil;

public class ActivityUtilActivity extends BaseActivity {

    private static final String TAG = ActivityUtilActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_util_test);
        initView();
        initData();
    }

    public void initView() {
        Button mBtnStartActivity = (Button) findViewById(R.id.btn_start_other_activity);
        mBtnStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtil.launchActivity("com.sample", Main2Activity.class.getName());
            }
        });
    }

    public void initData() {
        boolean activityExists = ActivityUtil.isActivityExists("com.sample", Main2Activity.class.getName());
        Log.d(TAG, "testOne: activityExists:" + Main2Activity.class.getName() + "activityExists???" + activityExists);
        String launcherActivity = ActivityUtil.getLauncherActivity("com.sample");
        Log.d(TAG, "initData: launcherActivity=="+launcherActivity);
        Activity topActivity = ActivityUtil.getTopActivity();
        Log.d(TAG, "initData: topActivity=="+topActivity);
    }
}
