package com.siberiadante.util;

/**
 * @Created： SiberiaDante
 * @Date： 2017/7/10
 * @Describe：
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */

public class StringUtil {

    /**
     * str1 中是否包含str2
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isHaveString(String str1, String str2) {
        if (str1.contains(str2)) {
            return true;
        } else {
            return false;
        }
    }
}
