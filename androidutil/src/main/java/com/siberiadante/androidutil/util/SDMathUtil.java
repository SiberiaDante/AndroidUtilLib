package com.siberiadante.androidutil.util;

/**
 * Created: SiberiaDante
 * Describe： 数学公式计算工具类
 * Time: 2017/9/5
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
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

    /**
     * 整型数组求和
     *
     * @param ints
     * @return
     */
    public static int intsGetSum(int[] ints) {
        int sum = 0;

        for (int i = 0, len = ints.length; i < len; i++) {
            sum += ints[i];
        }

        return sum;
    }
}
