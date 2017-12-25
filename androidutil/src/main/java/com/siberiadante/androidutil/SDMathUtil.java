package com.siberiadante.androidutil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/5
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDMathUtil {
    /**
     * sin计算
     *
     * @param angle
     * @return
     */
    public static float sin(int angle) {
        return (float) Math.sin(angle * Math.PI / 180);
    }

    /**
     * cos计算
     *
     * @param angle
     * @return
     */
    public static float cos(int angle) {
        return (float) Math.cos(angle * Math.PI / 180);
    }
}
