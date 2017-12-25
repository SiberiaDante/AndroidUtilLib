package com.siberiadante.androidutil.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.siberiadante.androidutil.SDAndroidLib;

import java.util.List;


/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/10/26
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDJumpUtil {
    public static final String SETTINGS_ACTION = "android.settings.APPLICATION_DETAILS_SETTINGS";

    /**
     * 打开设置页面
     */
    public static void openSetting() {
        Intent intent = new Intent()
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setAction(Settings.ACTION_SETTINGS);
        SDAndroidLib.getContext().startActivity(intent);
    }

    /**
     * 打开APP设置详情页面
     */
    public static void openAppSetting() {
        Intent intent = new Intent()
                .setAction(SETTINGS_ACTION)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setData(Uri.fromParts("package", SDAndroidLib.getContext().getPackageName(), null));
        SDAndroidLib.getContext().startActivity(intent);
    }

    /**
     * 打开发送邮件面板
     *
     * @param email email
     */
    public static void openEmail(String email) {
        Uri uri = Uri.parse("mailto:" + email);
        Intent intent = new Intent()
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setAction(Intent.ACTION_SENDTO)
                .setData(uri);
        SDAndroidLib.getContext().startActivity(intent);
    }

    /**
     * 打开并发送一份邮件
     * <p>
     * setAction(Intent.ACTION_SENDTO):无附件的发送
     * setAction(Intent.ACTION_SEND):带附件的发送
     * setAction(Intent.ACTION_SEND_MULTIPLE ):带有多附件的发送
     * </p>
     *
     * @param email   邮箱地址
     * @param title   邮件标题
     * @param content 邮件内容
     */
    public static void sendEmail(String email, String title, String content) {
        Uri uri = Uri.parse("mailto:" + email);
        Intent intent = new Intent()
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setAction(Intent.ACTION_SENDTO)
                .putExtra(Intent.EXTRA_SUBJECT, title)
                .putExtra(Intent.EXTRA_TEXT, content)
                .setData(uri);
        SDAndroidLib.getContext().startActivity(intent);
    }

    /**
     * 通过浏览器打开一个链接
     *
     * @param url
     */
    public static void openBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        SDAndroidLib.getContext().startActivity(intent);
    }

    /**
     * 启动一个Activity
     *
     * @param cls class name
     */
    public static void startActivity(@NonNull Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 启动一个传值Bundle的Activity
     *
     * @param cls    class name
     * @param extras bundle 传值
     */
    public static void startActivity(@NonNull Class<?> cls,
                                     @Nullable Bundle extras) {
        startActivity(SDAndroidLib.getContext().getPackageName(), cls.getName(), extras, null);
    }

    /**
     * 启动一个包含动画的Activity
     *
     * @param options 动画
     * @param cls
     */
    public static void startActivity(@Nullable Bundle options,
                                     @NonNull Class<?> cls) {
        startActivity(SDAndroidLib.getContext().getPackageName(), cls.getName(), null, options);
    }

    /**
     * @param cls     class name
     * @param extras  bundle
     * @param options bundle
     */
    public static void startActivity(@NonNull Class<?> cls,
                                     @Nullable Bundle extras,
                                     @Nullable Bundle options) {
        startActivity(SDAndroidLib.getContext().getPackageName(), cls.getName(), extras, options);
    }


    /**
     * @param pkg     package name
     * @param cls     class name
     * @param extras  bundle
     * @param options Additional options for how the Activity should be started.
     *                May be null if there are no options.  See {@link android.app.ActivityOptions}
     *                for how to build the Bundle supplied here; there are no supported definitions
     *                for building it manually.
     */
    private static void startActivity(
            @NonNull String pkg,
            @NonNull String cls,
            @Nullable Bundle extras,
            @Nullable Bundle options) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.setComponent(new ComponentName(pkg, cls));
        if (!(SDAndroidLib.getContext() instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        if (options != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            SDAndroidLib.getContext().startActivity(intent, options);
        } else {
            SDAndroidLib.getContext().startActivity(intent);
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
    public static void startActivity(@NonNull Activity activity,
                                     @NonNull String cls,
                                     @AnimRes  int enterAnim,
                                     @AnimRes  int exitAnim) {
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
    public static void startActivity(@NonNull Activity activity,
                                     @NonNull String pkg,
                                     @NonNull String cls,
                                     @Nullable Bundle extras,
                                     @AnimRes  int enterAnim,
                                     @AnimRes  int exitAnim) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.setComponent(new ComponentName(pkg, cls));
        activity.startActivity(intent);
        activity.overridePendingTransition(enterAnim, exitAnim);
    }


}
