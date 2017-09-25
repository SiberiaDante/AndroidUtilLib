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
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.ArrayMap;

import com.siberiadante.lib.SiberiaDanteLib;
import com.siberiadante.lib.exception.SiberiaDanteLibException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by SiberiaDante on 2017/5/10.
 * Activity相关工具类
 */

public class SDActivityUtil {

    private static Stack<Activity> activityStack;


    public SDActivityUtil() {
        new SiberiaDanteLibException();
    }

    /**
     * 通过浏览器打开一个链接
     *
     * @param url
     */
    public static void startBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        SiberiaDanteLib.getContext().startActivity(intent);
    }

    /**
     * 启动Activity
     *
     * @param cls activity类
     */
    public static void startActivity(@NonNull final Class<?> cls) {
        Context context = SiberiaDanteLib.getContext();
        startActivity(context, null, context.getPackageName(), cls.getName(), null);
    }

    /**
     * 启动Activity
     *
     * @param activity activity
     * @param cls      activity类
     */
    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final Class<?> cls) {
        startActivity(activity, null, activity.getPackageName(), cls.getName(), null);
    }

    /**
     * 启动Activity
     *
     * @param cls     activity类
     * @param options 跳转动画
     */
    public static void startActivity(@NonNull final Class<?> cls,
                                     @NonNull final Bundle options) {
        Context context = SiberiaDanteLib.getContext();
        startActivity(context, null, context.getPackageName(), cls.getName(), options);
    }

    /**
     * 启动Activity
     *
     * @param activity activity
     * @param cls      activity类
     * @param options  跳转动画
     */
    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final Class<?> cls,
                                     @NonNull final Bundle options) {
        startActivity(activity, null, activity.getPackageName(), cls.getName(), options);
    }


    /**
     * 启动Activity
     *
     * @param extras extras
     * @param cls    activity类
     */
    public static void startActivity(@NonNull final Bundle extras,
                                     @NonNull final Class<?> cls) {
        startActivity(SiberiaDanteLib.getContext(), extras, SiberiaDanteLib.getContext().getPackageName(), cls.getName(), null);
    }

    /**
     * 启动Activity
     *
     * @param extras   extras
     * @param activity activity
     * @param cls      activity类
     */
    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final Bundle extras,
                                     @NonNull final Class<?> cls) {
        startActivity(activity, extras, activity.getPackageName(), cls.getName(), null);
    }

    /**
     * 启动Activity
     *
     * @param pkg 包名
     * @param cls 全类名
     */
    public static void startActivity(@NonNull final String pkg,
                                     @NonNull final String cls) {
        startActivity(SiberiaDanteLib.getContext(), null, pkg, cls, null);
    }

    /**
     * 启动Activity
     *
     * @param activity activity
     * @param pkg      包名
     * @param cls      全类名
     */
    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final String pkg,
                                     @NonNull final String cls) {
        startActivity(activity, null, pkg, cls, null);
    }

    /**
     * 启动Activity
     *
     * @param pkg     包名
     * @param cls     全类名
     * @param options 动画
     */
    public static void startActivity(@NonNull final String pkg,
                                     @NonNull final String cls,
                                     @NonNull final Bundle options) {
        startActivity(SiberiaDanteLib.getContext(), null, pkg, cls, options);
    }

    /**
     * 启动Activity
     *
     * @param activity activity
     * @param pkg      包名
     * @param cls      全类名
     * @param options  动画
     */
    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final String pkg,
                                     @NonNull final String cls,
                                     @NonNull final Bundle options) {
        startActivity(activity, null, pkg, cls, options);
    }


    /**
     * 启动Activity
     *
     * @param extras  extras
     * @param cls     activity类
     * @param options 跳转动画
     */
    public static void startActivity(@NonNull final Bundle extras,
                                     @NonNull final Class<?> cls,
                                     @NonNull final Bundle options) {
        Context context = SiberiaDanteLib.getContext();
        startActivity(context, extras, context.getPackageName(), cls.getName(), options);
    }

    /**
     * 启动Activity
     *
     * @param extras   extras
     * @param activity activity
     * @param cls      activity类
     * @param options  跳转动画
     */
    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final Bundle extras,
                                     @NonNull final Class<?> cls,
                                     @NonNull final Bundle options) {
        startActivity(activity, extras, activity.getPackageName(), cls.getName(), options);
    }

    /**
     * 启动Activity
     *
     * @param extras extras
     * @param pkg    包名
     * @param cls    全类名
     */
    public static void startActivity(@NonNull final Bundle extras,
                                     @NonNull final String pkg,
                                     @NonNull final String cls) {
        startActivity(SiberiaDanteLib.getContext(), extras, pkg, cls, null);
    }


    /**
     * 启动Activity
     *
     * @param activity activity
     * @param extras   extras
     * @param pkg      包名
     * @param cls      全类名
     */
    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final Bundle extras,
                                     @NonNull final String pkg,
                                     @NonNull final String cls) {
        startActivity(activity, extras, pkg, cls, null);
    }

    /**
     * 启动Activity
     *
     * @param extras  extras
     * @param pkg     包名
     * @param cls     全类名
     * @param options 动画
     */
    public static void startActivity(@NonNull final Bundle extras,
                                     @NonNull final String pkg,
                                     @NonNull final String cls,
                                     @NonNull final Bundle options) {
        startActivity(SiberiaDanteLib.getContext(), extras, pkg, cls, options);
    }

    /**
     * 启动Activity
     *
     * @param activity  activity
     * @param cls       activity类
     * @param enterAnim 入场动画
     * @param exitAnim  出场动画
     */
    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final Class<?> cls,
                                     @AnimRes final int enterAnim,
                                     @AnimRes final int exitAnim) {
        startActivity(activity, null, activity.getPackageName(), cls.getName(), null);
        activity.overridePendingTransition(enterAnim, exitAnim);
    }

    /**
     * 启动Activity
     *
     * @param extras    extras
     * @param activity  activity
     * @param cls       activity类
     * @param enterAnim 入场动画
     * @param exitAnim  出场动画
     */
    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final Bundle extras,
                                     @NonNull final Class<?> cls,
                                     @AnimRes final int enterAnim,
                                     @AnimRes final int exitAnim) {
        startActivity(activity, extras, activity.getPackageName(), cls.getName(), null);
        activity.overridePendingTransition(enterAnim, exitAnim);
    }


    /**
     * 启动Activity
     *
     * @param activity  activity
     * @param pkg       包名
     * @param cls       全类名
     * @param enterAnim 入场动画
     * @param exitAnim  出场动画
     */
    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final String pkg,
                                     @NonNull final String cls,
                                     @AnimRes final int enterAnim,
                                     @AnimRes final int exitAnim) {
        startActivity(activity, null, pkg, cls, null);
        activity.overridePendingTransition(enterAnim, exitAnim);
    }

    /**
     * 启动Activity
     *
     * @param extras   extras
     * @param activity activity
     * @param pkg      包名
     * @param cls      全类名
     * @param options  动画
     */
    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final Bundle extras,
                                     @NonNull final String pkg,
                                     @NonNull final String cls,
                                     @NonNull final Bundle options) {
        startActivity(activity, extras, pkg, cls, options);
    }


    /**
     * 启动Activity
     *
     * @param extras    extras
     * @param pkg       包名
     * @param cls       全类名
     * @param enterAnim 入场动画
     * @param exitAnim  出场动画
     */
    public static void startActivity(@NonNull final Activity activity,
                                     @NonNull final Bundle extras,
                                     @NonNull final String pkg,
                                     @NonNull final String cls,
                                     @AnimRes final int enterAnim,
                                     @AnimRes final int exitAnim) {
        startActivity(activity, extras, pkg, cls, null);
        activity.overridePendingTransition(enterAnim, exitAnim);
    }

    /**
     * @param context
     * @param extras
     * @param pkg
     * @param cls
     * @param options
     */
    private static void startActivity(final Context context,
                                      final Bundle extras,
                                      final String pkg,
                                      final String cls,
                                      final Bundle options) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (extras != null) intent.putExtras(extras);
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
     * @param packageName  应用包名应用包名应用包名应用包名
     * @param activityName activity全路径名
     * @return true 存在；false 不存在
     */
    public static boolean isActivityExists(@Nullable String packageName, @Nullable String activityName) {
        Intent intent = new Intent();
        intent.setClassName(packageName, activityName);
        PackageManager packageManager = SiberiaDanteLib.getContext().getPackageManager();
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
        PackageManager pm = SiberiaDanteLib.getContext().getPackageManager();
        List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo info : infos) {
            if (info.activityInfo.packageName.equals(packageName)) {
                return info.activityInfo.name;
            }
        }
        return "No APP exits for PackName equals " + packageName;
    }

