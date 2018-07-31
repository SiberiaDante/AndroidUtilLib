package com.siberiadante.androidutil.util;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by SiberiaDante on 2017/5/4.
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * 博客园:http://www.cnblogs.com/shen-hua/
 * CreateTime: 2017/5/15
 * UpDateTime:
 * Describe：
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

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String[] CHINESE_ZODIAC = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};

    public SDDateUtil() {
        throw new UnsupportedOperationException("not init SDAndroidLib");
    }

    /**
     * get the current year
     *
     * @return year
     */
    public static String getYear() {
        String format = "yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * get the current timestamp (accurate to seconds)
     *
     * @return timestamp
     */
    public static String getTimeStamp() {
        long time = System.currentTimeMillis();
        return String.valueOf(time / 1000);
    }

    /**
     * get the current month
     *
     * @return month
     */
    public static String getMonth() {
        String format = "MM";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * get the current day
     *
     * @return day
     */
    public static String getDay() {
        String format = "dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * get the current hour
     *
     * @return hour
     */
    public static String getHour() {
        String format = "HH";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * get the current minute
     *
     * @return minute
     */
    public static String getMinute() {
        String format = "mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * get the current second
     *
     * @return second
     */
    public static String getSecond() {
        String format = "ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * get the current hours:minutes
     *
     * @return time format：HH:mm   15:44
     */
    public static String getSDFTimeHm() {
        String format = "HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @return time format：h:mm a    3:44 下午
     */
    public static String getSDFTimeHmA() {
        String format = "h:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @return time format：HH:mm:ss    15:44:40
     */
    public static String getSDFTimeHms() {
        String format = "HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @return time format：yyyy-MM-dd    2016-08-12
     */
    public static String getSDFTimeYMd() {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @return time format：yyyy-MM-dd HH:mm    2016-08-12 15:44
     */
    public static String getSDFTimeYMdHm() {
        String format = "yyyy-MM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @return time format：yyyy-MM-dd HH:mm:ss    2016-08-12 15:44:40
     */
    public static String getSDFTimeYMdHms() {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @return time format：yyyy.MM.dd G 'at' HH:mm:ss z    2016.08.12 公元 at 15:44:40 CST
     */
    public static String getSDFTimeCST() {
        String format = "yyyy.MM.dd G 'at' HH:mm:ss z";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @param str timestamp
     * @return time format：yyyy-MM-dd HH:mm:ss
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
     * @return time format：yyyy年MM月dd日 HH时mm分ss秒
     */
    public static String getStrToTime() {
        String format = "yyyy年MM月dd日 HH时mm分ss秒";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @param str timestamp
     * @return time format：HH:mm    15:44
     */
    public static String getStrToTimeHm(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            return "";
        }
        String format = "HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(str);
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @param str timestamp
     * @return time format：HH:mm:ss    15:44:40
     */
    public static String getStrToTimeHms(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            return "";
        }
        String format = "HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(str);
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * @param str timestamp
     * @return time format：yyyy-MM-dd HH:mm    2016-08-12 15:44
     */
    public static String getStrToTimeYMdHm(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            return "";
        }
        String format = "yyyy-MM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(str);
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * according to date and date format string convert to timestamp
     *
     * @param str    date str
     * @param format time format
     * @return timestamp
     */
    public static String getTimeStampFromFormat(String str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
            return String.valueOf(sdf.parse(str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * support the output of various formats of the current date and time
     *
     * @param format time format of your definition
     * @return date or time
     */
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public static String getSDFTime(String format) {
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(getTimeStamp());
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * get the time based on timestamp and time format
     *
     * @param timestamp timestamp
     * @param format    time format
     * @return time, date
     */
    public static String getSDFDateFromTimeStamp(String timestamp, String format) {
        if (timestamp == null || timestamp.isEmpty() || timestamp.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Long strLong = Long.valueOf(timestamp);
        return sdf.format(new Date(strLong * 1000));
    }

    /**
     * get the total number of days this month
     *
     * @param year
     * @param month
     * @return
     */
    public static int getMonthOfDay(int year, int month) {
        int day = 0;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            day = 29;
        } else {
            day = 28;
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return day;
        }
        return 0;
    }

    /**
     * judge constellation form the date (month and day)
     *
     * @param month month
     * @param day   day
     * @return constellation
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

    /**
     * judge the time whether is leap year
     *
     * @param time time with format,like:{@code  yyyy-MM-dd HH:mm:ss}
     * @return {@code true}: is leap year<br>{@code false}: is average year
     */
    public static boolean isLeapYear(String time) {
        return isLeapYear(string2Date(time, DEFAULT_PATTERN));
    }

    /**
     * judge this date whether is leap year
     *
     * @param date date object
     * @return {@code true}: is leap year<br>{@code false}: is average year
     */
    public static boolean isLeapYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        return isLeapYear(year);
    }

    /**
     * time convert to date object
     *
     * @param time    time str
     * @param pattern time format
     * @return type:Date
     */
    public static Date string2Date(String time, String pattern) {
        return new Date(string2Millis(time, pattern));
    }

    /**
     * judge this year whether is leap year
     *
     * @param year number of year
     * @return {@code true}: is leap year<br>{@code false}: is average year
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * convert to the  millisecond timestamp according to date and date pattern
     *
     * @param time    time str
     * @param pattern time pattern
     * @return the millisecond timestamp
     */
    public static long string2Millis(String time, String pattern) {
        try {
            return new SimpleDateFormat(pattern, Locale.getDefault()).parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * convert to time according to the millisecond timestamp adn date pattern
     *
     * @param millisecond the millisecond timestamp
     * @param pattern     time pattern
     * @return time, date
     */
    public static String getSDFDateFromMillisTimeStamp(String millisecond, String pattern) {
        if (millisecond == null || millisecond.isEmpty() || millisecond.equals("null")) {
            return "";
        }
        if (pattern == null || pattern.isEmpty()) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        return new SimpleDateFormat(pattern, Locale.getDefault()).format(new Date(Long.valueOf(millisecond)));
    }

    /**
     * judge is leap year
     *
     * @param time    time format,format need same whit the params #pattern
     * @param pattern time pattern
     * @return {@code true}: is leap year<br>{@code false}: is average year
     */
    public static boolean isLeapYear(String time, String pattern) {
        return isLeapYear(string2Date(time, pattern));
    }

    /**
     * judge is leap year based on millis time
     *
     * @param millis the millis timestamp
     * @return {@code true}: is leap year<br>{@code false}: is average year
     */
    public static boolean isLeapYear(long millis) {
        return isLeapYear(millis2Date(millis));
    }

    /**
     * convert
     *
     * @param millis the millis timestamp
     * @return {@link Date}
     */
    public static Date millis2Date(long millis) {
        return new Date(millis);
    }

    /**
     * get the week
     *
     * @param time    time str
     * @param pattern time pattern
     * @return the week str
     */
    public static String getWeek(String time, String pattern) {
        return getWeek(string2Date(time, pattern));
    }

    /**
     * get the week
     *
     * @param date {@link Date}
     * @return the week str
     */
    public static String getWeek(Date date) {
        return new SimpleDateFormat("EEEE", Locale.getDefault()).format(date);
    }

    /**
     * get the week
     *
     * @param millis the milliseconds timestamp
     * @return the week str
     */
    public static String getWeek(long millis) {
        return getWeek(new Date(millis));
    }

    /**
     * get the week
     *
     * @param time    time str
     * @param pattern time pattern
     * @return 1...7
     */
    public static int getWeekIndex(String time, String pattern) {
        return getWeekIndex(string2Date(time, pattern));
    }

    /**
     * get the week
     *
     * @param date {@link Date}
     * @return 1...7
     */
    public static int getWeekIndex(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * get the week
     *
     * @param millis the milliseconds timestamp
     * @return 1...7
     */
    public static int getWeekIndex(long millis) {
        return getWeekIndex(millis2Date(millis));
    }

    /**
     * get the week of the month
     *
     * @param time    time str
     * @param pattern time pattern
     * @return 1...
     */
    public static int getWeekOfMonth(String time, String pattern) {
        return getWeekOfMonth(string2Date(time, pattern));
    }

    /**
     * get the week of the month
     *
     * @param date {@link Date}
     * @return 1...
     */
    public static int getWeekOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * get the week of the month
     *
     * @param millis the milliseconds timestamp
     * @return 1...5
     */
    public static int getWeekOfMonth(long millis) {
        return getWeekOfMonth(millis2Date(millis));
    }

    /**
     * get the week of this year
     *
     * @param time    time str
     * @param pattern time pattern
     * @return 1...54
     */
    public static int getWeekOfYear(String time, String pattern) {
        return getWeekOfYear(string2Date(time, pattern));
    }

    /**
     * get the week of the year
     *
     * @param date {@link Date}
     * @return 1...54
     */
    public static int getWeekOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * Obtain which  week of this year according to the milliseconds timestamp
     *
     * @param millis the milliseconds timestamp
     * @return 1.2.3.4...
     */
    public static int getWeekOfYear(long millis) {
        return getWeekOfYear(millis2Date(millis));
    }


    /**
     * Obtain The Chinese Zodiac according to the time str and this time pattern
     *
     * @param time    time str
     * @param pattern time pattern
     * @return The Chinese Zodiac
     */
    public static String getChineseZodiac(String time, String pattern) {
        return getChineseZodiac(string2Date(time, pattern));
    }

    /**
     * Obtain The Chinese Zodiac according to the {@link Date}
     *
     * @param date {@link Date}
     * @return The Chinese Zodiac
     */
    public static String getChineseZodiac(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return CHINESE_ZODIAC[cal.get(Calendar.YEAR) % 12];
    }

    /**
     * Obtain The Chinese Zodiac according to the millisecond timestamp
     *
     * @param millis the millisecond timestamp
     * @return The Chinese Zodiac
     */
    public static String getChineseZodiac(long millis) {
        return getChineseZodiac(millis2Date(millis));
    }

    /**
     * obtain The Chinese Zodiac according to the year
     *
     * @param year year
     * @return he Chinese Zodiac
     */
    public static String getChineseZodiac(int year) {
        return CHINESE_ZODIAC[year % 12];
    }
}