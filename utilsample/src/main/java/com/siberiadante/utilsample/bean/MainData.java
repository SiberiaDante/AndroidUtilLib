package com.siberiadante.utilsample.bean;

import com.siberiadante.utilsample.activity.SDActivityUtilActivity;
import com.siberiadante.utilsample.activity.SDJumpUtilActivity;
import com.siberiadante.utilsample.activity.SDAppUtilActivity;
import com.siberiadante.utilsample.activity.SDCloseUtilActivity;
import com.siberiadante.utilsample.activity.SDDateUtilActivity;
import com.siberiadante.utilsample.activity.SDLogUtilActivity;
import com.siberiadante.utilsample.activity.SDMathActivity;
import com.siberiadante.utilsample.activity.SDNumberUtilActivity;
import com.siberiadante.utilsample.activity.SDObjectUtilActivity;
import com.siberiadante.utilsample.activity.SDRegexUtilActivity;
import com.siberiadante.utilsample.activity.SDSPUtilActivity;
import com.siberiadante.utilsample.activity.SDTimerUtilActivity;
import com.siberiadante.utilsample.activity.SDTransitionUtilActivity;

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
        data.add(new DataBean("测试SDActivityUtil", SDActivityUtilActivity.class));
        data.add(new DataBean("测试SDAPPUtil", SDAppUtilActivity.class));
        data.add(new DataBean("测试SDCloseUtil", SDCloseUtilActivity.class));
        data.add(new DataBean("测试SDJumpUtil", SDJumpUtilActivity.class));
        data.add(new DataBean("测试SDTimerUtil", SDTimerUtilActivity.class));
        data.add(new DataBean("测试SDTransitionUtil", SDTransitionUtilActivity.class));
        data.add(new DataBean("测试SDDateUtil", SDDateUtilActivity.class));
        data.add(new DataBean("测试SDNumberUtil", SDNumberUtilActivity.class));
        data.add(new DataBean("测试SDRegexUtil", SDRegexUtilActivity.class));
        data.add(new DataBean("测试SDMathUtil", SDMathActivity.class));
        data.add(new DataBean("测试SDLogUtil", SDLogUtilActivity.class));
        data.add(new DataBean("测试SDSPUtil", SDSPUtilActivity.class));
        data.add(new DataBean("测试SDObjectUtil", SDObjectUtilActivity.class));
        return data;
    }
}
