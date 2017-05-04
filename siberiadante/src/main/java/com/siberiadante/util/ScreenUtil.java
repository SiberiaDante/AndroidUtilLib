package com.siberiadante.util;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by SiberiaDante on 2017/5/4.
 * 需要在使用页面进行初始化
 */

public class ScreenUtil {
    private static float density = -1;

    public static int ScreenWidth;
    public static int ScreenHeight;

    public static void init(Activity activity) {
        initDensity(activity);
    }

    private static void initDensity(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        density = dm.density;
        ScreenWidth = dm.widthPixels;
        ScreenHeight = dm.heightPixels;
    }
}
