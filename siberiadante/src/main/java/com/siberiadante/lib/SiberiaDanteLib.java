package com.siberiadante.lib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.siberiadante.lib.constants.AppInfo;
import com.siberiadante.lib.util.DateUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by SiberiaDante on 2017/5/10.
 * user this lib,you should init it first：context
 */

public final class SiberiaDanteLib {
    private static final String TAG = "SiberiaDanteLib";
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    public static List<Activity> sActivityList = new LinkedList<>();//打开的Activity集合
    @SuppressLint("StaticFieldLeak")
    public static Activity sTopActivity;//Activity

    public SiberiaDanteLib() {
        throw new UnsupportedOperationException("not init SiberiaDanteLib");
    }

    /**
     * 初始化
     *
     * @param context
     */
    public static void initLib(Context context) {
        SiberiaDanteLib.context = context.getApplicationContext();
    }

    /**
     * 日志输出控制
     *
     * @param isDebug
     */
    public static void setDebug(boolean isDebug) {
        Log.e("eeeeeeeeeeeee","");
        AppInfo.getInstance().getSPUtils().put("is_debug", isDebug);
        Log.e(TAG, "[---" + DateUtil.getSDFTimeYMDHSM() + "---] Enable Debug:--- " + isDebug + " ---");
    }


    public static Context getContext() {
        if (context != null) {
            return context;
        } else {
            throw new NullPointerException(context.getString(R.string.NotInitError));

        }
    }

    private static Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            sActivityList.add(activity);

        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {
            sTopActivity = activity;

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            sActivityList.remove(activity);

        }
    };
}
