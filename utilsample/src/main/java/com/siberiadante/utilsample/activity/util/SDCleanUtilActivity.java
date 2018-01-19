package com.siberiadante.utilsample.activity.util;

import android.os.Bundle;

import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

public class SDCleanUtilActivity extends BaseActivity {

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdclean_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle("SDCacheUtil-SDCleanUtil-SDStorageUtil");
        final StringBuilder builder = new StringBuilder();
        builder.append("获取当前APP缓存：");

    }
}
