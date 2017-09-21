package com.siberiadante.lib.util;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.siberiadante.lib.SiberiaDanteLib;
public class SDTransitionUtil {
    public static float getDensity(Activity activity) {
        //屏幕dpi
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    /**
     * dip转为 px
     */
    public static int dip2px(float dipValue) {
//        final float scale = Resources.getSystem().getDisplayMetrics().density;
        final float scale = SiberiaDanteLib.getContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * px 转为 dip
     */
    public static int px2dip(float pxValue) {
        final float scale = SiberiaDanteLib.getContext().getResources().getDisplayMetrics().density;

        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * Api方法转换
     *
     * @param dpValue
     * @return
     */
    public static int dp2px(float dpValue) {

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, SiberiaDanteLib.getContext().getResources().getDisplayMetrics());
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @return
     */
    public static int px2sp(float pxValue) {
        final float fontScale = SiberiaDanteLib.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public static int sp2px(float spValue) {
        final float fontScale = SiberiaDanteLib.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
