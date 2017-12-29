package com.siberiadante.utilsample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.siberiadante.androidutil.util.SDJumpUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.SecondActivity;
import com.siberiadante.utilsample.activity.base.BaseActivity;
import com.siberiadante.utilsample.constant.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JumpUtilActivity extends BaseActivity {

    @BindView(R.id.btn_open_setting)
    Button btnOpenSetting;
    @BindView(R.id.btn_open_setting_details)
    Button btnOpenSettingDetails;
    @BindView(R.id.btn_open_browser)
    Button btnOpenBrowser;
    @BindView(R.id.btn_open_email)
    Button btnOpenEmail;
    @BindView(R.id.btn_send_email)
    Button btnSendEmail;
    @BindView(R.id.btn_start_activity1)
    Button btnStartActivity1;
    @BindView(R.id.btn_start_activity2)
    Button btnStartActivity2;
    @BindView(R.id.btn_start_activity3)
    Button btnStartActivity3;
    @BindView(R.id.btn_start_activity4)
    Button btnStartActivity4;
    @BindView(R.id.btn_open_wifi_setting)
    Button btnOpenWifiSetting;
    @BindView(R.id.btn_open_location_setting)
    Button btnOpenLocationSetting;

    @Override
    public int setLayoutId() {
        return R.layout.activity_jump_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle("SDJumpUtil");
    }

    @OnClick({
            R.id.btn_start_activity1, R.id.btn_start_activity2, R.id.btn_start_activity3, R.id.btn_start_activity4,
            R.id.btn_open_setting, R.id.btn_open_setting_details,
            R.id.btn_open_wifi_setting,
            R.id.btn_open_browser,
            R.id.btn_open_email, R.id.btn_send_email,
            R.id.btn_open_location_setting,
            R.id.btn_open_language_setting
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_start_activity1:
                SDJumpUtil.startActivity(SecondActivity.class);
                break;
            case R.id.btn_start_activity2:
                Bundle bundle = new Bundle();
                bundle.putString("message", "通过Bundle传值启动的Activity");
                SDJumpUtil.startActivity(SecondActivity.class, bundle);
                break;
            case R.id.btn_start_activity3:
                // TODO: 2017/12/27
//                SDJumpUtil.startActivity(SecondActivity.class);
                break;
            case R.id.btn_start_activity4:
                SDJumpUtil.startActivity(this, SecondActivity.class.getName(),
                        R.anim.view_in, R.anim.view_out);
                break;

            case R.id.btn_open_setting:
                SDJumpUtil.openSetting();
                break;
            case R.id.btn_open_setting_details:
                SDJumpUtil.openAppSetting();
                break;
            case R.id.btn_open_wifi_setting:
                SDJumpUtil.openWifiSetting();
                break;

            case R.id.btn_open_browser:
                SDJumpUtil.openBrowser(Constants.B_LOG);
                break;
            case R.id.btn_open_email:
                SDJumpUtil.openEmail(Constants.QQ_EMAIL);
                break;
            case R.id.btn_send_email:
                SDJumpUtil.sendEmail(Constants.QQ_EMAIL, "这里是一个邮件标题", "这里是邮件内容");
                break;
            case R.id.btn_open_location_setting:
                SDJumpUtil.openLocationSetting();
                break;
            case R.id.btn_open_language_setting:
                SDJumpUtil.openLanguageSetting();
                break;
        }
    }


}
