package com.siberiadante.utilsample.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDScreenUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Created： SiberiaDante
 * @Date： 2018/01/01
 * @Describe：
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */
public class SDScreenUtilActivity extends BaseActivity {

    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.iv_show)
    ImageView ivShow;
    @BindView(R.id.btn_get_data)
    Button btnGetData;
    @BindView(R.id.btn_set_land)
    Button btnSetLand;
    @BindView(R.id.btn_set_portrait)
    Button btnSetPortrait;
    @BindView(R.id.btn_get_screen_pic)
    Button btnGetScreenPic;
    @BindView(R.id.btn_get_screen_pic_1)
    Button btnGetScreenPic1;
    @BindView(R.id.btn_forbid_screen_pic)
    Button btnForbidScreenPic;
    @BindView(R.id.btn_show_notify_title)
    Button btnShowNotifyTitle;
    @BindView(R.id.btn_hide_notify_title)
    Button btnHideNotifyTitle;
    @BindView(R.id.btn_keep_screen_wake_up)
    Button btnKeepScreenWakeUp;
    @BindView(R.id.btn_set_dormant_time)
    Button btnSetDormantTime;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdscreen_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle(R.string.sd_screen_util);
    }

    @Override
    public void initData() {
        super.initData();
        final StringBuilder builder = new StringBuilder();
        builder.append("屏幕dpi-getDensity:").append(SDScreenUtil.getDensity(this)).append("\n")
        .append("getScreenWidthPx:").append(SDScreenUtil.getScreenWidthPx()).append("\n")
                .append("getScreenHeightPx:").append(SDScreenUtil.getScreenHeightPx()).append("\n")
                .append("getScreenWidthDp:").append(SDScreenUtil.getScreenWidthDp()).append("\n")
                .append("getScreenHeightDp:").append(SDScreenUtil.getScreenHeightDp()).append("\n")
                .append("getScreenWidth:").append(SDScreenUtil.getScreenWidth()).append("\n")
                .append("getScreenHeight:").append(SDScreenUtil.getScreenHeight()).append("\n")
                .append("判断是否横屏isLandscape:").append(SDScreenUtil.isLandscape()).append("\n")
                .append("判断是否横屏isPortrait:").append(SDScreenUtil.isPortrait()).append("\n")
                .append("获取屏幕旋转角度getScreenRotation:").append(SDScreenUtil.getScreenRotation(this)).append("\n")
                .append("获取ActionBar高度getActionBarHeight:").append(SDScreenUtil.getActionBarHeight(this)).append("\n")
                .append("判断是否锁屏isScreenLock:").append(SDScreenUtil.isScreenLock()).append("\n")
                .append("获取进入休眠时长getSleepDuration:").append(SDScreenUtil.getSleepDuration()).append("\n");
        tvResult.setText(builder);
    }

    @OnClick({R.id.btn_get_data, R.id.btn_set_land, R.id.btn_set_portrait, R.id.btn_get_screen_pic, R.id.btn_get_screen_pic_1, R.id.btn_forbid_screen_pic, R.id.btn_show_notify_title, R.id.btn_hide_notify_title, R.id.btn_keep_screen_wake_up, R.id.btn_set_dormant_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_data:
                initData();
                break;
            case R.id.btn_set_land:
                SDScreenUtil.setLandscape(this);
                break;
            case R.id.btn_set_portrait:
                SDScreenUtil.setPortrait(this);
                break;
            case R.id.btn_get_screen_pic:
                ivShow.setImageBitmap(SDScreenUtil.captureWithStatusBar(this));
                break;
            case R.id.btn_get_screen_pic_1:
                ivShow.setImageBitmap(SDScreenUtil.captureWithoutStatusBar(this));
                break;
            case R.id.btn_forbid_screen_pic:
                SDScreenUtil.noScreenshots(this);
                break;
            case R.id.btn_show_notify_title:
                SDScreenUtil.showNotificationBar(this,false);
                break;
            case R.id.btn_hide_notify_title:
                SDScreenUtil.hideNotificationBar(this);
                break;
            case R.id.btn_keep_screen_wake_up:
                SDScreenUtil.keepScreenOn(this);
                break;
            case R.id.btn_set_dormant_time:
                SDScreenUtil.setSleepDuration(1000*3);
                break;
        }
    }
}
