package com.sample.activity;

import android.os.Bundle;
import android.util.Log;

import com.sample.R;
import com.siberiadante.util.ScreenUtil;

public class ScreenActivity extends BaseActivity {

    private static final String TAG = ScreenActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_test);
        initView();
        initData();
    }

    public void initView() {

    }

    public void initData() {
        int screenWidth = ScreenUtil.getScreenWidthPx(this);
        int screenHeight = ScreenUtil.getScreenHeightPx(this);
        int screenWidthDp = ScreenUtil.getScreenWidthDp(this);
        int screenHeightDp = ScreenUtil.getScreenHeightDp(this);
        float density = ScreenUtil.getDensity(this);
        Log.d(TAG, "initData: density="+density);
        Log.d(TAG, "initData:screenWidth= " + screenWidth+"px");
        Log.d(TAG, "initData:screenHeight= " + screenHeight+"px");
        Log.d(TAG, "initData:screenWidthDp= " + screenWidthDp+"dp");
        Log.d(TAG, "initData:screenHeightDp= " + screenHeightDp+"dp");
    }
}
