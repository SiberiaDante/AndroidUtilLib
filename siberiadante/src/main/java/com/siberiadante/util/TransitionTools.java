package com.siberiadante.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import static com.siberiadante.SiberiaDanteLib.getActivity;

public class TransitionTools {
    public static float getDensity() {
        //屏幕dpi
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    /**
     * dip转为 px
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * px 转为 dip
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;

        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * Api方法转换
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dp2px(Context context, float dpValue) {

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics());
    }
    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
