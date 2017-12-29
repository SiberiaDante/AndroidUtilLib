package com.siberiadante.androidutil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;


import com.siberiadante.androidutil.bean.SDAppInfoBean;
import com.siberiadante.androidutil.bean.SDInstallAppInfoBean;
import com.siberiadante.androidutil.encrypt.SDSHA1Util;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SiberiaDante on 2017/5/4.
 * 获取应用/手机信息、判断应用是否安装，卸载/安装APP，手机网络面板设置等
 */

public class SDAppUtil {
    public static final String TAG = SDAppUtil.class.getSimpleName();

    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";


    public SDAppUtil() {
        throw new UnsupportedOperationException("not init ~~~");
    }

    private static PackageManager getPackageManager() {
        return SDAndroidLib.getContext().getPackageManager();
    }

    public static String getPackageName() {
        return SDAndroidLib.getContext().getPackageName();
    }

    /**
     * 获取App名称
     *
     * @return App名称
     */
    public static String getAppName() {
        return getAppName(SDAndroidLib.getContext().getPackageName());
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
            PackageManager pm = SDAndroidLib.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.applicationInfo.loadLabel(pm).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取App版本名
     *
     * @return App版本名
     */
    public static String getAppVersionName() {
        return getAppVersionName(SDAndroidLib.getContext());
    }

    public static String getAppVersionName(Context context) {
        return getAppVersionName(context.getPackageName());
    }

    /**
     * 获取App版本名
     *
     * @param packageName 应用包名
     * @return App版本名
     */
    public static String getAppVersionName(String packageName) {
        if (isSpace(packageName)) {
            return SDAndroidLib.getContext().getString(R.string.can_not_find_package_name);
        }
        try {
            PackageInfo pi = getPackageManager().getPackageInfo(packageName, 0);
            return pi == null ? null : pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return SDAndroidLib.getContext().getString(R.string.can_not_find_version_name);
        }
    }

    /**
     * 获取App版本号
     *
     * @return App版本号
     */
    public static int getAppVersionCode() {
        return getAppVersionCode(SDAndroidLib.getContext().getPackageName());
    }

    public static int getAppVersionCode(Context context) {
        return getAppVersionCode(context.getPackageName());
    }

    /**
     * 获取App版本号
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
     * 获取App图标
     *
     * @return App图标
     */
    public static Drawable getAppIcon() {
        return getAppIcon(SDAndroidLib.getContext().getPackageName());
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
            PackageManager pm = SDAndroidLib.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.applicationInfo.loadIcon(pm);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取App信息
     * <p>SDAppInfoBean（名称，图标，包名，版本号，版本Code，是否系统应用）</p>
     *
     * @return 当前应用的AppInfo
     */
    public static SDAppInfoBean getAppInfo() {
        return getAppInfo(SDAndroidLib.getContext().getPackageName());
    }

    /**
     * 获取App信息
     * <p>SDAppInfoBean（名称，图标，包名，版本号，版本Code，是否系统应用）</p>
     *
     * @param packageName 包名
     * @return 当前应用的AppInfo
     */
    public static SDAppInfoBean getAppInfo(String packageName) {
        try {
            PackageManager pm = SDAndroidLib.getContext().getPackageManager();
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
    private static SDAppInfoBean getBean(PackageManager pm, PackageInfo pi) {
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
        return new SDAppInfoBean(packageName, name, icon, packagePath, versionName, versionCode, isSystem);
    }

    /**
     * 判断该应用是否安装
     *
     * @return
     */
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
     * 获取当前App的路径
     *
     * @return App路径
     */
    public static String getAppPath() {
        return getAppPath(SDAndroidLib.getContext().getPackageName());
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
            PackageManager pm = SDAndroidLib.getContext().getPackageManager();
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
        return isSystemApp(SDAndroidLib.getContext().getPackageName());
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
            PackageManager pm = SDAndroidLib.getContext().getPackageManager();
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
        return isAppDebug(SDAndroidLib.getContext().getPackageName());
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
            PackageManager pm = SDAndroidLib.getContext().getPackageManager();
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
        SDShellUtil.CommandResult result = SDShellUtil.execCmd("echo root", true);
        if (result.result == 0) {
            return true;
        }
        if (result.errorMsg != null) {
            SDToastUtil.toast("isAppRoot?---" + result.errorMsg);
        }
        return false;
    }

    /**
     * 获取App签名
     *
     * @return App签名
     */
    public static Signature[] getAppSignature() {
        return getAppSignature(SDAndroidLib.getContext().getPackageName());
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
        return getAppSignatureSHA1(SDAndroidLib.getContext().getPackageName());
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
        return SDSHA1Util.encrypt(signature[0].toByteArray()).replaceAll("(?<=[0-9A-F]{2})[0-9A-F]{2}", ":$0");
//        return SDEncryptUtil.encryptSHA1ToString(signature[0].toByteArray()).
//                replaceAll("(?<=[0-9A-F]{2})[0-9A-F]{2}", ":$0");
    }


    /**
     * 判断手机通知权限是否打开
     *
     * @return
     */
    public static boolean isNotificationEnable() {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.KITKAT) {
            return true;
        }
        AppOpsManager mAppOps = (AppOpsManager) SDAndroidLib.getContext().getSystemService(Context.APP_OPS_SERVICE);
        ApplicationInfo appInfo = SDAndroidLib.getContext().getApplicationInfo();
        String pkg = SDAndroidLib.getContext().getApplicationContext().getPackageName();
        int uid = appInfo.uid;

        Class appOpsClass = null;
      /* Context.APP_OPS_MANAGER */
        try {
            appOpsClass = Class.forName(AppOpsManager.class.getName());
            Method checkOpNoThrowMethod = appOpsClass.getMethod(CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE,
                    String.class);
            Field opPostNotificationValue = appOpsClass.getDeclaredField(OP_POST_NOTIFICATION);

            int value = (Integer) opPostNotificationValue.get(Integer.class);
            return ((Integer) checkOpNoThrowMethod.invoke(mAppOps, value, uid, pkg) == AppOpsManager.MODE_ALLOWED);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断App是否处于前台
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppInForeground() {
        ActivityManager manager = (ActivityManager) SDAndroidLib.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> infos = manager.getRunningAppProcesses();
        if (infos == null || infos.size() == 0) return false;
        for (ActivityManager.RunningAppProcessInfo info : infos) {
            if (info.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return info.processName.equals(SDAndroidLib.getContext().getPackageName());
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
        return !isSpace(packageName) && packageName.equals(SDProcessUtil.getForegroundProcessName());
    }


    /**
     * 打开App
     */
    public static void launchApp() {
        launchApp(getPackageName());
    }

    /**
     * 打开App
     *
     * @param packageName 包名
     */
    public static void launchApp(String packageName) {
        if (isSpace(packageName)) return;
        SDAndroidLib.getContext().startActivity(SDIntentUtil.getLaunchAppIntent(packageName));
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
        activity.startActivityForResult(SDIntentUtil.getLaunchAppIntent(packageName), requestCode);
    }

    /**
     * 调用系统安装应用,支持7.0
     *
     * @param context
     * @param filePath  apk路径
     * @param authority 7.0authority属性，参考sample
     * @return
     */
    public static boolean installApp(Context context, String filePath, String authority) {
        final File file = SDFileUtil.getFileByPath(filePath);
        return installApp(context, file, authority);
    }

    /**
     * 调用系统安装应用,支持7.0
     *
     * @param context
     * @param file      apk文件
     * @param authority 7.0authority属性，参考sample
     * @return
     */
    public static boolean installApp(Context context, File file, String authority) {
        if (file == null || !file.exists() || !file.isFile()) {
            return false;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri apkUri;
        // Android 7.0 以上不支持 file://协议 需要通过 FileProvider 访问 sd卡 下面的文件，所以 Uri 需要通过 FileProvider 构造，协议为 content://
        if (Build.VERSION.SDK_INT >= 24) {
            // content:// 协议
            apkUri = FileProvider.getUriForFile(context, authority, file);
            //Granting Temporary Permissions to a URI
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            // file:// 协议
            apkUri = Uri.fromFile(file);
        }
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        context.startActivity(intent);
        return true;
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
        SDAndroidLib.getContext().startActivity(intent);
    }

    /**
     * 卸载APP
     *
     * @param activity
     * @param packageName app包名
     * @param requestCode 卸载请求码
     */
    public static void unInstallAppResult(Activity activity, String packageName, int requestCode) {
        if (isSpace(packageName)) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:" + packageName));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 获取已安装的所有应用的包名和启动logo
     *
     * @return
     */
    public static List<SDInstallAppInfoBean> getInstallAppInfo() {
        return getInstallAppInfo(SDAndroidLib.getContext());
    }

    /**
     * 获取已安装的所有应用的包名和启动logo
     *
     * @param context
     * @return
     */
    public static List<SDInstallAppInfoBean> getInstallAppInfo(Context context) {
        return getInstallAppInfo(context, true);
    }

    public static List<SDInstallAppInfoBean> getInstallAppInfo(Context context, boolean showSystemApp) {
        List<SDInstallAppInfoBean> appInfos = new ArrayList<>();
        PackageManager packageManager = context.getPackageManager();
        try {
            List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
            for (int i = 0; i < packageInfos.size(); i++) {
                PackageInfo packageInfo = packageInfos.get(i);
                //过滤掉系统app
                if (!showSystemApp && (ApplicationInfo.FLAG_SYSTEM & packageInfo.applicationInfo.flags) != 0) {
                    continue;
                }
                SDInstallAppInfoBean appInfoBean = new SDInstallAppInfoBean();
                appInfoBean.setAppPackageName(packageInfo.packageName);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    appInfoBean.setMinSdkVersion(packageInfo.applicationInfo.minSdkVersion);
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    appInfoBean.setInstallLocation(packageInfo.installLocation);
                }
                appInfoBean.setVersionCode(packageInfo.versionCode);
                appInfoBean.setUid(packageInfo.applicationInfo.uid);

                if (packageInfo.applicationInfo.loadIcon(packageManager) == null) {
                    continue;
                }
                appInfoBean.setAppName(packageInfo.applicationInfo.loadLabel(getPackageManager()).toString());
                appInfoBean.setImage(packageInfo.applicationInfo.loadIcon(packageManager));
                appInfos.add(appInfoBean);
            }
        } catch (Exception e) {
            SDLogUtil.i(TAG, "--------------------获取应用包信息失败---------------------");
        }
        return appInfos;
    }


    /**
     * @param packageName
     * @return
     */
    private static boolean isSpace(String packageName) {
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

    //TODO 以下-待测试~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /**
     * 静默安装App
     * <p>非root需添加权限 {@code <uses-permission android:name="android.permission.INSTALL_PACKAGES" />}</p>
     *
     * @param filePath 文件路径
     * @return {@code true}: 安装成功<br>{@code false}: 安装失败
     */
    public static boolean installAppSilent(String filePath) {
        File file = SDFileUtil.getFileByPath(filePath);
        if (!SDFileUtil.isFileExists(file)) return false;
        String command = "LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install " + filePath;
        SDShellUtil.CommandResult commandResult = SDShellUtil.execCmd(command, !isSystemApp(), true);
        return commandResult.successMsg != null && commandResult.successMsg.toLowerCase().contains("success");
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
        SDShellUtil.CommandResult commandResult = SDShellUtil.execCmd(command, !isSystemApp(), true);
        return commandResult.successMsg != null && commandResult.successMsg.toLowerCase().contains("success");
    }

    /**
     * 根据路径获取PackageName
     *
     * @param apkPath
     * @return
     */

    public String getPackageName(String apkPath) {
        PackageManager pm = getPackageManager();
        PackageInfo info = pm.getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES);
        if (info != null) {
            //既然获取了ApplicationInfo,那么和应用相关的一些信息就都可以获取了,具体可以获取什么大家可以看看ApplicationInfo这个类
            ApplicationInfo appInfo = info.applicationInfo;
            return appInfo.packageName;
        }
        return "";
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
        boolean isSuccess = SDCleanUtil.cleanInternalCache();
        isSuccess &= SDCleanUtil.cleanInternalDbs();
        isSuccess &= SDCleanUtil.cleanInternalSP();
        isSuccess &= SDCleanUtil.cleanInternalFiles();
        isSuccess &= SDCleanUtil.cleanExternalCache();
        for (File dir : dirs) {
            isSuccess &= SDCleanUtil.cleanCustomCache(dir);
        }
        return isSuccess;
    }


}
