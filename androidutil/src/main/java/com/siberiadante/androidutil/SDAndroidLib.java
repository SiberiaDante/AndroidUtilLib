package com.siberiadante.androidutil;

import android.content.Context;
import android.util.Log;

import com.siberiadante.androidutil.util.SDLogUtil;

/**
 * Created: SiberiaDante
 * Describe：
 * CreateTime: 2017/12/25
 * UpDateTime:
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * Blog: http://www.cnblogs.com/shen-hua/
 */

public class SDAndroidLib {
    private static Context context;

    public static boolean isDebug;

    /**
     * 初始化
     *
     * @param context
     */
    public static void initLib(Context context) {
        SDAndroidLib.context = context.getApplicationContext();
    }

    public static void setDebug(boolean debug) {
        isDebug = debug;
    }

    /**
     * @return Application Context
     */
    public static Context getContext() {
        if (context != null) {
            return context;
        } else {
            throw new NullPointerException("Use this lib,you need init first!");
        }
    }
}
