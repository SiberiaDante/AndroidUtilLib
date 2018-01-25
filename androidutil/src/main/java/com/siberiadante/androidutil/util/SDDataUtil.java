package com.siberiadante.androidutil.util;


/**
 * @Created SiberiaDante
 * @Describe： 数据处理相关类
 * @Time: 2017/9/26
 * @UpDate: 2017-09-27
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDDataUtil {

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
