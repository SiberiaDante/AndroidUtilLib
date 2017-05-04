package com.siberiadante.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by SiberiaDante on 2017/5/4.
 */

public class DateUtil {

    /**
     * 支持输出各种格式的日期、时间
     *
     * @param str    时间戳
     * @param format (yyyy年MM月dd日HH时mm分ss秒)(yyyy-MM-dd HH:mm:ss yyyy-MM-dd HH:mm:ss)(yyyy-MM-dd)。。。
     * @return 日期、时间格式
     */
    public static String getSDFTime(String str, String format) {
        //判断时间戳是否为空
        if (str == null || str.isEmpty() || str.equals("null")) {
            return "";
        }
        //未指定format格式时默认输出yyyy-MM-dd HH:mm:ss
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(str);
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param date_str
     * @param format
     * @return 时间戳
     */
    public static String date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
            return String.valueOf(sdf.parse(date_str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得当前时间戳（精确到秒）
     *
     * @return 时间戳
     */
    public static String getTimeStamp() {
        long time = System.currentTimeMillis();
        return String.valueOf(time / 1000);
    }

}