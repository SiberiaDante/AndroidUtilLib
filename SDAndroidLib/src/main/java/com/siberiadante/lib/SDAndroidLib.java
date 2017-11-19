package com.siberiadante.lib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.siberiadante.lib.constants.SDAppInfo;
import com.siberiadante.lib.util.SDDateUtil;

/**
 * Created by SiberiaDante on 2017/5/10.
 * user this lib,you should init it first：context
 */

public final class SDAndroidLib {
    public static final String TAG = SDAndroidLib.class.getSimpleName();
    @SuppressLint("StaticFieldLeak")
    private static Context context;
//    @SuppressLint("StaticFieldLeak")
//    public static Activity sTopActivity;//Activity
//    public static List<Activity> sActivityList = new LinkedList<>();

    public SDAndroidLib() {
        throw new UnsupportedOperationException("not init SDAndroidLib");
    }

    /**
     * 初始化
     *
     * @param context
     */
    public static void initLib(Context context) {
        SDAndroidLib.context = context.getApplicationContext();
    }

    /**
     * 日志输出控制
     *
     * @param isDebug
     */
    public static void setDebug(boolean isDebug) {
        SDAppInfo.getInstance().getSPUtils().put("is_debug", isDebug);
        Log.e(TAG, "[---" + SDDateUtil.getSDFTimeYMDHSM() + "---] Enable Debug:--- " + isDebug + " ---");
    }

    /**
     * @return Application Context
     */
    public static Context getContext() {
        if (context != null) {
            return context;
        } else {
            throw new NullPointerException("Use this lib,you need init first! In your Application: SDAndroidLib.initLib(appContext);");
        }
    }
//    private static Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
//        @Override
//        public void onActivityCreated(Activity activity, Bundle bundle) {
//            sActivityList.add(activity);
//
//
//        }
//
//        @Override
//        public void onActivityStarted(Activity activity) {
//
//        }
//
//        @Override
//        public void onActivityResumed(Activity activity) {
//
//        }
//
//        @Override
//        public void onActivityPaused(Activity activity) {
//
//        }
//
//        @Override
//        public void onActivityStopped(Activity activity) {
//
//        }
//
//        @Override
//        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
//
//        }
//
//        @Override
//        public void onActivityDestroyed(Activity activity) {
//            sActivityList.remove(activity);
//
//        }
//    };

}
