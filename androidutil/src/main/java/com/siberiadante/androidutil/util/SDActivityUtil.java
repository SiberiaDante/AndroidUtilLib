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
import android.support.annotation.AnimRes;
import android.support.annotation.Nullable;


import com.siberiadante.androidutil.SDAndroidLib;

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
        throw new UnsupportedOperationException("not init ~~~");
    }

    /**
     * 判断Activity是否存在
     *
     * @param packageName  应用包名
     * @param activityName activity全路径名
     * @return {@code true}: 存在；{@code false }:不存在
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
     * 获取启动 activity
     *
     * @param packageName 应用包名
     * @return 应用启动的 activity全路径名
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
