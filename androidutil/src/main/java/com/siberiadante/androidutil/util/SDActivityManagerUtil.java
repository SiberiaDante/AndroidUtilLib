package com.siberiadante.androidutil.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: SiberiaDante
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * Blog: http://www.cnblogs.com/shen-hua/
 * CreateTime: 2018/02/27.
 * UpDateTime:
 * Describe： Activity管理工具类
 */
public class SDActivityManagerUtil {
    private static List<Activity> activityList = new ArrayList<>();

    /**
     * 把当前Activity添加到activityList集合中
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        if (!activityList.contains(activity)) {
            activityList.add(activity);
        }
    }

    /**
     * 把当前Activity从activityList集合中移除
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        if (activityList.contains(activity)) {
            activityList.remove(activity);
        }
    }

    /**
     * 把当前Activity从activityList集合中移除并销毁
     *
     * @param activity
     */
    public static void finishActivity(Activity activity) {
        removeActivity(activity);
        activity.finish();
    }

    /**
     * 从当前activityList集合中销毁所有的Activity
     */
    public static void finishAllActivity() {
        for (Activity activity : activityList) {
            removeActivity(activity);
            activity.finish();
        }
    }
}
