package com.sample.ui.activity.util;

import android.os.Bundle;
import android.util.Log;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.SDCleanUtil;

import java.io.File;

public class ClearActivity extends BaseActivity {
    public static final String TAG = ClearActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear);
        initView();
        initData();
    }

    private void initView() {

    }

    private void initData() {
        File file = new File("");
        Log.d(TAG, "initData: clearInternalCache=" + SDCleanUtil.cleanInternalCache());
        Log.d(TAG, "initData: clearInternalFiles=" + SDCleanUtil.cleanInternalFiles());
        Log.d(TAG, "initData: clearInternalDbs=" + SDCleanUtil.cleanInternalDbs());
        Log.d(TAG, "initData: clearInternalDbByName(String dbName)=" + SDCleanUtil.cleanInternalDbByName("www"));
        Log.d(TAG, "initData: clearInternalSP=" + SDCleanUtil.cleanInternalSP());
        Log.d(TAG, "initData: " + SDCleanUtil.cleanCustomCache(""));
        Log.d(TAG, "initData: " + SDCleanUtil.cleanCustomCache(file));


    }
}
