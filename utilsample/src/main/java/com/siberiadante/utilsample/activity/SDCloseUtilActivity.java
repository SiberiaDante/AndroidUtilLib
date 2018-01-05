package com.siberiadante.utilsample.activity;

import android.os.Bundle;

import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

public class SDCloseUtilActivity extends BaseActivity {

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdclose_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle(R.string.sd_close_util);
    }
}
