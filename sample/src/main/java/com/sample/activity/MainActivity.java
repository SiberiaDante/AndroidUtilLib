package com.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sample.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    public void initView() {
        Button mBtnActivityUtil = (Button) findViewById(R.id.start_activity_activity_util);
        Button mBtnScreenUtil = (Button) findViewById(R.id.start_activity_screen_util);
        Button mBtnNetworkUtil = (Button) findViewById(R.id.start_activity_network_util);
        Button mBtnToastUtil = (Button) findViewById(R.id.start_activity_toast_util);
        Button mBtnAppUtil = (Button) findViewById(R.id.start_activity_app_util);

        mBtnActivityUtil.setOnClickListener(this);
        mBtnScreenUtil.setOnClickListener(this);
        mBtnNetworkUtil.setOnClickListener(this);
        mBtnToastUtil.setOnClickListener(this);
        mBtnAppUtil.setOnClickListener(this);

    }

    public void initData() {

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.start_activity_screen_util:
                intent = new Intent(this, ScreenActivity.class);
                break;
            case R.id.start_activity_activity_util:
                intent = new Intent(this, ActivityUtilActivity.class);
                break;
            case R.id.start_activity_network_util:
                intent = new Intent(this, NetworkActivity.class);
                break;
            case R.id.start_activity_toast_util:
                intent = new Intent(this, ToastActivity.class);
                break;
            case R.id.start_activity_app_util:
                intent = new Intent(this, AppActivity.class);
                break;
        }
        startActivity(intent);
    }
}
