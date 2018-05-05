package com.siberiadante.androidutil.util;

import com.siberiadante.androidutil.util.SDRegexUtil;

/**
 * Created:： SiberiaDante
 *
 * @Date： 2017/7/10
 * Describe： 字符处理相关工具
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */

public class SDNumberUtil {

    /**
     * 判断字符串是否全是数字
     * tips:不输入任何内容默认为数字，空格不是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        return SDRegexUtil.isNum(str);
    }

    /**
     * 验证字符串是否是正整数
     * tips:不输入任何内容默认为数字，空格不是数字
     *
     * @param integer 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isPositionInteger(String integer) {
        return SDRegexUtil.isPositionInteger(integer);
    }

    /**
     * 验证字符串是否是负整数
     * tips:不输入任何内容默认为数字，空格不是数字
     *
     * @param integer 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isNegativeInteger(String integer) {
        return SDRegexUtil.isNegativeInteger(integer);

    }

    /**
     * 验证整数（正整数和负整数）
     *
     * @param integer 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isInteger(String integer) {
        return SDRegexUtil.isInteger(integer);

    }

    /**
     * 验证正数、负数、和小数
     *
     * @param decimals 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isDecimals(String decimals) {
        return SDRegexUtil.isDecimals(decimals);

    }
}
