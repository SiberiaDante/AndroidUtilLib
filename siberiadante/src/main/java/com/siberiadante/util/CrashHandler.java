package com.siberiadante.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Created： SiberiaDante
 * @Date： 2017/7/23
 * @Describe：
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

//系统默认的UncaughtException处理类
private Thread.UncaughtExceptionHandler mDefaultHandler;
//CrashHandler实例
private static CrashHandler INSTANCE;
//程序的Context对象
private Context mContext;
//用来存储设备信息和异常信息
private Map<String, String> infos = new HashMap<String, String>();

private CrashHandler() {
        }

/**
 * 获取CrashHandler实例 ,单例模式
 */
public static CrashHandler getInstance() {
        if (INSTANCE == null)
        INSTANCE = new CrashHandler();
        return INSTANCE;
        }

/**
 * 初始化
 *
 * @param context
 */
public void init(Context context) {
        mContext = context;
        //获取系统默认的UncaughtException处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        //设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
        }

/**
 * 当UncaughtException发生时会转入该函数来处理
 */
@Override
public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
        //如果用户没有处理则让系统默认的异常处理器来处理
        mDefaultHandler.uncaughtException(thread, ex);
        } else {
        try {
        Thread.sleep(3000);
        } catch (InterruptedException e) {
        LogUtilBase.eFile(e.toString());
        }
        //退出程序
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
        }
        }

/**
 * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成.
 *
 * @param ex
 * @return true:如果处理了该异常信息;否则返回false.
 */
private boolean handleException(Throwable ex) {
        if (ex == null) {
        return false;
        }
        //收集设备参数信息
        collectDeviceInfo(mContext);
        //保存日志文件
        saveCrashInfo2File(ex);
        return true;
        }

/**
 * 收集设备参数信息
 *
 * @param ctx
 */
public void collectDeviceInfo(Context ctx) {
        try {
        PackageManager pm = ctx.getPackageManager();
        PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(), PackageManager.GET_ACTIVITIES);
        if (pi != null) {
        String versionName = pi.versionName == null ? "null" : pi.versionName;
        String versionCode = pi.versionCode + "";
        infos.put("versionName", versionName);
        infos.put("versionCode", versionCode);
        }
        } catch (PackageManager.NameNotFoundException e) {
        LogUtilBase.eFile(e.getMessage());
        }
        Field[] fields = Build.class.getDeclaredFields();
        for (Field field : fields) {
        try {
        field.setAccessible(true);
        infos.put(field.getName(), field.get(null).toString());
        } catch (Exception e) {
        LogUtilBase.eFile(e.getMessage());
        }
        }
        }

/**
 * 保存错误信息到文件中
 *
 * @param ex
 * @return 返回文件名称, 便于将文件传送到服务器
 */
private String saveCrashInfo2File(Throwable ex) {

        StringBuffer sb = new StringBuffer();
        sb.append("---------------------sta--------------------------");
        for (Map.Entry<String, String> entry : infos.entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();
        sb.append(key + "=" + value + "\n");
        }

        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause != null) {
        cause.printStackTrace(printWriter);
        cause = cause.getCause();
        }
        printWriter.close();
        String result = writer.toString();
        sb.append(result);
        sb.append("--------------------end---------------------------");
        LogUtilBase.eFile(sb.toString());
        return null;
        }

        }
