package com.sample.ui.activity.util;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.ScreenUtil;

public class ScreenActivity extends BaseActivity {

    private static final String TAG = ScreenActivity.class.getSimpleName();
    private TextView mTvScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_test);
        ScreenUtil.setStatusTranslucent(this);
        initView();
        initData();
    }

    public void initView() {
        mTvScreen = (TextView) findViewById(R.id.tv_screen_content);

    }

    public void initData() {
        int screenWidth = ScreenUtil.getScreenWidthPx();
        int screenHeight = ScreenUtil.getScreenHeightPx();
        int screenWidthDp = ScreenUtil.getScreenWidthDp();
        int screenHeightDp = ScreenUtil.getScreenHeightDp();
        float density = ScreenUtil.getDensity(this);
        Log.d(TAG, "initData: density=" + density);
        Log.d(TAG, "initData:screenWidthPX= " + screenWidth + "px");
        Log.d(TAG, "initData:screenHeightPX= " + screenHeight + "px");
        Log.d(TAG, "initData:screenWidthDp= " + screenWidthDp + "dp");
        Log.d(TAG, "initData:screenHeightDp= " + screenHeightDp + "dp");
        final StringBuilder builder = new StringBuilder();
        builder.append("screenWidthPX=");
        builder.append(screenWidth);
        builder.append("\n");
        builder.append("screenHeightPX=");
        builder.append(screenHeight);
        builder.append("\n");

        builder.append("screenWidthDp=");
        builder.append(screenWidthDp);
        builder.append("\n");

        builder.append("screenHeightDp=");
        builder.append(screenHeightDp);

        mTvScreen.setText(builder.toString());
    }
}
