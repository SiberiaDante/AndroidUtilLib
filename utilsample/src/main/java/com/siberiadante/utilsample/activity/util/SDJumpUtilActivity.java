package com.siberiadante.utilsample.activity.util;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.siberiadante.androidutil.SDToastUtil;
import com.siberiadante.androidutil.util.SDJumpUtil;
import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.SecondActivity;
import com.siberiadante.utilsample.activity.base.BaseActivity;
import com.siberiadante.utilsample.constant.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Created： SiberiaDante
 * @Date： 2018/01/01
 * @Describe：
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */
public class SDJumpUtilActivity extends BaseActivity {

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
    @BindView(R.id.btn_open_language_setting)
    Button btnOpenLanguageSetting;
    @BindView(R.id.btn_open_call)
    Button btnOpenCall;
    @BindView(R.id.btn_open_send_sms)
    Button btnOpenSendSms;
    @BindView(R.id.btn_open_send_sms_client)
    Button btnOpenSendSmsClient;

    @Override
    public int setLayoutId() {
        return R.layout.activity_jump_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle(R.string.sd_jump_util);
    }

    @OnClick({
            R.id.btn_start_activity1, R.id.btn_start_activity2, R.id.btn_start_activity3, R.id.btn_start_activity4,
            R.id.btn_open_setting, R.id.btn_open_setting_details,
            R.id.btn_open_wifi_setting, R.id.btn_open_network_setting,
            R.id.btn_open_browser,
            R.id.btn_open_email, R.id.btn_send_email,
            R.id.btn_open_location_setting,
            R.id.btn_open_language_setting,
            R.id.btn_open_call, R.id.btn_open_send_sms, R.id.btn_open_send_sms_client
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
            case R.id.btn_open_network_setting:
                SDJumpUtil.openNetWorkSetting();
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
            case R.id.btn_open_call:
                SDJumpUtil.openCall("10086");
                break;
            case R.id.btn_open_send_sms:
                SDJumpUtil.openSendSms("10086", "余额");
                break;
            case R.id.btn_open_send_sms_client:
                SDJumpUtil.openSendSmsSilent("10086", "余额");
                break;
        }
    }
}
