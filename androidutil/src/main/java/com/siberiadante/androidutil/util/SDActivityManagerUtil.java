package com.siberiadante.androidutil.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import com.siberiadante.androidutil.SDAndroidLib;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created: SiberiaDante
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * Blog: http://www.cnblogs.com/shen-hua/
 * CreateTime: 2018/02/27.
 * UpDateTime:
 * Describe： ActivityManager Utils,
 */
public class SDActivityManagerUtil {
    private static Stack<Activity> activitys;

    private SDActivityManagerUtil() {
        throw new UnsupportedOperationException("---" + SDActivityManagerUtil.class.getName() + "---not init com.github.SiberiaDante:AndroidUtilLib");
    }

    public static SDActivityManagerUtil getInstance() {
        return SDActivityManagerHolder.activityManager;
    }

    /**
     * 向栈中添加一个Activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (activitys == null) {
            activitys = new Stack<>();
        }
        activitys.add(activity);
    }

    /**
     * 移除栈中的某一个Activity
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        if (activitys.contains(activity)) {
            activitys.remove(activity);
        }
    }

    /**
     * 移除栈中的某一个Activity并销毁
     *
     * @param activity
     */
    public void removeAndFinishActivity(Activity activity) {
        if (activity != null) {
            if (activitys.contains(activity)) {
                activitys.remove(activity);
            }
            activity.finish();
            activity = null;
        }
    }

    /**
     * 获取栈顶/当前的Activity
     *
     * @return
     */
    public Activity currentActivity() {
        return activitys.lastElement();
    }

    /**
     * 移除栈顶/当前的Activity
     */
    public void removeCurrentActivity() {
        Activity activity = activitys.lastElement();
        if (activitys.contains(activity)) {
            activitys.remove(activity);
        }
    }

    /**
     * 移除栈顶的Activity并销毁
     */
    public void removeAndFinishCurrentActivity() {
        Activity activity = activitys.lastElement();
        if (activitys.contains(activity)) {
            activitys.remove(activity);
        }
        activity.finish();
        activity = null;
    }

    /**
     * 退出应用程序
     * 需求要权限{@code uses-permission android:name="android.permission.KILL_BACKGROUND_PROCESSES"}
     */
    public void appExit() {
        try {
            finishAllActivity();
            ActivityManager activityMgr = (ActivityManager) SDAndroidLib.getContext().getSystemService(Context.ACTIVITY_SERVICE);
            if (activityMgr != null) {
                activityMgr.killBackgroundProcesses(SDAndroidLib.getContext().getPackageName());
            }
//            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 结束栈中所有的Activity
     */
    public void finishAllActivity() {
        for (Activity activity : activitys) {
            if (activity != null) {
                activity.finish();
            }
        }
        activitys.clear();
    }

    private static class SDActivityManagerHolder {
        private static final SDActivityManagerUtil activityManager = new SDActivityManagerUtil();
    }
}