//    /**
//     * 获取栈顶Activity
//     *
//     * @return 栈顶Activity
//     */
//    public static Activity getTopActivity() {
//        return SiberiaDanteLib.sTopActivity;
//    }

//    /**
//     * 获取栈顶Activity
//     *
//     * @return 栈顶Activity
//     */
//    public static Activity getTopActivity() {
//        try {
//            Class activityThreadClass = Class.forName("android.app.ActivityThread");
//            @SuppressWarnings("unchecked")
//            Object activityThread = activityThreadClass.getMethod("currentActivityThread").invoke(null);
//            Field activitiesField = activityThreadClass.getDeclaredField("mActivities");
//            activitiesField.setAccessible(true);
//            Map activities = null;
//            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
//                activities = (HashMap) activitiesField.get(activityThread);
//            } else {
//                activities = (ArrayMap) activitiesField.get(activityThread);
//            }
//            for (Object activityRecord : activities.values()) {
//                Class activityRecordClass = activityRecord.getClass();
//                Field pausedField = activityRecordClass.getDeclaredField("paused");
//                pausedField.setAccessible(true);
//                if (!pausedField.getBoolean(activityRecord)) {
//                    Field activityField = activityRecordClass.getDeclaredField("activity");
//                    activityField.setAccessible(true);
//                    return (Activity) activityField.get(activityRecord);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    /**
//     * 添加Activity 到栈
//     *
//     * @param activity
//     */
//    public static void addActivity(Activity activity) {
//        if (activityStack == null) {
//            activityStack = new Stack<>();
//        }
//        activityStack.add(activity);
//    }
//
//    /**
//     * 获取当前的Activity（堆栈中最后一个压入的)
//     */
//    public static Activity currentActivity() {
//        Activity activity = activityStack.lastElement();
//        return activity;
//    }
//
//    /**
//     * 结束当前Activity（堆栈中最后一个压入的）
//     */
//    public static void finishActivity() {
//        Activity activity = activityStack.lastElement();
//
//    }
//
//    /**
//     * 结束指定的Activity
//     *
//     * @param activity
//     */
//    public static void finishActivity(Activity activity) {
//        if (activity != null) {
//            activityStack.remove(activity);
//            activity.finish();
//            activity = null;
//        }
//    }
//
//    /**
//     * 结束指定类名的Activity
//     */
//    public static void finishActivity(Class<?> cls) {
//        for (Activity activity : activityStack) {
//            if (activity.getClass().equals(cls)) {
//                finishActivity();
//            }
//        }
//    }
//
//    /**
//     * 结束所有的Activity、
//     */
//    public static void finishAllActivity() {
//        int size = activityStack.size();
//        for (int i = 0; i < size; i++) {
//            if (null != activityStack.get(i)) {
//                activityStack.get(i).finish();
//            }
//        }
//        activityStack.clear();
//    }


}
