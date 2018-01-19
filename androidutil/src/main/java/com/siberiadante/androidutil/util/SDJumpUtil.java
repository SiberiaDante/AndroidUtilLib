package com.siberiadante.androidutil.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;

import com.siberiadante.androidutil.SDAndroidLib;

import java.util.List;


/**
 * @Created SiberiaDante
 * @Describe：页面跳转、打开浏览器、发送短信、设置面板等工具类
 * @CreateTime: 2017/10/26
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDJumpUtil {

    /**
     * 打开设置首页
     */
    public static void openSetting() {
        Intent intent = new Intent()
                .setAction(Settings.ACTION_SETTINGS)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        SDAndroidLib.getContext().startActivity(intent);
    }

    /**
     * 打开APP设置详情页面
     */
    public static void openAppSetting() {
        Intent intent = new Intent()
                .setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setData(Uri.fromParts("package", SDAndroidLib.getContext().getPackageName(), null));
        SDAndroidLib.getContext().startActivity(intent);
    }

    /**
     * 打开无线设置面板
     */
    public static void openWifiSetting() {
        Intent intent = new Intent()
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setAction(Settings.ACTION_WIFI_SETTINGS);
        SDAndroidLib.getContext().startActivity(intent);
    }

    /**
     * 打开无线和网络设置面板
     */
    public static void openNetWorkSetting() {
        Intent intent;
        if (android.os.Build.VERSION.SDK_INT > 10) {
            intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        } else {
            intent = new Intent(android.provider.Settings.ACTION_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        SDAndroidLib.getContext().startActivity(intent);
    }

    /**
     * 打开语言设置面板
     */
    public static void openLanguageSetting() {
        Intent intent = new Intent()
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setAction(Settings.ACTION_LOCALE_SETTINGS);
        SDAndroidLib.getContext().startActivity(intent);
    }

    /**
     * 打开位置设置面板
     */
    public static void openLocationSetting() {
        Intent intent = new Intent()
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
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
                .setAction(Intent.ACTION_SENDTO)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setData(uri);
        SDAndroidLib.getContext().startActivity(intent);
    }

    /**
     * 打开并发送一份邮件
     * <ul>
     * <li>{@code setAction(Intent.ACTION_SENDTO)}:无附件的发送</li>
     * <li>{@code setAction(Intent.ACTION_SEND)}:带附件的发送</li>
     * <li>{@code setAction(Intent.ACTION_SEND_MULTIPLE )}:带有多附件的发送</li>
     * </ul>
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
     * 拨打电话
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.CALL_PHONE"/>}</p>
     *
     * @param phoneNumber 电话号码
     */
    public static void openCall(final String phoneNumber) {
        SDAndroidLib.getContext().startActivity(SDIntentUtil.getCallIntent(phoneNumber));
    }

    /**
     * 拨打电话
     * 需添加权限 {@code <uses-permission android:name="android.permission.CALL_PHONE"/>}
     *
     * @param context     上下文
     * @param phoneNumber 电话号码
     */
    @SuppressLint("MissingPermission")
    public static void openCall(final Context context, String phoneNumber) {
        if (!SDStringUtil.isEmpty(phoneNumber)) {
            final String phoneNumber1 = phoneNumber.trim();// 删除字符串首部和尾部的空格
            // 调用系统的拨号服务实现电话拨打功能
            // 封装一个拨打电话的intent，并且将电话号码包装成一个Uri对象传入

            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber1));
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            context.startActivity(intent);// 内部类
        }
    }

    /**
     * 跳至发送短信界面
     *
     * @param phoneNumber 接收号码
     * @param content     短信内容
     */
    public static void openSendSms(final String phoneNumber, final String content) {
        SDAndroidLib.getContext().startActivity(SDIntentUtil.getSendSmsIntent(phoneNumber, content));
    }

    /**
     * 发送短信-静默
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.SEND_SMS"/>}</p>
     *
     * @param phoneNumber 接收号码
     * @param content     短信内容
     */
    public static void openSendSmsSilent(final String phoneNumber, final String content) {
        if (SDStringUtil.isEmpty(content)) return;
        PendingIntent sentIntent = PendingIntent.getBroadcast(SDAndroidLib.getContext(), 0, new Intent(), 0);
        SmsManager smsManager = SmsManager.getDefault();
        if (content.length() >= 70) {
            List<String> ms = smsManager.divideMessage(content);
            for (String str : ms) {
                smsManager.sendTextMessage(phoneNumber, null, str, sentIntent, null);
            }
        } else {
            smsManager.sendTextMessage(phoneNumber, null, content, sentIntent, null);
        }
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
                                     @AnimRes int enterAnim,
                                     @AnimRes int exitAnim) {
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
                                     @AnimRes int enterAnim,
                                     @AnimRes int exitAnim) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.setComponent(new ComponentName(pkg, cls));
        activity.startActivity(intent);
        activity.overridePendingTransition(enterAnim, exitAnim);
    }


}
