package com.siberiadante.custom.ui;

import android.app.Application;

import com.siberiadante.lib.SiberiaDanteLib;
import com.siberiadante.custom.constant.AppConfig;

/**
 * @Created SiberiaDante
 * @Describe： 这是一个通用的APP框架的搭建，开发中可以直接拿来使用
 * 1、已完成Retrofit+RXJava的封装
 * 2、使用RadioButton+FrameLayout完成界面栏目的搭建
 * 3、使用
 * @Time: 2017/8/7
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class MyApplication extends Application {
    private static MyApplication mInstance;

    public static MyApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initSiberiaDante();
    }

    private void initSiberiaDante() {
        SiberiaDanteLib.initLib(mInstance);
        SiberiaDanteLib.setDebug(AppConfig.isDebug);
    }
}
