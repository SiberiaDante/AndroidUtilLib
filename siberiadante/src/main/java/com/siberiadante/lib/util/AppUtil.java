package com.siberiadante.lib.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.siberiadante.lib.SiberiaDanteLib;
import com.siberiadante.lib.exception.SiberiaDanteLibException;
import com.siberiadante.lib.bean.AppInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by SiberiaDante on 2017/5/4.
 * 获取应用/手机信息、判断应用是否安装，卸载/安装APP，手机网络面板设置等
 */

public class AppUtil {
    public static final String TAG = AppUtil.class.getSimpleName();

    public AppUtil() {
        new SiberiaDanteLibException();
    }

    /**
     * 获取应用包名
     *
     * @return
     */
    public static String getPackageName() {
        return SiberiaDanteLib.getContext().getPackageName();
    }

    private static PackageManager getPackageManager() {
        return SiberiaDanteLib.getContext().getPackageManager();
    }

    /**
     * 获取App包名
     *
     * @return App包名
     */
    public static String getAppPackageName() {
        return SiberiaDanteLib.getContext().getPackageName();
    }

    public static boolean isInstalledApp() {
        return !isSpace(getPackageName()) && getPackageManager().getLaunchIntentForPackage(getPackageName()) != null;
    }

    /**
     * 判断App是否安装
     *
     * @param packageName 包名
     * @return {@code true}: 已安装<br>{@code false}: 未安装
     */
    public static boolean isInstalledApp(String packageName) {
        return !isSpace(packageName) && getPackageManager().getLaunchIntentForPackage(packageName) != null;
    }

    /**
     * 获取App版本号名
     *
     * @return App版本名
     */
    public static String getAppVersionName() {
        return getAppVersionName(SiberiaDanteLib.getContext().getPackageName());
    }

