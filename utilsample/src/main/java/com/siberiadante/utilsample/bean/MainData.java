package com.siberiadante.utilsample.bean;

import com.siberiadante.utilsample.activity.adapter.SDRecyclerViewAdapterActivity;
import com.siberiadante.utilsample.activity.util.SDActivityUtilActivity;
import com.siberiadante.utilsample.activity.util.SDBitmapUtilActivity;
import com.siberiadante.utilsample.activity.util.SDCacheUtilActivity;
import com.siberiadante.utilsample.activity.util.SDCleanUtilActivity;
import com.siberiadante.utilsample.activity.util.SDDataUtilActivity;
import com.siberiadante.utilsample.activity.util.SDDeviceUtilActivity;
import com.siberiadante.utilsample.activity.util.SDEncryptUtilActivity;
import com.siberiadante.utilsample.activity.util.SDFileUtilActivity;
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
import com.siberiadante.utilsample.activity.util.SDPhotoUtilsActivity;
import com.siberiadante.utilsample.activity.util.SDProcessUtilActivity;
import com.siberiadante.utilsample.activity.util.SDRegexUtilActivity;
import com.siberiadante.utilsample.activity.util.SDSPUtilActivity;
import com.siberiadante.utilsample.activity.util.SDScreenUtilActivity;
import com.siberiadante.utilsample.activity.util.SDStatusBarUtlActivity;
import com.siberiadante.utilsample.activity.util.SDStorageUtilActivity;
import com.siberiadante.utilsample.activity.util.SDStringUtilActivity;
import com.siberiadante.utilsample.activity.util.SDTimerUtilActivity;
import com.siberiadante.utilsample.activity.util.SDTransitionUtilActivity;
import com.siberiadante.utilsample.activity.view.SDDialogViewActivity;
import com.siberiadante.utilsample.activity.view.SDLoadingViewActivity;
import com.siberiadante.utilsample.activity.view.SDRankingActivity;
import com.siberiadante.utilsample.activity.view.SDStepViewActivity;
import com.siberiadante.utilsample.activity.widget.SDAvatarListLayoutActivity;
import com.siberiadante.utilsample.activity.widget.SDEditTextWidgetActivity;
import com.siberiadante.utilsample.activity.widget.SDFlowTagLayoutActivity;
import com.siberiadante.utilsample.activity.widget.SDImageViewActivity;
import com.siberiadante.utilsample.activity.widget.SDOverScrollBehaviorActivity;
import com.siberiadante.utilsample.activity.widget.SDShapeWidgetActivity;
import com.siberiadante.utilsample.activity.widget.SDSpecialWidgetActivity;
import com.siberiadante.utilsample.activity.widget.SDTextViewActivity;
import com.siberiadante.utilsample.activity.widget.SDTitleLayoutWidgetActivity;
import com.siberiadante.utilsample.activity.widget.VerificationCodeViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: SiberiaDante
 * Describe：
 * CreateTime: 2017/12/25
 * UpDateTime:
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * Blog: http://www.cnblogs.com/shen-hua/
 */

public class MainData {
    public static List<DataBean> getUtilData() {
        List<DataBean> data = new ArrayList<>();
        data.add(new DataBean("测试SDActivityUtil", SDActivityUtilActivity.class));
        data.add(new DataBean("测试SDAPPUtil", SDAppUtilActivity.class));
        data.add(new DataBean("测试SDBitmapUtil", SDBitmapUtilActivity.class));
        data.add(new DataBean("测试SDCacheUtil", SDCacheUtilActivity.class));
        data.add(new DataBean("测试SDCleanUtil", SDCleanUtilActivity.class));
        data.add(new DataBean("测试SDCloseUtil", SDCloseUtilActivity.class));
        data.add(new DataBean("测试SDDataUtil", SDDataUtilActivity.class));
        data.add(new DataBean("测试SDDateUtil", SDDateUtilActivity.class));
        data.add(new DataBean("测试SDDeviceUtil", SDDeviceUtilActivity.class));
        data.add(new DataBean("测试加解密Util", SDEncryptUtilActivity.class));
        data.add(new DataBean("测试SDFileUtil", SDFileUtilActivity.class));
        data.add(new DataBean("测试SDFormatUtil", SDFormatUtilActivity.class));
        data.add(new DataBean("测试SDJumpUtil", SDJumpUtilActivity.class));
        data.add(new DataBean("测试SDLogUtil", SDLogUtilActivity.class));
        data.add(new DataBean("测试SDMathUtil", SDMathActivity.class));
        data.add(new DataBean("测试SDNetWorkUtil", SDNetWorkUtilActivity.class));
        data.add(new DataBean("测试SDNumberUtil", SDNumberUtilActivity.class));
        data.add(new DataBean("测试SDObjectUtil", SDObjectUtilActivity.class));
        data.add(new DataBean("测试SDPhotoUtil", SDPhotoUtilsActivity.class));
        data.add(new DataBean("测试SDProcessUtil", SDProcessUtilActivity.class));
        data.add(new DataBean("测试SDRegexUtil", SDRegexUtilActivity.class));
        data.add(new DataBean("测试SDScreenUtil", SDScreenUtilActivity.class));
        data.add(new DataBean("测试SDSPUtil", SDSPUtilActivity.class));
        data.add(new DataBean("测试SDStatusBarUtil", SDStatusBarUtlActivity.class));
        data.add(new DataBean("测试SDStorageUtil", SDStorageUtilActivity.class));
        data.add(new DataBean("测试SDStringUtil", SDStringUtilActivity.class));
        data.add(new DataBean("测试SDTimerUtil", SDTimerUtilActivity.class));
        data.add(new DataBean("测试SDTransitionUtil", SDTransitionUtilActivity.class));
        return data;
    }

    public static List<DataBean> getViewData() {
        List<DataBean> data = new ArrayList<>();
        data.add(new DataBean("测试Dialog", SDDialogViewActivity.class));
        data.add(new DataBean("测试加载动画", SDLoadingViewActivity.class));
        data.add(new DataBean("测试计步器", SDStepViewActivity.class));
        return data;
    }

    public static List<DataBean> getWidgetData() {
        List<DataBean> data = new ArrayList<>();
        data.add(new DataBean("测试简化shape组件", SDShapeWidgetActivity.class));
        data.add(new DataBean("测试ImageView组件", SDImageViewActivity.class));
        data.add(new DataBean("测试头像叠加列表组件", SDAvatarListLayoutActivity.class));
        data.add(new DataBean("测试EditText组件", SDEditTextWidgetActivity.class));
        data.add(new DataBean("测试评分组件", SDRankingActivity.class));
        data.add(new DataBean("测试特殊组件", SDSpecialWidgetActivity.class));
        data.add(new DataBean("测试TextView相关组件", SDTextViewActivity.class));
        data.add(new DataBean("测试SDFlowTabLayout组件", SDFlowTagLayoutActivity.class));
        data.add(new DataBean("测试SDTitleLayout相关组件", SDTitleLayoutWidgetActivity.class));
        data.add(new DataBean("测试验证码输入框组件", VerificationCodeViewActivity.class));
        data.add(new DataBean("测试SDRecyclerViewAdapter", SDRecyclerViewAdapterActivity.class));
        data.add(new DataBean("测试越界回弹Behavior", SDOverScrollBehaviorActivity.class));
        return data;
    }
}
