package com.siberiadante.util;

import android.util.Log;

import com.siberiadante.constants.AppInfo;
import com.siberiadante.exception.SiberiaDanteLibException;

/**
 * @Created SiberiaDante
 * @Describe： 日志打印工具类
 * @Time: 2017/8/7
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class LogUtil {
    public LogUtil() {
        new SiberiaDanteLibException();
    }

    public static String TAG = "SiberiaDante";
    private static boolean isDebug = AppInfo.getInstance().isDebug();


    public static void setTag(String tag) {
        LogUtil.TAG = tag;
    }

    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }


    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    public static void w(String msg) {
        if (isDebug)
            Log.w(TAG, msg);
    }

    public static void w(String tag, String msg) {
        if (isDebug)
            Log.w(TAG, msg);
    }

    /**
     * 带时间戳日志，级别i
     *
     * @param tag
     * @param msg
     */
    public static void printTimeLogI(String tag, String msg) {
        d(tag + "[" + DateUtil.getSDFTime(DateUtil.getTimeStamp()) + "]:" + msg);
    }

    /**
     * 带时间戳日志，级别d
     *
     * @param tag
     * @param msg
     */
    public static void printTimeLogD(String tag, String msg) {
        d(tag + "[" + DateUtil.getSDFTime(DateUtil.getTimeStamp()) + "]:" + msg);
    }

    /**
     * 带时间戳日志，级别e
     *
     * @param tag
     * @param msg
     */
    public static void printTimeLogE(String tag, String msg) {
        d(tag + "[" + DateUtil.getSDFTime(DateUtil.getTimeStamp()) + "]:" + msg);
    }

    /**
     * 带时间戳日志，级别v
     *
     * @param tag
     * @param msg
     */
    public static void printTimeLogV(String tag, String msg) {
        d(tag + "[" + DateUtil.getSDFTime(DateUtil.getTimeStamp()) + "]:" + msg);
    }

    /**
     * 带时间戳日志，级别w
     *
     * @param tag
     * @param msg
     */
    public static void printTimeLogW(String tag, String msg) {
        d(tag + "[" + DateUtil.getSDFTime(DateUtil.getTimeStamp()) + "]:" + msg);
    }

}
