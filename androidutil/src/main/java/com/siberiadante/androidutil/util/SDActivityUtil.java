package com.siberiadante.androidutil.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.siberiadante.androidutil.SDAndroidLib;

import java.util.List;

/**
 * Created: SiberiaDante
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * 博客园:http://www.cnblogs.com/shen-hua/
 * CreateTime: 2017/5/10.
 * UpDateTime:
 * Describe： Activity相关工具类
 */
public class SDActivityUtil {

    public SDActivityUtil() {
        throw new UnsupportedOperationException("not init---" + SDActivityUtil.class.getSimpleName());
    }

    /**
     * 判断Activity是否在运行
     *
     * @param activity
     * @return
     */
    public static boolean isActivityRunning(Activity activity) {
        return activity != null && !activity.isFinishing() && !activity.isDestroyed();
    }

    /**
     * 判断Activity是否存在
     *
     * @param packageName  应用包名
     * @param activityName activity全路径名
     * @return {@code true}: 存在；{@code false }:不存在
     */
    public static boolean isActivityExists(@NonNull String packageName, @NonNull String activityName) {
        Intent intent = new Intent();
        intent.setClassName(packageName, activityName);
        PackageManager packageManager = SDAndroidLib.getContext().getPackageManager();
        boolean b = packageManager.resolveActivity(intent, 0) == null ||
                packageManager.queryIntentActivities(intent, 0).size() == 0 ||
                intent.resolveActivity(packageManager) == null;
        return !b;
    }

    /**
     * 获取应用启动 activity
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
