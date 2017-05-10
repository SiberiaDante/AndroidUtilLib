package com.siberiadante.util;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import com.siberiadante.SiberiaDanteLib;
import com.siberiadante.exception.SiberiaDanteLibException;

/**
 * Created by SiberiaDante on 2017/5/10.
 */

public class ActivityUtil {
    public ActivityUtil() {
//        throw new UnsupportedOperationException("unInit SiberiaDanteLib");
        new SiberiaDanteLibException();
    }

    /**
     * 启动一个不需要传值的Activity
     *
     * @param packageName  包名
     * @param activityName 启动的activity的全路径名
     */
    public static void launchActivity(String packageName, String activityName) {
        launchActivity(packageName, activityName, null);

    }

    /**
     * 启动一个需要传值的Activity，
     *
     * @param packageName  包名
     * @param activityName 启动的activity的全路径名
     * @param bundle       页面传值
     */
    public static void launchActivity(String packageName, String activityName, Bundle bundle) {
        SiberiaDanteLib.getContext().startActivity(getComponentIntent(packageName, activityName, bundle));
    }

    /**
     *
     * @param packageName   应用包名
     * @param activityName  activity全路径名
     * @return  true 存在；false 不存在
     */
    public static boolean isActivityExists(String packageName, String activityName) {
        Intent intent = new Intent();
        intent.setClassName(packageName, activityName);
        boolean b = SiberiaDanteLib.getContext().getPackageManager().resolveActivity(intent, 0) == null ||
                SiberiaDanteLib.getContext().getPackageManager().queryIntentActivities(intent, 0).size() == 0 ||
                intent.resolveActivity(SiberiaDanteLib.getContext().getPackageManager()) == null;
        return !b;

    }

    private static Intent getComponentIntent(String packageName, String activityName, Bundle bundle) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        ComponentName componentName = new ComponentName(packageName, activityName);
        intent.setComponent(componentName);
        return intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

    }
}
