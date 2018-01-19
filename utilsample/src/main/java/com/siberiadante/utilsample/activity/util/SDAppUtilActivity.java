package com.siberiadante.utilsample.activity.util;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDAppUtil;
import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.androidutil.bean.SDInstallAppInfoBean;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Created： SiberiaDante
 * @Date： 2018/01/01
 * @Describe：
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */
public class SDAppUtilActivity extends BaseActivity {

    public static final String TAG = SDAppUtilActivity.class.getSimpleName();

    @BindView(R.id.iv_app)
    ImageView ivApp;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.btn_launch_app)
    Button btnLaunchApp;
    @BindView(R.id.btn_install_app)
    Button btnInstallApp;
    @BindView(R.id.btn_uninstall_app)
    Button btnUninstallApp;
    @BindView(R.id.btn_get_install_app_info)
    Button btnGetInstallAPPInfo;
    @BindView(R.id.btn_get_install_app_info2)
    Button btnGetInstallAPPInfo2;
    @BindView(R.id.tv_info_content)
    TextView tvInfo;
    @BindView(R.id.tv_info_content2)
    TextView tvInfo2;
    public static final int SHOW_ALL_INSTALL_APP_INFO = 0x01;
    public static final int SHOW_ALL_INSTALL_APP_INFO_EX_SYS = 0x02;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case SHOW_ALL_INSTALL_APP_INFO:

                    break;
                case SHOW_ALL_INSTALL_APP_INFO_EX_SYS:

                    break;
            }
            return false;
        }
    });

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdapp_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle(R.string.sd_app_util);
        ivApp.setImageDrawable(SDAppUtil.getAppIcon());
        final StringBuilder builder = new StringBuilder();
        builder.append("获取APP的name：" + SDAppUtil.getAppName() + "\n");
        builder.append("获取APP的包名：" + SDAppUtil.getPackageName() + "\n");
        builder.append("获取APP的版本名：" + SDAppUtil.getAppVersionName() + "\n");
        builder.append("获取APP的版本号：" + SDAppUtil.getAppVersionCode() + "\n");
        builder.append("检测某一APP是否已经安装(检测其他应用时需要传入对应的包名）：" + SDAppUtil.isInstalledApp("com.siberiadante.utilsample") + "\n");
        builder.append("获取APP的路径：" + SDAppUtil.getAppPath() + "\n");
        builder.append("获取APP是否是系统应用：" + SDAppUtil.isSystemApp() + "\n");
        builder.append("获取APP是否是Debug应用：" + SDAppUtil.isAppDebug() + "\n");
        builder.append("获取APP是否有Root权限：" + SDAppUtil.isAppRoot() + "\n");
        builder.append("获取APP签名：" + Arrays.toString(SDAppUtil.getAppSignature()) + "\n");
        builder.append("获取APP签名的的SHA1值：" + SDAppUtil.getAppSignatureSHA1() + "\n");
        builder.append("获取APP是否具有通知权限：" + SDAppUtil.isNotificationEnable() + "\n");
        builder.append("获取APP是否处于前台：" + SDAppUtil.isAppInForeground() + "\n");
        tvContent.setText(builder);
    }


    @OnClick({R.id.btn_launch_app, R.id.btn_install_app, R.id.btn_uninstall_app, R.id.btn_get_install_app_info, R.id.btn_get_install_app_info2})
    public void onViewClicked(View view) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Sample-debug.apk";
        switch (view.getId()) {
            case R.id.btn_launch_app:
                SDAppUtil.launchApp();
                break;
            case R.id.btn_install_app:
                SDLogUtil.d(TAG, "-------------:" + path);
                SDAppUtil.installApp(SDAppUtilActivity.this, path, "com.siberiadante.utilsample.fileProvider");
                break;
            case R.id.btn_uninstall_app:
                SDAppUtil.unInstallApp("com.siberiadante.viewsample");
                break;
            case R.id.btn_get_install_app_info:
                List<SDInstallAppInfoBean> sdInstallAppInfoBeans = SDAppUtil.getInstallAppInfo(this, true);
                StringBuilder builder = new StringBuilder();
                for (SDInstallAppInfoBean installAppInfoBean : sdInstallAppInfoBeans) {
                    builder.append("应用名：").append(installAppInfoBean.getAppName()).append(" 包名：").append(installAppInfoBean.getAppPackageName()).append("\n");
                }
                tvInfo.setText(builder);
                break;
            case R.id.btn_get_install_app_info2:

                List<SDInstallAppInfoBean> sdInstallAppInfoBeans2 = SDAppUtil.getInstallAppInfo(SDAppUtilActivity.this, false);
                SDLogUtil.d(TAG, "--------:" + sdInstallAppInfoBeans2.get(0).getAppName());
                SDLogUtil.d(TAG, "--------:" + sdInstallAppInfoBeans2.get(0).getAppPackageName());
                SDLogUtil.d(TAG, "--------:" + sdInstallAppInfoBeans2.get(0).getInstallLocation());
                SDLogUtil.d(TAG, "--------:" + sdInstallAppInfoBeans2.get(0).getMinSdkVersion());
                SDLogUtil.d(TAG, "--------:" + sdInstallAppInfoBeans2.get(0).getTargetSdkVersion());
                SDLogUtil.d(TAG, "--------:" + sdInstallAppInfoBeans2.get(0).getVersionCode());
                SDLogUtil.d(TAG, "--------:" + sdInstallAppInfoBeans2.get(0).getUid());
                final StringBuilder builder2 = new StringBuilder();
                for (SDInstallAppInfoBean installAppInfoBean : sdInstallAppInfoBeans2) {
                    builder2.append("应用名：").append(installAppInfoBean.getAppName()).append(" 包名：").append(installAppInfoBean.getAppPackageName()).append("\n");
                }
                tvInfo2.setText(builder2);

                break;
        }
    }

}
