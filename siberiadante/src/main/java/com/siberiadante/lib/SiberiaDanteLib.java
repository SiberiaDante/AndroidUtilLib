package com.siberiadante.lib;

import android.annotation.SuppressLint;
import android.content.Context;

import com.siberiadante.R;
import com.siberiadante.lib.constants.AppInfo;

/**
 * Created by SiberiaDante on 2017/5/10.
 * user this lib,you should init it first：context
 */

public class SiberiaDanteLib {
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public SiberiaDanteLib() {
        throw new UnsupportedOperationException("not init SiberiaDanteLib");
    }

    /**
     * 初始化
     *
     * @param context
     */
    public static void initLib(Context context) {
        SiberiaDanteLib.context = context.getApplicationContext();
    }

    /**
     * 日志输出控制
     *
     * @param isDebug
     */
    public static void setDebug(boolean isDebug) {
        AppInfo.getInstance().getSPUtils().put("is_debug", isDebug);
    }


    public static Context getContext() {
        if (context != null) {
            return context;
        } else {
            throw new NullPointerException(context.getString(R.string.NotInitError));

        }
    }
}
