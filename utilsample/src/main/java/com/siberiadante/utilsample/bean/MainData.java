package com.siberiadante.utilsample.bean;

import com.siberiadante.utilsample.activity.ActivityUtilActivity;
import com.siberiadante.utilsample.activity.JumpUtilActivity;
import com.siberiadante.utilsample.activity.TimerUtilActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/12/25
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */

public class MainData {
    public static List<DataBean> getData() {
        List<DataBean> data = new ArrayList<>();
        data.add(new DataBean("测试SDActivityUtil", ActivityUtilActivity.class));
        data.add(new DataBean("测试SDJumpUtil", JumpUtilActivity.class));
        data.add(new DataBean("测试SDTimerUtil", TimerUtilActivity.class));

        return data;
    }
}
