package com.sample.constants;

import android.os.Environment;

import com.sample.R;
import com.sample.SampleApplication;
import com.sample.bean.Data;
import com.sample.ui.activity.WebVideoActivity;
import com.sample.ui.activity.animation.SDSpreadLikeViewActivity;
import com.sample.ui.activity.util.ActivityUtilActivity;
import com.sample.ui.activity.util.AppActivity;
import com.sample.ui.activity.util.BitmapUtilActivity;
import com.sample.ui.activity.util.ClearActivity;
import com.sample.ui.activity.util.DateUtilActivity;
import com.sample.ui.activity.util.EncryptionActivity;
import com.sample.ui.activity.util.LogUtilActivity;
import com.sample.ui.activity.util.NetworkActivity;
import com.sample.ui.activity.util.NumberActivity;
import com.sample.ui.activity.util.PermissionManagerActivity;
import com.sample.ui.activity.util.SDCardUtilActivity;
import com.sample.ui.activity.util.SDJumpActivity;
import com.sample.ui.activity.util.ScreenActivity;
import com.sample.ui.activity.util.ToastActivity;
import com.sample.ui.activity.view.DialogActivity;
import com.sample.ui.activity.view.ImageSpanActivity;
import com.sample.ui.activity.view.KeyBoardActivity;
import com.sample.ui.activity.view.QQStepViewActivity;
import com.sample.ui.activity.view.RantingBarActivity;
import com.sample.ui.activity.view.ShapeViewActivity;
import com.sample.ui.activity.view.TitleLayoutActivity;
import com.sample.ui.activity.view.customview.SDLetterIndexActivity;
import com.sample.ui.activity.view.customview.SDLoadViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SiberiaDante on 2017/5/4.
 */

public class Constants {
    public static final String ALBUM_PATH = Environment.getExternalStorageDirectory() + "/sample/";
    public static final String URL_SIBERIA_DANTE_LIB = "https://github.com/SiberiaDante/SDAndroidLib";
    public static final String URL_TITLE_LAYOUT = "https://github.com/SiberiaDante/TitleLayout";
    public static final String URL_CUSTOM_DIALOG = "https://github.com/SiberiaDante/SDCustomDialog";

    public static final String APP_INFO = "app_info_sp";
    public static final String GIT_HUB = "https://github.com/SiberiaDante";
    public static final String B_LOG = "http://www.cnblogs.com/shen-hua/";

    public static List<Data> getViewData() {
        List<Data> datas = new ArrayList<>();
        datas.add(new Data("各种Dialog", DialogActivity.class));
        datas.add(new Data("测试文字表情混排对齐", ImageSpanActivity.class));
        datas.add(new Data("Shape封装的View测试", ShapeViewActivity.class));
        datas.add(new Data("测试点击View切换软件盘测试", KeyBoardActivity.class));
        datas.add(new Data("测试QQ运动计步器View", QQStepViewActivity.class));
        datas.add(new Data("WebVideoActivity", WebVideoActivity.class));
        datas.add(new Data("测试TitleLayout标题栏", TitleLayoutActivity.class));
        datas.add(new Data(SampleApplication.getInstance().getString(R.string.LikeView), SDSpreadLikeViewActivity.class));
        datas.add(new Data("评分进度条测试", RantingBarActivity.class));
        datas.add(new Data("字母索引测试", SDLetterIndexActivity.class));
        datas.add(new Data("各种加载动画相关测试", SDLoadViewActivity.class));
        return datas;
    }

    public static List<Data> getUtilData() {
        List<Data> datas = new ArrayList<>();
        datas.add(new Data("测试ActivityUtil类", ActivityUtilActivity.class));
        datas.add(new Data(SampleApplication.getInstance().getString(R.string.SDEncryptUtil), EncryptionActivity.class));
        datas.add(new Data("测试AppUtil类", AppActivity.class));
        datas.add(new Data("测试BitmapUtil类", BitmapUtilActivity.class));
        datas.add(new Data("测试ClearUtil类", ClearActivity.class));
        datas.add(new Data("测试DataUtil类", DateUtilActivity.class));
        datas.add(new Data("测试LogUtil类", LogUtilActivity.class));
        datas.add(new Data("测试NetworkUtil类", NetworkActivity.class));
        datas.add(new Data("测试NumberUtil类", NumberActivity.class));
        datas.add(new Data("测试PermissionManagerUtil类", PermissionManagerActivity.class));
        datas.add(new Data("测试ScreenUtil类", ScreenActivity.class));
        datas.add(new Data("测试SDCardUtil类", SDCardUtilActivity.class));
        datas.add(new Data("测试ToastUtil类", ToastActivity.class));
        datas.add(new Data(SampleApplication.getInstance().getString(R.string.JumpUtil), SDJumpActivity.class));
        return datas;
    }
}
