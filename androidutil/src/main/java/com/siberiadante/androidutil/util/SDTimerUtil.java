package com.siberiadante.androidutil.util;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/9/30
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDTimerUtil {
    private static final int DEFAULT_CLICK_DELAY_TIME = 1000;
    private static long lastClickTime;

    /**
     * 防止重复点击同一按钮
     *
     * @return {@code true}:可以点击<br>{@code false}:阻止点击
     */
    public static boolean isNotFastClick() {
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) >= DEFAULT_CLICK_DELAY_TIME) {
            flag = true;
        }
        lastClickTime = curClickTime;
        return flag;
    }
}
