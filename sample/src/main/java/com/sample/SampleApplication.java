package com.sample;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.multidex.MultiDex;

import com.siberiadante.lib.SiberiaDanteLib;
import com.squareup.leakcanary.LeakCanary;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by SiberiaDante on 2017/5/4.
 */

public class SampleApplication extends Application {

    private static SampleApplication instance;

    public SampleApplication() {
    }

    public synchronized static SampleApplication getInstance() {
        if (null == instance) {
            instance = new SampleApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        instance = this;
        initSiberiaDanteLib();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
//        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
//            @Override
//            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
//                mList.add(activity);
//                mTopActivity = activity;
//
//            }
//
//            @Override
//            public void onActivityStarted(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityResumed(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityPaused(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityStopped(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
//
//            }
//
//            @Override
//            public void onActivityDestroyed(Activity activity) {
//
//            }
//        });
    }

    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    private void initSiberiaDanteLib() {
        SiberiaDanteLib.initLib(instance);
        SiberiaDanteLib.setDebug(true);

    }


}