    /**
     * 获取App版本名
     *
     * @param packageName 应用包名
     * @return App版本名
     */
    public static String getAppVersionName(String packageName) {
        if (isSpace(packageName)) return null;
        try {
            PackageInfo pi = getPackageManager().getPackageInfo(packageName, 0);
            return pi == null ? null : pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取App版本号
     *
     * @return App版本号
     */
    public static int getAppVersionCode() {
        return getAppVersionCode(SiberiaDanteLib.getContext().getPackageName());
    }

    /**
     * 获取App版本码
     *
     * @param packageName 包名
     * @return App版本码
     */
    public static int getAppVersionCode(String packageName) {
        if (isSpace(packageName)) return -1;
        try {
            PackageInfo pi = getPackageManager().getPackageInfo(packageName, 0);
            return pi == null ? -1 : pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取安卓系统版本号
     *
     * @return
     */
    public static String getAndroidSystemVersion() {
        String versionName = "";
        try {
            PackageInfo pi = getPackageManager().getPackageInfo(SiberiaDanteLib.getContext().getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e(TAG, "getAndroidSystemVersion: " + e);
        }
        return android.os.Build.VERSION.RELEASE;//获取安卓系统版本号
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getMobilePhoneTypeInfo() {
        String versionName = "";
        try {
            PackageInfo pi = getPackageManager().getPackageInfo(SiberiaDanteLib.getContext().getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e(TAG, "getMobilePhoneTypeInfo: " + e);
        }
        return android.os.Build.MODEL; // 手机型号
    }

    // Android Id
    public static String getDeviceId(Context context) {
        String deviceId = null;
        if (deviceId != null && !"".equals(deviceId)) {
            return deviceId;
        }
        if (deviceId == null || "".equals(deviceId)) {
            try {
                deviceId = getLocalMac(context).replace(":", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (deviceId == null || "".equals(deviceId)) {
            try {
                deviceId = getAndroidId(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (deviceId == null || "".equals(deviceId)) {

            if (deviceId == null || "".equals(deviceId)) {
                UUID uuid = UUID.randomUUID();
                deviceId = uuid.toString().replace("-", "");
            }
        }
        return deviceId;
    }


    /**
     * 获取手机和应用信息
     *
     * @return
     */
    public static String getMobileAndAPPInfo() {
        String versionName = "";
        try {
            PackageManager pm = SiberiaDanteLib.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(SiberiaDanteLib.getContext().getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e(TAG, "getMobileAndAPPInfo: " + e);
        }
        String mType = android.os.Build.MODEL; // 手机型号
        String androidSysVersion = android.os.Build.VERSION.RELEASE;//获取版本号
        return "手机型号：" + mType + " Android系统版本：" + androidSysVersion + " App版本号：" + versionName;
    }

    /**
     * 打开App
     *
     * @param packageName 包名
     */
    public static void launchApp(String packageName) {
        if (isSpace(packageName)) return;
        SiberiaDanteLib.getContext().startActivity(IntentUtil.getLaunchAppIntent(packageName));
    }

    /**
     * 打开App
     *
     * @param activity    activity
     * @param packageName 包名
     * @param requestCode 请求值
     */
    public static void launchApp(Activity activity, String packageName, int requestCode) {
        if (isSpace(packageName)) return;
        activity.startActivityForResult(IntentUtil.getLaunchAppIntent(packageName), requestCode);
    }


    /**
     * 打开App设置面板
     */
    public static void openAppDetailsSettings() {
        openAppDetailsSettings(SiberiaDanteLib.getContext().getPackageName());
    }

    /**
     * 打开App设置面板
     *
     * @param packageName 包名
     */
    public static void openAppDetailsSettings(String packageName) {
        if (isSpace(packageName)) return;
        SiberiaDanteLib.getContext().startActivity(IntentUtil.getAppDetailsSettingsIntent(packageName));
    }

    /**
     * 获取App名称
     *
     * @return App名称
     */
    public static String getAppName() {
        return getAppName(SiberiaDanteLib.getContext().getPackageName());
    }

    /**
     * 获取App名称
     *
     * @param packageName 包名
     * @return App名称
     */
    public static String getAppName(String packageName) {
        if (isSpace(packageName)) return null;
        try {
            PackageManager pm = SiberiaDanteLib.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.applicationInfo.loadLabel(pm).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取App图标
     *
     * @return App图标
     */
    public static Drawable getAppIcon() {
        return getAppIcon(SiberiaDanteLib.getContext().getPackageName());
    }

    /**
     * 获取App图标
     *
     * @param packageName 包名
     * @return App图标
     */
    public static Drawable getAppIcon(String packageName) {
        if (isSpace(packageName)) return null;
        try {
            PackageManager pm = SiberiaDanteLib.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.applicationInfo.loadIcon(pm);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取App路径
     *
     * @return App路径
     */
    public static String getAppPath() {
        return getAppPath(SiberiaDanteLib.getContext().getPackageName());
    }

    /**
     * 获取App路径
     *
     * @param packageName 包名
     * @return App路径
     */
    public static String getAppPath(String packageName) {
        if (isSpace(packageName)) return null;
        try {
            PackageManager pm = SiberiaDanteLib.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 判断App是否是系统应用
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isSystemApp() {
        return isSystemApp(SiberiaDanteLib.getContext().getPackageName());
    }

    /**
     * 判断App是否是系统应用
     *
     * @param packageName 包名
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isSystemApp(String packageName) {
        if (isSpace(packageName)) return false;
        try {
            PackageManager pm = SiberiaDanteLib.getContext().getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(packageName, 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断App是否是Debug版本
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppDebug() {
        return isAppDebug(SiberiaDanteLib.getContext().getPackageName());
    }

    /**
     * 判断App是否是Debug版本
     *
     * @param packageName 包名
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppDebug(String packageName) {
        if (isSpace(packageName)) return false;
        try {
            PackageManager pm = SiberiaDanteLib.getContext().getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(packageName, 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断App是否有root权限
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppRoot() {
        ShellUtils.CommandResult result = ShellUtils.execCmd("echo root", true);
        if (result.result == 0) {
            return true;
        }
        if (result.errorMsg != null) {
            ToastUtil.showTextLong("isAppRoot?---" + result.errorMsg);
        }
        return false;
    }

    /**
     * 卸载APP
     *
     * @param packageName APP包名
     */
    public static void unInstallApp(String packageName) {
        if (isSpace(packageName)) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:" + packageName));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        SiberiaDanteLib.getContext().startActivity(intent);
    }

    /**
     * 卸载APP
     *
     * @param activity
     * @param packageName app包名
     * @param requestCode 卸载请求码
     */
    public static void unInstallApp(Activity activity, String packageName, int requestCode) {
        if (isSpace(packageName)) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:" + packageName));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivityForResult(intent, requestCode);
    }


    /**
     * 后台卸载App
     * <p>非root需添加权限 {@code <uses-permission android:name="android.permission.DELETE_PACKAGES" />}</p>
     *
     * @param packageName 包名
     * @param isKeepData  是否保留数据
     * @return {@code true}: 卸载成功<br>{@code false}: 卸载失败
     */
    public static boolean uninstallAppSilent(String packageName, boolean isKeepData) {
        if (isSpace(packageName)) return false;
        String command = "LD_LIBRARY_PATH=/vendor/lib:/system/lib pm uninstall " + (isKeepData ? "-k " : "") + packageName;
        ShellUtils.CommandResult commandResult = ShellUtils.execCmd(command, !isSystemApp(), true);
        return commandResult.successMsg != null && commandResult.successMsg.toLowerCase().contains("success");
    }

    /**
     * @param packageName
     * @return
     */
    public static boolean isSpace(String packageName) {
        if (packageName == null) {
            return true;
        }
        for (int i = 0, len = packageName.length(); i < len; ++i) {
            if (!Character.isWhitespace(packageName.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * 获取App签名
     *
     * @return App签名
     */
    public static Signature[] getAppSignature() {
        return getAppSignature(SiberiaDanteLib.getContext().getPackageName());
    }

    /**
     * 获取App签名
     *
     * @param packageName 包名
     * @return App签名
     */
    public static Signature[] getAppSignature(String packageName) {
        if (isSpace(packageName)) {
            return null;
        }
        try {
            @SuppressLint("PackageManagerGetSignatures")
            PackageInfo pi = getPackageManager().getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            return pi == null ? null : pi.signatures;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取应用签名的的SHA1值
     * <p>可据此判断高德，百度地图key是否正确</p>
     *
     * @return 应用签名的SHA1字符串, 比如：53:FD:54:DC:19:0F:11:AC:B5:22:9E:F1:1A:68:88:1B:8B:E8:54:42
     */
    public static String getAppSignatureSHA1() {
        return getAppSignatureSHA1(SiberiaDanteLib.getContext().getPackageName());
    }

    /**
     * 获取应用签名的的SHA1值
     *
     * @param packageName 包名
     * @return 应用签名的SHA1字符串, 比如：53:FD:54:DC:19:0F:11:AC:B5:22:9E:F1:1A:68:88:1B:8B:E8:54:42
     */
    public static String getAppSignatureSHA1(String packageName) {
        Signature[] signature = getAppSignature(packageName);
        if (signature == null) return null;
        return EncryptUtil.encryptSHA1ToString(signature[0].toByteArray()).
                replaceAll("(?<=[0-9A-F]{2})[0-9A-F]{2}", ":$0");
    }

    /**
     * 判断App是否处于前台
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppInForeground() {
        ActivityManager manager = (ActivityManager) SiberiaDanteLib.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> infos = manager.getRunningAppProcesses();
        if (infos == null || infos.size() == 0) return false;
        for (ActivityManager.RunningAppProcessInfo info : infos) {
            if (info.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return info.processName.equals(SiberiaDanteLib.getContext().getPackageName());
            }
        }
        return false;
    }

    /**
     * 判断App是否处于前台
     * <p>当不是查看当前App，且SDK大于21时，
     * 需添加权限 {@code <uses-permission android:name="android.permission.PACKAGE_USAGE_STATS"/>}</p>
     *
     * @param packageName 包名
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppInForeground(String packageName) {
        return !isSpace(packageName) && packageName.equals(ProcessUtil.getForegroundProcessName());
    }


    /**
     * 清除App所有数据
     *
     * @param dirPaths 目录路径
     * @return {@code true}: 成功<br>{@code false}: 失败
     */
    public static boolean cleanAppData(String... dirPaths) {
        File[] dirs = new File[dirPaths.length];
        int i = 0;
        for (String dirPath : dirPaths) {
            dirs[i++] = new File(dirPath);
        }
        return cleanAppData(dirs);
    }

    /**
     * 清除App所有数据
     *
     * @param dirs 目录
     * @return {@code true}: 成功<br>{@code false}: 失败
     */
    public static boolean cleanAppData(File... dirs) {
        boolean isSuccess = ClearUtil.clearInternalCache();
        isSuccess &= ClearUtil.clearInternalDbs();
        isSuccess &= ClearUtil.clearInternalSP();
        isSuccess &= ClearUtil.clearInternalFiles();
        isSuccess &= ClearUtil.clearExternalCache();
        for (File dir : dirs) {
            isSuccess &= ClearUtil.clearCustomCache(dir);
        }
        return isSuccess;
    }

//TODO 以下-待测试~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /**
     * 安装App(支持7.0)
     *
     * @param filePath  文件路径
     * @param authority 7.0及以上安装需要传入清单文件中的{@code <provider>}的authorities属性
     *                  <br>参看https://developer.android.com/reference/android/support/v4/content/FileProvider.html
     */
    public static void installApp(String filePath, String authority) {
        installApp(FileUtil.getFileByPath(filePath), authority);
    }

    /**
     * 安装App（支持7.0）
     *
     * @param file      文件
     * @param authority 7.0及以上安装需要传入清单文件中的{@code <provider>}的authorities属性
     *                  <br>参看https://developer.android.com/reference/android/support/v4/content/FileProvider.html
     */
    public static void installApp(File file, String authority) {
        if (!FileUtil.isFileExists(file)) {
            return;
        }
        SiberiaDanteLib.getContext().startActivity(IntentUtil.getInstallAppIntent(file, authority));
    }

    /**
     * 安装App（支持6.0）
     *
     * @param activity    activity
     * @param filePath    文件路径
     * @param authority   7.0及以上安装需要传入清单文件中的{@code <provider>}的authorities属性
     *                    <br>参看https://developer.android.com/reference/android/support/v4/content/FileProvider.html
     * @param requestCode 请求值
     */
    public static void installApp(Activity activity, String filePath, String authority, int requestCode) {
        installApp(activity, FileUtil.getFileByPath(filePath), authority, requestCode);
    }

    /**
     * 安装App(支持6.0)
     *
     * @param activity    activity
     * @param file        文件
     * @param authority   7.0及以上安装需要传入清单文件中的{@code <provider>}的authorities属性
     *                    <br>参看https://developer.android.com/reference/android/support/v4/content/FileProvider.html
     * @param requestCode 请求值
     */
    public static void installApp(Activity activity, File file, String authority, int requestCode) {
        if (!FileUtil.isFileExists(file)) return;
        activity.startActivityForResult(IntentUtil.getInstallAppIntent(file, authority), requestCode);
    }

    /**
     * 静默安装App
     * <p>非root需添加权限 {@code <uses-permission android:name="android.permission.INSTALL_PACKAGES" />}</p>
     *
     * @param filePath 文件路径
     * @return {@code true}: 安装成功<br>{@code false}: 安装失败
     */
    public static boolean installAppSilent(String filePath) {
        File file = FileUtil.getFileByPath(filePath);
        if (!FileUtil.isFileExists(file)) return false;
        String command = "LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install " + filePath;
        ShellUtils.CommandResult commandResult = ShellUtils.execCmd(command, !isSystemApp(), true);
        return commandResult.successMsg != null && commandResult.successMsg.toLowerCase().contains("success");
    }
//TODO 以上-待测试~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /**
     * 获取App信息
     * <p>AppInfo（名称，图标，包名，版本号，版本Code，是否系统应用）</p>
     *
     * @return 当前应用的AppInfo
     */
    public static AppInfo getAppInfo() {
        return getAppInfo(SiberiaDanteLib.getContext().getPackageName());
    }

    /**
     * 获取App信息
     * <p>AppInfo（名称，图标，包名，版本号，版本Code，是否系统应用）</p>
     *
     * @param packageName 包名
     * @return 当前应用的AppInfo
     */
    public static AppInfo getAppInfo(String packageName) {
        try {
            PackageManager pm = SiberiaDanteLib.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return getBean(pm, pi);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 得到AppInfo的Bean
     *
     * @param pm 包的管理
     * @param pi 包的信息
     * @return AppInfo类
     */
    private static AppInfo getBean(PackageManager pm, PackageInfo pi) {
        if (pm == null || pi == null) {
            return null;
        }
        ApplicationInfo ai = pi.applicationInfo;
        String packageName = pi.packageName;
        String name = ai.loadLabel(pm).toString();
        Drawable icon = ai.loadIcon(pm);
        String packagePath = ai.sourceDir;
        String versionName = pi.versionName;
        int versionCode = pi.versionCode;
        boolean isSystem = (ApplicationInfo.FLAG_SYSTEM & ai.flags) != 0;
        return new AppInfo(packageName, name, icon, packagePath, versionName, versionCode, isSystem);
    }

    /**
     * 获取所有已安装App信息
     * <p>{@link #getBean(PackageManager, PackageInfo)}（名称，图标，包名，包路径，版本号，版本Code，是否系统应用）</p>
     * <p>依赖上面的getBean方法</p>
     *
     * @return 所有已安装的AppInfo列表
     */
    public static List<AppInfo> getAppsInfo() {
        List<AppInfo> list = new ArrayList<>();
        PackageManager pm = SiberiaDanteLib.getContext().getPackageManager();
        // 获取系统中安装的所有软件信息
        List<PackageInfo> installedPackages = pm.getInstalledPackages(0);
        for (PackageInfo pi : installedPackages) {
            AppInfo ai = getBean(pm, pi);
            if (ai == null) continue;
            list.add(ai);
        }
        return list;
    }


    // IMEI码
    private static String getIMIEStatus(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        return deviceId;
    }

    // Mac地址
    private static String getLocalMac(Context context) {
        WifiManager wifi = (WifiManager) context
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        return info.getMacAddress();
    }

    // Android Id
    private static String getAndroidId(Context context) {
        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return androidId;
    }
}
