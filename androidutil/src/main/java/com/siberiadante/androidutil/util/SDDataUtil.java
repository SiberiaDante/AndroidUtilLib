package com.siberiadante.androidutil.util;

/**
 * Created: SiberiaDante
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * 博客园:http://www.cnblogs.com/shen-hua/
 * CreateTime: 2017/5/15
 * UpDateTime:
 * Describe：数据处理相关类
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
