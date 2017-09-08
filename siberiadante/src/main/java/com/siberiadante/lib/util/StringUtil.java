package com.siberiadante.lib.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            LogUtil.d(true + "");
            return true;
        } else {
            LogUtil.d(false + "");
            return false;
        }
    }

    /**
     * 半角转换为全角
     * SBC全角；DBC半角
     *
     * @param text
     * @return
     */
    public static String toSBC(String text) {
        char[] c = text.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    /**
     * 去除特殊字符或将所有中文标号替换为英文标号
     *
     * @param str
     * @return
     */
    public static String removeSpecialString(String str) {
        str = str.replaceAll("【", "[").replaceAll("】", "]")
                .replaceAll("！", "!").replaceAll("：", ":");// 替换中文标号
        String regEx = "[『』]"; // 清除掉特殊字符
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    public static boolean isEmpty(String str) {

        return (str == null || str.trim().length() == 0);
    }
}
