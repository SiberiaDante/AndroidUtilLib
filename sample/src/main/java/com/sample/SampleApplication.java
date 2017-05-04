package com.sample;

import android.app.Application;

import com.siberiadante.util.Toast;

/**
 * Created by SiberiaDante on 2017/5/4.
 */

public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }
    private void init() {
        Toast.init(this);
    }
}
