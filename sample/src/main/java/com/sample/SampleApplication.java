package com.sample;

import android.app.Activity;
import android.app.Application;

import com.siberiadante.SiberiaDanteLib;
import com.siberiadante.util.CrashHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by SiberiaDante on 2017/5/4.
 */

public class SampleApplication extends Application {
    public static SampleApplication appContext;
    private List<Activity> mList = new LinkedList<Activity>();
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
        appContext = this;
        initSiberiaDanteLib();
//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(getApplicationContext());
    }

    // add all of activity to list
    public void addActivity(Activity activity) {
        mList.add(activity);
    }

    /**
     * exit app
     */
    public void exitApp() {
        try {
            for (Activity activity : mList) {
                if (activity != null) {
                    activity.finish();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    private void initSiberiaDanteLib() {
        SiberiaDanteLib.initLib(appContext);
    }


}
