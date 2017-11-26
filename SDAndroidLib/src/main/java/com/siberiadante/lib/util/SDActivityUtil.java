package com.siberiadante.lib.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.Nullable;

import com.siberiadante.lib.SDAndroidLib;

import java.util.List;

/**
 * @Created SiberiaDante
 * @Describe： Activity相关工具类
 * @Time: 2017/5/10.
 * @UpDate:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDActivityUtil {
    public SDActivityUtil() {
        throw new UnsupportedOperationException("not init SDAndroidLib");
    }

    /**
     * 通过浏览器打开一个链接
     *
     * @param url
     */
    public static void startBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        SDAndroidLib.getContext().startActivity(intent);
    }


    /**
     * 启动一个Activity
     *
     * @param cls class name
     */
    public static void startActivity(final Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 启动一个传值Bundle的Activity
     *
     * @param cls    class name
     * @param extras bundle
     */
    public static void startActivity(final Class<?> cls,
                                     final Bundle extras) {
        startActivity(SDAndroidLib.getContext(), SDAndroidLib.getContext().getPackageName(), cls.getName(), extras, null);
    }

    /**
     * 启动一个包含动画的Activity
     *
     * @param options 动画
     * @param cls
     */
    public static void startActivity(final Bundle options,
                                     final Class<?> cls) {
        startActivity(SDAndroidLib.getContext(), SDAndroidLib.getContext().getPackageName(), cls.getName(), null, options);
    }

    /**
     * @param cls     class name
     * @param extras  bundle
     * @param options bundle
     */
    public static void startActivity(final Class<?> cls,
                                     final Bundle extras,
                                     final Bundle options) {
        startActivity(SDAndroidLib.getContext(), SDAndroidLib.getContext().getPackageName(), cls.getName(), extras, options);
    }


    /**
     * @param context context
     * @param pkg     package name
     * @param cls     class name
     * @param extras  bundle
     * @param options Additional options for how the Activity should be started.
     *                May be null if there are no options.  See {@link android.app.ActivityOptions}
     *                for how to build the Bundle supplied here; there are no supported definitions
     *                for building it manually.
     */
    private static void startActivity(final Context context,
                                      final String pkg,
                                      final String cls,
                                      final Bundle extras,
                                      final Bundle options) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.setComponent(new ComponentName(pkg, cls));
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        if (options != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            context.startActivity(intent, options);
        } else {
            context.startActivity(intent);
        }
    }

    /**
     * 包含启动动画，支持API16以下
     *
     * @param activity  activity
     * @param cls       class name
     * @param enterAnim enter anim
     * @param exitAnim  exit anim
     */
    public static void startActivity(final Activity activity,
                                     final String cls,
                                     @AnimRes final int enterAnim,
                                     @AnimRes final int exitAnim) {
        startActivity(activity, SDAndroidLib.getContext().getPackageName(), cls, null, enterAnim, exitAnim);
    }

    /**
     * @param activity  activity
     * @param pkg       package name
     * @param cls       class name
     * @param extras    bundle
     * @param enterAnim enter anim
     * @param exitAnim  exit anim
     */
    public static void startActivity(final Activity activity,
                                     final String pkg,
                                     final String cls,
                                     final Bundle extras,
                                     @AnimRes final int enterAnim,
                                     @AnimRes final int exitAnim) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.setComponent(new ComponentName(pkg, cls));
        activity.startActivity(intent);
        activity.overridePendingTransition(enterAnim, exitAnim);
    }

    /**
     * @param packageName  应用包名应用包名应用包名应用包名
     * @param activityName activity全路径名
     * @return true 存在；false 不存在
     */
    public static boolean isActivityExists(@Nullable String packageName, @Nullable String activityName) {
        Intent intent = new Intent();
        intent.setClassName(packageName, activityName);
        PackageManager packageManager = SDAndroidLib.getContext().getPackageManager();
        boolean b = packageManager.resolveActivity(intent, 0) == null ||
                packageManager.queryIntentActivities(intent, 0).size() == 0 ||
                intent.resolveActivity(packageManager) == null;
        return !b;

    }

    /**
     * 获取launcher activity
     *
     * @param packageName 应用包名
     * @return 应用启动的 activity
     */
    public static String getLauncherActivity(String packageName) {
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PackageManager packageManager = SDAndroidLib.getContext().getPackageManager();
        List<ResolveInfo> infos = packageManager.queryIntentActivities(intent, 0);
        for (ResolveInfo info : infos) {
            if (info.activityInfo.packageName.equals(packageName)) {
                return info.activityInfo.name;
            }
        }
        return "No APP exits for PackName equals: " + packageName;
    }
}
