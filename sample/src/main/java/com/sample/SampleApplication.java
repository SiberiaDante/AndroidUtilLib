package com.sample;

import android.app.Application;

import com.siberiadante.SiberiaDanteLib;

/**
 * Created by SiberiaDante on 2017/5/4.
 */

public class SampleApplication extends Application {
    public static SampleApplication appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        init();
    }

    private void init() {
        SiberiaDanteLib.initLib(appContext);
    }

    public static SampleApplication getAppContext() {
        return appContext;
    }
}
