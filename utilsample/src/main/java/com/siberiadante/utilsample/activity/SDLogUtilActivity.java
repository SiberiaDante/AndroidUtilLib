package com.siberiadante.utilsample.activity;

import android.os.Bundle;

import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

public class SDLogUtilActivity extends BaseActivity {
    public static final String TAG = SDLogUtilActivity.class.getSimpleName();

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdlog_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle(R.string.sd_log_util);
        SDLogUtil.d("默认TAG：SDLogUtil");
        SDLogUtil.d(TAG, "自定义TAG");
        SDLogUtil.e(TAG,"ErrorErrorErrorErrorErrorError");
        SDLogUtil.i(TAG,"InfoInfoInfoInfoInfoInfoInfoInfo");
        SDLogUtil.printTimeLogD(TAG,"带时间的日志输出");
        SDLogUtil.printTimeLogE(TAG,"带时间的日志输出");
        SDLogUtil.printTimeLogI(TAG,"带时间的日志输出");
        SDLogUtil.showSquareLogE(TAG,"showSquareLogE-showSquareLogE-showSquareLogE-showSquareLogE");

    }
}
