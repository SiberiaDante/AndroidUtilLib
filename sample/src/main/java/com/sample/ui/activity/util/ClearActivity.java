package com.sample.ui.activity.util;

import android.os.Bundle;
import android.util.Log;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.SDClearUtil;

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
        Log.d(TAG, "initData: clearInternalCache=" + SDClearUtil.clearInternalCache());
        Log.d(TAG, "initData: clearInternalFiles=" + SDClearUtil.clearInternalFiles());
        Log.d(TAG, "initData: clearInternalDbs=" + SDClearUtil.clearInternalDbs());
        Log.d(TAG, "initData: clearInternalDbByName(String dbName)=" + SDClearUtil.clearInternalDbByName("www"));
        Log.d(TAG, "initData: clearInternalSP=" + SDClearUtil.clearInternalSP());
        Log.d(TAG, "initData: " + SDClearUtil.clearCustomCache(""));
        Log.d(TAG, "initData: " + SDClearUtil.clearCustomCache(file));


    }
}
