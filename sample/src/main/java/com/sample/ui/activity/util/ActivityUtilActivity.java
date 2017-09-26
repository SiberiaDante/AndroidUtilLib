package com.sample.ui.activity.util;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sample.R;
import com.sample.SampleApplication;
import com.sample.constants.Constants;
import com.sample.ui.activity.BaseActivity;
import com.sample.ui.activity.SecondActivity;
import com.siberiadante.lib.util.SDActivityUtil;
import com.siberiadante.lib.util.SDLogUtil;

public class ActivityUtilActivity extends BaseActivity {

    private static final String TAG = ActivityUtilActivity.class.getSimpleName();
    private TextView mTvContent;
    private StringBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_util_test);
        initView();
        initData();
    }

    public void initView() {
        SDLogUtil.d("-------------" + SecondActivity.class.getName());
        mTvContent = (TextView) findViewById(R.id.tv_activity_test);
        findViewById(R.id.btn_start_other_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SDActivityUtil.startActivity(ActivityUtilActivity.this, SecondActivity.class);
            }
        });
        findViewById(R.id.start_browser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SDActivityUtil.startBrowser(Constants.URL_SIBERIA_DANTE_LIB);
            }
        });
    }

    public void initData() {
        builder = new StringBuilder();
        builder.append("1.SecondActivity是否存在---" + SDActivityUtil.isActivityExists("com.sample", SecondActivity.class.getName()) + "\n");
        builder.append("2.当前APP的启动Activity是---" + SDActivityUtil.getLauncherActivity("com.sample") + "\n");
        builder.append("3.包名为com.shuinsen.zhiri的APP的启动Activity是---" + SDActivityUtil.getLauncherActivity("com.shuinsen.zhiri") + "\n");
        mTvContent.setText(builder);
    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}
