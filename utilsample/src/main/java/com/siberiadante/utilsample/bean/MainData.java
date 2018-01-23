package com.siberiadante.utilsample.bean;

import com.siberiadante.utilsample.activity.util.SDActivityUtilActivity;
import com.siberiadante.utilsample.activity.util.SDCacheUtilActivity;
import com.siberiadante.utilsample.activity.util.SDCleanUtilActivity;
import com.siberiadante.utilsample.activity.util.SDDeviceUtilActivity;
import com.siberiadante.utilsample.activity.util.SDFormatUtilActivity;
import com.siberiadante.utilsample.activity.util.SDJumpUtilActivity;
import com.siberiadante.utilsample.activity.util.SDAppUtilActivity;
import com.siberiadante.utilsample.activity.util.SDCloseUtilActivity;
import com.siberiadante.utilsample.activity.util.SDDateUtilActivity;
import com.siberiadante.utilsample.activity.util.SDLogUtilActivity;
import com.siberiadante.utilsample.activity.util.SDMathActivity;
import com.siberiadante.utilsample.activity.util.SDNetWorkUtilActivity;
import com.siberiadante.utilsample.activity.util.SDNumberUtilActivity;
import com.siberiadante.utilsample.activity.util.SDObjectUtilActivity;
import com.siberiadante.utilsample.activity.util.SDRegexUtilActivity;
import com.siberiadante.utilsample.activity.util.SDSPUtilActivity;
import com.siberiadante.utilsample.activity.util.SDScreenUtilActivity;
import com.siberiadante.utilsample.activity.util.SDStatusBarUtlActivity;
import com.siberiadante.utilsample.activity.util.SDStringUtilActivity;
import com.siberiadante.utilsample.activity.util.SDTimerUtilActivity;
import com.siberiadante.utilsample.activity.util.SDTransitionUtilActivity;
import com.siberiadante.utilsample.activity.view.SDLoadingViewActivity;
import com.siberiadante.utilsample.activity.widget.SDAvatarListLayoutActivity;
import com.siberiadante.utilsample.activity.widget.SDImageViewActivity;
import com.siberiadante.utilsample.activity.widget.SDShapeWidgetActivity;

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
    public static List<DataBean> getUtilData() {
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
        data.add(new DataBean("测试SDFormatUtil", SDFormatUtilActivity.class));
        data.add(new DataBean("测试SDStringUtil", SDStringUtilActivity.class));
        data.add(new DataBean("测试SDDeviceUtil", SDDeviceUtilActivity.class));
        data.add(new DataBean("测试SDStatusBarUtil", SDStatusBarUtlActivity.class));
        data.add(new DataBean("测试SDScreenUtil", SDScreenUtilActivity.class));
        data.add(new DataBean("测试SDNetWorkUtil", SDNetWorkUtilActivity.class));
        data.add(new DataBean("测试SDCleanUtil", SDCleanUtilActivity.class));
        data.add(new DataBean("测试SDCacheUtil", SDCacheUtilActivity.class));
        return data;
    }

    public static List<DataBean> getViewData() {
        List<DataBean> data = new ArrayList<>();
        data.add(new DataBean("测试加载动画", SDLoadingViewActivity.class));
        data.add(new DataBean("测试简化shape组件", SDShapeWidgetActivity.class));
        data.add(new DataBean("测试ImageView", SDImageViewActivity.class));
        data.add(new DataBean("测试头像叠加列表组件", SDAvatarListLayoutActivity.class));
        return data;
    }

    public static List<DataBean> getWidgetData() {
        List<DataBean> data = new ArrayList<>();
        data.add(new DataBean("测试加载动画", SDLoadingViewActivity.class));
        data.add(new DataBean("测试简化shape组件", SDShapeWidgetActivity.class));
        data.add(new DataBean("测试ImageView", SDImageViewActivity.class));
        data.add(new DataBean("测试ImageView", SDAvatarListLayoutActivity.class));
        return data;
    }
}
