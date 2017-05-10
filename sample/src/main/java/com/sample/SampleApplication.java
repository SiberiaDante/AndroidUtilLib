package com.sample;

import android.app.Application;

import com.siberiadante.SiberiaDanteLib;
import com.siberiadante.util.Toast;

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
        Toast.init(this);
        SiberiaDanteLib.initLib(appContext);
    }

    public static SampleApplication getAppContext() {
        return appContext;
    }
}
