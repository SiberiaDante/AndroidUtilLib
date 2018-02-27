package com.siberiadante.utilsample.activity.util;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDDeviceUtil;
import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;


import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * Created:： SiberiaDante
 * @Date： 2018/01/01
 * Describe：
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */
public class SDDeviceUtilActivity extends BaseActivity {

    private static final int ADD_CONTENT = 0x01;
    @BindView(R.id.tv_result)
    TextView tvResult;

    private StringBuilder builder;
    @SuppressLint("HandlerLeak")
    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case ADD_CONTENT:
                    tvResult.setText(builder);
                    break;
            }
        }
    };
    private Thread thread;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sddevice_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        builder = new StringBuilder();
        builder.append("SDDeviceUtil获取结果：\n")
                .append("获取安卓手机系统版本号:").append(SDDeviceUtil.getAndroidSystemVersion()).append("\n")
                .append("获取手机型号:").append(SDDeviceUtil.getMobilePhoneTypeInfo()).append("\n")
                .append("Android Id设备Id:").append(SDDeviceUtil.getDeviceId()).append("\n")
                .append("Android Id设备Id:").append(SDDeviceUtil.getAndroidId()).append("\n")
                .append("获取IMEI码:").append(SDDeviceUtil.getIMIEStatus()).append("\n")
                .append("获取设备的IMEI:").append(SDDeviceUtil.getDeviceIdIMEI()).append("\n")
                .append("获取Mac地址:").append(SDDeviceUtil.getLocalMac()).append("\n")
                .append("获取IMSI码:").append(SDDeviceUtil.getIMSI()).append("\n")
                .append("获取手机唯一标识序列号:").append(SDDeviceUtil.getUniqueSerialNumber()).append("\n")
                .append("获取设备厂商:").append(SDDeviceUtil.getBuildMANUFACTURER()).append("\n")
                .append("序列号:").append(SDDeviceUtil.getSerialNumber()).append("\n")
                .append("判断设备是否是手机:").append(SDDeviceUtil.isPhone()).append("\n")
                .append("获取手机号:").append(SDDeviceUtil.getLine1Number(this)).append("\n")
                .append("获取ISO标准的国家码，即国际长途区号:").append(SDDeviceUtil.getNetworkCountryIso(this)).append("\n")
                .append("获取设备的 MCC + MNC:").append(SDDeviceUtil.getNetworkOperator(this)).append("\n")
                .append("获取(当前已注册的用户)的名字:").append(SDDeviceUtil.getNetworkOperatorName(this)).append("\n")
                .append("获取当前使用的网络类型:").append(SDDeviceUtil.getNetworkType(this)).append("\n")
                .append("获取终端类型:").append(SDDeviceUtil.getPhoneType()).append("\n")
                .append("获取SIM卡的国家码:").append(SDDeviceUtil.getSimCountryIso(this)).append("\n")
                .append("获取SIM的状态信息:").append(SDDeviceUtil.getSimState(this)).append("\n")
                .append("获取唯一的用户ID:").append(SDDeviceUtil.getSubscriberId(this)).append("\n")
                .append("判断sim卡是否准备好:").append(SDDeviceUtil.isSimCardReady()).append("\n")
                .append("获取Sim卡运营商名称:").append(SDDeviceUtil.getSimOperatorName()).append("\n")
                .append("获取Sim卡运营商名称:").append(SDDeviceUtil.getSimOperatorByMnc()).append("\n")
                .append("获取SIM卡提供的移动国家码和移动网络码.5或6位的十进制数字:").append(SDDeviceUtil.getSimOperator(this));
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final List<HashMap<String, String>> allContactInfo = SDDeviceUtil.getAllContactInfo();
                for (int i = 0; i < allContactInfo.size(); i++) {
                    SDLogUtil.d("---:" + allContactInfo.get(i).get("name"));
                    builder.append("\n")
                            .append("姓名：").append(allContactInfo.get(i).get("name")).append("电话：").append(allContactInfo.get(i).get("phone")).append("\n");
                }
                mhandler.sendEmptyMessage(ADD_CONTENT);
            }
        });
        thread.start();

        tvResult.setText(builder);
    }

}
