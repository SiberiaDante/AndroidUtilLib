package com.siberiadante.androidutil;

import android.content.Context;
import android.util.Log;

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

    /**
     * 初始化
     *
     * @param context
     */
    public static void initLib(Context context) {
        SDAndroidLib.context = context.getApplicationContext();
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
