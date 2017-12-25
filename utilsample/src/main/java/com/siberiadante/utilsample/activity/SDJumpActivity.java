//package com.siberiadante.utilsample.util;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import com.sample.R;
//import com.sample.ui.activity.BaseActivity;
//import com.siberiadante.util.utils.SDJumpUtil;
//import com.siberiadante.util.view.titlebar.SDTitleLayout;
//
//import butterknife.BindView;
//import butterknife.OnClick;
//
//public class SDJumpActivity extends BaseActivity {
//
//    @BindView(R.id.btn_open_setting)
//    Button btnOpenSetting;
//    @BindView(R.id.btn_open_detials_setting)
//    Button btnOpenDetialsSetting;
//    @BindView(R.id.btn_open_email)
//    Button btnOpenEmail;
//    @BindView(R.id.title_layout)
//    SDTitleLayout titleLayout;
//
//    @Override
//    public int setLayoutId() {
//        return R.layout.activity_sdjump;
//    }
//
//    @Override
//    public void initView(Bundle savedInstanceState) {
//        titleLayout.setTitle(getString(R.string.JumpUtil));
//    }
//
//    @Override
//    public void initData() {
//
//    }
//
//
//    @OnClick({R.id.btn_open_setting, R.id.btn_open_detials_setting, R.id.btn_open_email})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.btn_open_setting:
//                SDJumpUtil.openSetting();
//                break;
//            case R.id.btn_open_detials_setting:
//                SDJumpUtil.openAppSetting();
//                break;
//            case R.id.btn_open_email:
//                SDJumpUtil.openEmail();
//                break;
//        }
//    }
//
//}
