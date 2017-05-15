package com.siberiadante.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.siberiadante.SiberiaDanteLib;

import static com.siberiadante.SiberiaDanteLib.getActivity;

/**
 * Created by SiberiaDante on 2017/5/4.
 * 屏幕相关工具类
 */

public class ScreenUtil {
    public static float getDensity(Activity activity) {
        //屏幕dpi
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }
    /**
     *
     * @param activity
     * @return 获取屏幕的宽 单位：px
     */
    public static int getScreenWidthPx(Activity activity) {
        WindowManager windowManager = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     *
     * @param activity
     * @return 获取屏幕的高 单位：px
     */
    public static int getScreenHeightPx(Activity activity) {
        WindowManager windowManager = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }
    /**
     *
     * @param activity
     * @return 获取屏幕的宽 单位：dp
     */
    public static int getScreenWidthDp(Activity activity) {
        WindowManager windowManager = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return TransitionTools.px2dip(SiberiaDanteLib.getContext(),dm.widthPixels);
    }
    /**
     *
     * @param activity
     * @return 获取屏幕的高 单位：dp
     */
    public static int getScreenHeightDp(Activity activity) {
        WindowManager windowManager = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return TransitionTools.px2dip(SiberiaDanteLib.getContext(),dm.heightPixels);
    }
}
