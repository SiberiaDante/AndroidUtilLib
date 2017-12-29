package com.siberiadante.utilsample.bean;

import com.siberiadante.utilsample.activity.ActivityUtilActivity;
import com.siberiadante.utilsample.activity.JumpUtilActivity;
import com.siberiadante.utilsample.activity.SDAppUtilActivity;
import com.siberiadante.utilsample.activity.SDCloseUtilActivity;
import com.siberiadante.utilsample.activity.SDDateUtilActivity;
import com.siberiadante.utilsample.activity.SDTransitionUtilActivity;
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
        data.add(new DataBean("测试SDAPPUtil", SDAppUtilActivity.class));
        data.add(new DataBean("测试SDCloseUtil", SDCloseUtilActivity.class));
        data.add(new DataBean("测试SDJumpUtil", JumpUtilActivity.class));
        data.add(new DataBean("测试SDTimerUtil", TimerUtilActivity.class));
        data.add(new DataBean("测试SDTransitionUtil", SDTransitionUtilActivity.class));
        data.add(new DataBean("测试SDDateUtil", SDDateUtilActivity.class));

        return data;
    }
}
