package com.siberiadante.utilsample.activity;

import android.os.Bundle;

import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.androidutil.util.SDObjectUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;
import com.siberiadante.utilsample.bean.MainData;

public class SDObjectUtilActivity extends BaseActivity {

    private static final java.lang.String TAG = SDObjectUtilActivity.class.getSimpleName();
    private String str;
    private String str1="SiberiaDante";
    private int number;
    private MainData mainData;


    @Override
    public int setLayoutId() {
        return R.layout.activity_sd_object_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        SDLogUtil.d(TAG, "---str是否为空对象---"+ SDObjectUtil.isEmpty(str));
        SDLogUtil.d(TAG, "---str1是否为空对象---"+ SDObjectUtil.isEmpty(str1));
        SDLogUtil.d(TAG, "---number是否为空对象---"+ SDObjectUtil.isEmpty(number));
        SDLogUtil.d(TAG, "---mainData是否为空对象---"+ SDObjectUtil.isEmpty(mainData));


    }
}
