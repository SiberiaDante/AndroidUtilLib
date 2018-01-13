package com.siberiadante.utilsample.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDNetWorkUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SDNetWorkUtilActivity extends BaseActivity {


    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.change_mobile_data_state)
    Button changeMobileDataState;
    @BindView(R.id.change_wifi_state)
    Button changeWifiState;
    @BindView(R.id.open_network_setting)
    Button openNetworkSetting;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdnet_work_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        final StringBuilder builder = new StringBuilder();
        builder.append("判断网络是否连接:").append(SDNetWorkUtil.isNetWorkConnected()).append("\n")
                .append("判断是否是无线连接:").append(SDNetWorkUtil.isWifiConnected()).append("\n")
                .append("判断wifi数据是否可用:").append(SDNetWorkUtil.isWifiAvailable()).append("\n")
                .append("判断是否4G连接:").append(SDNetWorkUtil.is4GConnected()).append("\n")
                .append("判断移动数据是否打开:").append(SDNetWorkUtil.getDataEnabled()).append("\n")
                .append("判断网络类型:").append(SDNetWorkUtil.getNetWorkType()).append("\n")
                .append("获取网络运营商名称:").append(SDNetWorkUtil.getNetworkOperatorName()).append("\n")
                .append("判断网络是否可用:").append(SDNetWorkUtil.isAvailableByPing()).append("\n")
                .append("获取IP地址:").append(SDNetWorkUtil.getIPAddress(true)).append("\n");

        tvResult.setText(builder);

    }


    @OnClick({R.id.change_mobile_data_state, R.id.change_wifi_state, R.id.open_network_setting, R.id.open_wifi_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.change_mobile_data_state:
                if (SDNetWorkUtil.is4GConnected()) {
                    SDNetWorkUtil.setDataEnabled(false);
                } else {
                    SDNetWorkUtil.setDataEnabled(true);
                }
                break;
            case R.id.change_wifi_state:
                if (SDNetWorkUtil.isWifiConnected()) {
                    SDNetWorkUtil.setWifiEnabled(false);
                } else {
                    SDNetWorkUtil.setWifiEnabled(true);
                }
                break;
            case R.id.open_network_setting:
                SDNetWorkUtil.openNetworkSettings();
                break;
            case R.id.open_wifi_setting:
                SDNetWorkUtil.openWifiSettings();
                break;
        }
    }
}
