package com.siberiadante.utilsample.activity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.siberiadante.androidutil.SDRegexUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SDRegexUtilActivity extends BaseActivity {


    @BindView(R.id.edt_input)
    EditText edtInput;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_test_mobile_simple)
    Button btnTestMobileSimple;
    @BindView(R.id.btn_test_mobile_exact)
    Button btnTestMobileExact;
    @BindView(R.id.btn_test_phone)
    Button btnTestPhone;
    @BindView(R.id.btn_test_id_card_15)
    Button btnTestIdCard15;
    @BindView(R.id.btn_test_id_card_18)
    Button btnTestIdCard18;
    @BindView(R.id.btn_test_id_card_all)
    Button btnTestIdCardAll;
    @BindView(R.id.btn_test_emil)
    Button btnTestEmil;
    @BindView(R.id.btn_test_url)
    Button btnTestUrl;
    @BindView(R.id.btn_test_zh)
    Button btnTestZh;
    @BindView(R.id.btn_test_username)
    Button btnTestUsername;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdregex_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle("SDRegexUtil");

    }

    @OnClick({R.id.btn_test_mobile_simple, R.id.btn_test_mobile_exact, R.id.btn_test_phone, R.id.btn_test_id_card_15, R.id.btn_test_id_card_18, R.id.btn_test_id_card_all, R.id.btn_test_emil, R.id.btn_test_url, R.id.btn_test_zh, R.id.btn_test_username})
    public void onViewClicked(View view) {
        final Editable content = edtInput.getText();
        boolean isTrue = false;
        switch (view.getId()) {
            case R.id.btn_test_mobile_simple:
                isTrue = SDRegexUtil.isMobileSimple(content);
                break;
            case R.id.btn_test_mobile_exact:
                isTrue = SDRegexUtil.isMobileExact(content);
                break;
            case R.id.btn_test_phone:
                isTrue = SDRegexUtil.isTelephone(content);
                break;
            case R.id.btn_test_id_card_15:
                isTrue = SDRegexUtil.isIDCard15(content);
                break;
            case R.id.btn_test_id_card_18:
                isTrue = SDRegexUtil.isIDCard18(content);
                break;
            case R.id.btn_test_id_card_all:
                isTrue = SDRegexUtil.isIDCard(content);
                break;
            case R.id.btn_test_emil:
                isTrue = SDRegexUtil.isEmail(content);
                break;
            case R.id.btn_test_url:
                isTrue = SDRegexUtil.isURL(content);
                break;
            case R.id.btn_test_zh:
                isTrue = SDRegexUtil.isZh(content);
                break;
            case R.id.btn_test_username:
                isTrue = SDRegexUtil.isUsername(content);
                break;
        }
        tvResult.setText("测试结果：" + isTrue);
    }
}
