package com.sample.ui.activity.util;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.sample.ui.activity.SecondActivity;
import com.siberiadante.lib.util.ActivityUtil;

public class ActivityUtilActivity extends BaseActivity {

    private static final String TAG = ActivityUtilActivity.class.getSimpleName();
    private TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_util_test);
        initView();
        initData();
    }

    public void initView() {
        mTvContent = (TextView) findViewById(R.id.tv_activity_test);
        findViewById(R.id.btn_start_other_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtil.launchActivity("com.sample", SecondActivity.class.getName());
            }
        });
    }

    public void initData() {
        final StringBuilder builder = new StringBuilder();
        builder.append("1.包名'com.sample'的SecondActivity是否存在---");
        builder.append(ActivityUtil.isActivityExists("com.sample", SecondActivity.class.getName()) + "\n");

        mTvContent.setText(builder);
        String launcherActivity = ActivityUtil.getLauncherActivity("com.sample");
        Log.d(TAG, "initData: launcherActivity==" + launcherActivity);
        Activity topActivity = ActivityUtil.getTopActivity();
        Log.d(TAG, "initData: topActivity==" + topActivity);
    }
}
