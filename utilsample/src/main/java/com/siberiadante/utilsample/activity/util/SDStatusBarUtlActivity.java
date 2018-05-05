package com.siberiadante.utilsample.activity.util;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDStatusBarUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created:： SiberiaDante
 * @Date： 2018/01/01
 * Describe：
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */
@Deprecated
public class SDStatusBarUtlActivity extends BaseActivity {

    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_half_status_translucent)
    Button btnHalfStatusTranslucent;
    @BindView(R.id.btn_status_translucent)
    Button btnStatusTranslucent;
    @BindView(R.id.btn_nav_translucent)
    Button btnNavTranslucent;
    @BindView(R.id.btn_status_nav_translucent)
    Button btnStatusNavTranslucent;

    @Override
    public void beforeSetContentView() {
        super.beforeSetContentView();
//        SDStatusBarUtil.hideStatusBar(this);
//        SDStatusBarUtil.setFullScreen(this);
//        SDStatusBarUtil.setNoTitle(this);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdstatus_bar_utl;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        final StringBuilder builder = new StringBuilder();
        builder.append("状态栏高度：").append(SDStatusBarUtil.getStatusBarHeight())
                .append("状态栏是否存在：").append(SDStatusBarUtil.isStatusBarExists(this));
        tvResult.setText(builder);
    }


    @OnClick({R.id.btn_half_status_translucent, R.id.btn_status_translucent, R.id.btn_nav_translucent, R.id.btn_status_nav_translucent})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_half_status_translucent:
                SDStatusBarUtil.setHalfTransparent(this);
                break;
            case R.id.btn_status_translucent:
                SDStatusBarUtil.setStatusTranslucent(this);

                break;
            case R.id.btn_nav_translucent:
                SDStatusBarUtil.setNavigationTranslucent(this);

                break;
            case R.id.btn_status_nav_translucent:
//                SDStatusBarUtil.setStatusBarLightMode(this);
                SDStatusBarUtil.setTranslucent(this);
//                SDStatusBarUtil.addMarginTopEqualStatusBarHeight(tvResult);
                break;
        }
    }
}
