package com.siberiadante.lib.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Created： SiberiaDante
 * @Date： 2017/7/10
 * @Describe： 字符处理相关工具
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
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
