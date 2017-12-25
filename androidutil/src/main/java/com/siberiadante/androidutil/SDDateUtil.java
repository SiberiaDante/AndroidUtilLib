package com.siberiadante.androidutil;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by SiberiaDante on 2017/5/4.
 * 格式转换参考
 * HH:mm    15:44
 * h:mm a    3:44 下午
 * HH:mm z    15:44 CST
 * HH:mm Z    15:44 +0800
 * HH:mm zzzz    15:44 中国标准时间
 * HH:mm:ss    15:44:40
 * yyyy-MM-dd    2016-08-12
 * yyyy-MM-dd HH:mm    2016-08-12 15:44
 * yyyy-MM-dd HH:mm:ss    2016-08-12 15:44:40
 * yyyy-MM-dd HH:mm:ss zzzz    2016-08-12 15:44:40 中国标准时间
 * EEEE yyyy-MM-dd HH:mm:ss zzzz    星期五 2016-08-12 15:44:40 中国标准时间
 * yyyy-MM-dd HH:mm:ss.SSSZ    2016-08-12 15:44:40.461+0800
 * yyyy-MM-dd'T'HH:mm:ss.SSSZ    2016-08-12T15:44:40.461+0800
 * yyyy.MM.dd G 'at' HH:mm:ss z    2016.08.12 公元 at 15:44:40 CST
 * K:mm a    3:44 下午
 * EEE, MMM d, ''yy    星期五, 八月 12, '16
 * hh 'o''clock' a, zzzz    03 o'clock 下午, 中国标准时间
 * yyyyy.MMMMM.dd GGG hh:mm aaa    02016.八月.12 公元 03:44 下午
 * EEE, d MMM yyyy HH:mm:ss Z    星期五, 12 八月 2016 15:44:40 +0800
 * yyMMddHHmmssZ    160812154440+0800
 * yyyy-MM-dd'T'HH:mm:ss.SSSZ    2016-08-12T15:44:40.461+0800
 * EEEE 'DATE('yyyy-MM-dd')' 'TIME('HH:mm:ss')' zzzz    星期五 DATE(2016-08-12) TIME(15:44:40) 中国标准时间
 */

public class SDDateUtil {
    public SDDateUtil() {throw new UnsupportedOperationException("not init SDAndroidLib");
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


    /**
     * 获取当前时间（格式：HH:mm）
     *
     * @return HH:mm    15:44
     */
    public static String getSDFTimeHm() {
        String format = "HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @return h:mm a    3:44 下午
     */
    public static String getSDFTimeHmA() {
        String format = "h:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @return 时间格式：HH:mm:ss    15:44:40
     */
    public static String getSDFTimeHms() {
        String format = "HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @return yyyy-MM-dd    2016-08-12
     */
    public static String getSDFTimeYMd() {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @return yyyy-MM-dd HH:mm    2016-08-12 15:44
     */
    public static String getSDFTimeYMdHm() {
        String format = "yyyy-MM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @return yyyy-MM-dd HH:mm:ss    2016-08-12 15:44:40
     */
    public static String getSDFTimeYMdHms() {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @return yyyy-MM-dd HH:mm:ss    2016-08-12 15:44:40
     */
    public static String getSDFTimeYMDHSM() {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }


    /**
     * @return yyyy.MM.dd G 'at' HH:mm:ss z    2016.08.12 公元 at 15:44:40 CST
     */
    public static String getSDFTimeCST() {
        String format = "yyyy.MM.dd G 'at' HH:mm:ss z";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * 默认时间格式：yyyy-MM-dd HH:mm:ss
     *
     * @param str 时间戳
     * @return
     */
    public static String getStrToTime(String str) {
        //判断时间戳是否为空
        if (str == null || str.isEmpty() || str.equals("null")) {
            return "";
        }
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(str);
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @return
     */
    public static String getStrToTime() {
        String format = "yyyy年MM月dd日 HH时mm分ss秒";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @param str 时间戳
     * @return HH:mm    15:44
     */
    public static String getStrToTimeHm(String str) {
        //判断时间戳是否为空
        if (str == null || str.isEmpty() || str.equals("null")) {
            return "";
        }
        String format = "HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(str);
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * 默认时间格式：yyyy-MM-dd HH:mm:ss
     *
     * @param str 时间戳
     * @return HH:mm:ss    15:44:40
     */
    public static String getStrToTimeHms(String str) {
        //判断时间戳是否为空
        if (str == null || str.isEmpty() || str.equals("null")) {
            return "";
        }
        String format = "HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(str);
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @param str 时间戳
     * @return yyyy-MM-dd HH:mm    2016-08-12 15:44
     */
    public static String getStrToTimeYMdHm(String str) {
        //判断时间戳是否为空
        if (str == null || str.isEmpty() || str.equals("null")) {
            return "";
        }
        String format = "yyyy-MM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(str);
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param str    时间戳
     * @param format 时间转换格式 (参考前面）
     * @return 时间
     */
    public static String getDateToTimeStamp(String str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
            return String.valueOf(sdf.parse(str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 支持输出各种格式的日期、时间
     *
     * @param format
     * @return 日期、时间格式
     */
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public static String getSDFTime(String format) {

        //未指定format格式时默认输出yyyy-MM-dd HH:mm:ss
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * 支持输出各种格式的日期、时间
     *
     * @param str    时间戳
     * @param format
     * @return 日期、时间格式
     */
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public static String getStrToSDFTime(String str, String format) {
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
     * 根据日期判断星座
     *
     * @param month 月份
     * @param day   天
     * @return 星座
     */
    public static String getConstellation(int month, int day) {
        String[] starArr = {"魔羯座", "水瓶座", "双鱼座", "牡羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座"};
        int[] DayArr = {22, 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22};  // 两个星座分割日

        if (month <= 0 || day <= 0) {
            return "猴年马月座";
        } else if (month > 12 || day > 31) {
            return "猴年马月座";
        }

        int index = month;
        // 所查询日期在分割日之前，索引-1，否则不变
        if (day < DayArr[month - 1]) {
            index = index - 1;
        }
        // 返回索引指向的星座string
        return starArr[index];
    }
}