package com.sample.ui.activity.util;

import android.os.Bundle;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.SDLogUtil;

public class LogUtilActivity extends BaseActivity {

    private static final String TAG = LogUtilActivity.class.getSimpleName();

    @Override
    public int setLayoutId() {
        return R.layout.activity_log_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        SDLogUtil.showSquareLogE(TAG, "saskflasffffffffffffafpokfkjksdssssssssssssjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
    }

    @Override
    public void initData() {

    }
}
