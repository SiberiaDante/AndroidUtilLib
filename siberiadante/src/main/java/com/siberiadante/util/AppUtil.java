package com.siberiadante.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.siberiadante.R;

/**
 * Created by SiberiaDante on 2017/5/4.
 */

public class AppUtil {
    public static final String TAG = AppUtil.class.getSimpleName();

    /**
     * 获取应用版本号
     *
     * @param context
     * @return
     */
    public static String getAppVersion(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return context.getString(R.string.can_not_find_version_name);
        }
    }

    /**
     * 获取安卓系统版本号
     *
     * @param context
     * @return
     */
    public String getAndroidSystemVersion(Context context) {
        String versionName = "";
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e(TAG, "getAndroidSystemVersion: " + e);
        }
        return android.os.Build.VERSION.RELEASE;//获取安卓系统版本号
    }

    public static String getMobilePhoneTypeInfo(Context context) {
        String versionName = "";
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e(TAG, "getMobilePhoneTypeInfo: " + e);
        }
        return android.os.Build.MODEL; // 手机型号
    }

    public String getMobileandAPPInfo(Context context) {
        String versionName = "";
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e(TAG, "getMobileandAPPInfo: " + e);
        }
        String mtype = android.os.Build.MODEL; // 手机型号
        String androidSysVersion = android.os.Build.VERSION.RELEASE;//获取版本号
        return "手机型号：" + mtype + " Android系统版本：" + androidSysVersion + " App版本号：" + versionName;
    }
}
