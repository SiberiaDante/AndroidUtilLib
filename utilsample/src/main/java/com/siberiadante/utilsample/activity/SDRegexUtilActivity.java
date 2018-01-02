package com.siberiadante.utilsample.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDRegexUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
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
    @BindView(R.id.btn_test_date)
    Button btnTestDate;
    @BindView(R.id.btn_test_ip)
    Button btnTestIp;
    @BindView(R.id.btn_test_blank_line)
    Button btnTestBlankLine;
    @BindView(R.id.btn_test_blank_str)
    Button btnTestBlankStr;
    @BindView(R.id.btn_test_qq)
    Button btnTestQq;
    @BindView(R.id.btn_test_post_code)
    Button btnTestPostCode;
    @BindView(R.id.btn_test_is_num)
    Button btnTestIsNum;
    @BindView(R.id.btn_test_is_pos_num)
    Button btnTestIsPosNum;
    @BindView(R.id.btn_test_is_neg_num)
    Button btnTestIsNegNum;
    @BindView(R.id.btn_test_integer)
    Button btnTestInteger;
    @BindView(R.id.btn_test_decimal)
    Button btnTestDecimal;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.btn_test_qq_emil)
    Button btnTestQqEmil;
    @BindView(R.id.btn_test_google_emil)
    Button btnTestGoogleEmil;
    @BindView(R.id.btn_test_163_emil)
    Button btnTest163Emil;
    @BindView(R.id.btn_test_sina_emil)
    Button btnTestSinaEmil;
    @BindView(R.id.btn_test_sohu_emil)
    Button btnTestSohuEmil;
    @BindView(R.id.btn_test_hot_mai_emil)
    Button btnTestHotMaiEmil;
    @BindView(R.id.btn_test_189_emil)
    Button btnTest189Emil;
    @BindView(R.id.btn_test_139_emil)
    Button btnTest139Emil;
    @BindView(R.id.btn_clean)
    Button btnClean;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdregex_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle("SDRegexUtil");

    }

    @OnClick({R.id.btn_clean,R.id.btn_test_mobile_simple, R.id.btn_test_mobile_exact, R.id.btn_test_phone,
            R.id.btn_test_id_card_15, R.id.btn_test_id_card_18, R.id.btn_test_id_card_all,
            R.id.btn_test_emil, R.id.btn_test_qq_emil, R.id.btn_test_google_emil, R.id.btn_test_163_emil, R.id.btn_test_sina_emil, R.id.btn_test_sohu_emil, R.id.btn_test_hot_mai_emil, R.id.btn_test_189_emil, R.id.btn_test_139_emil,
            R.id.btn_test_url, R.id.btn_test_zh, R.id.btn_test_username,
            R.id.btn_test_ip, R.id.btn_test_blank_line, R.id.btn_test_blank_str, R.id.btn_test_qq,
            R.id.btn_test_post_code, R.id.btn_test_is_num, R.id.btn_test_is_pos_num, R.id.btn_test_is_neg_num, R.id.btn_test_integer, R.id.btn_test_decimal
    })
    public void onViewClicked(View view) {
        String content = edtInput.getText().toString();
        boolean isTrue = false;
        switch (view.getId()) {
            case R.id.btn_clean:
                edtInput.setText("");
                tvResult.setText("");
                break;
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
            case R.id.btn_test_qq_emil:
                isTrue = SDRegexUtil.isQQEmail(content);
                break;
            case R.id.btn_test_google_emil:
                isTrue = SDRegexUtil.isGoogleEmail(content);
                break;
            case R.id.btn_test_163_emil:
                isTrue = SDRegexUtil.is163Email(content);
                break;
            case R.id.btn_test_sina_emil:
                isTrue = SDRegexUtil.isSiNaEmail(content);
                break;
            case R.id.btn_test_sohu_emil:
                isTrue = SDRegexUtil.isSoHuEmail(content);
                break;
            case R.id.btn_test_hot_mai_emil:
                isTrue = SDRegexUtil.isHotMaiEmail(content);
                break;
            case R.id.btn_test_189_emil:
                isTrue = SDRegexUtil.is189Email(content);
                break;
            case R.id.btn_test_139_emil:
                isTrue = SDRegexUtil.is139Email(content);
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
            case R.id.btn_test_ip:
                isTrue = SDRegexUtil.isIP(content);
                break;
            case R.id.btn_test_blank_line:
                isTrue = SDRegexUtil.isSpaceLine(content);
                break;
            case R.id.btn_test_blank_str:
                isTrue = SDRegexUtil.isSpaceStr(content);
                break;
            case R.id.btn_test_qq:
                isTrue = SDRegexUtil.isQQNum(content);
                break;
            case R.id.btn_test_post_code:
                isTrue = SDRegexUtil.isPostCode(content);
                break;
            case R.id.btn_test_is_num:
                isTrue = SDRegexUtil.isNum(content);
                break;
            case R.id.btn_test_is_pos_num:
                isTrue = SDRegexUtil.isPositionInteger(content);
                break;
            case R.id.btn_test_is_neg_num:
                isTrue = SDRegexUtil.isNegativeInteger(content);
                break;
            case R.id.btn_test_integer:
                isTrue = SDRegexUtil.isInteger(content);
                break;
            case R.id.btn_test_decimal:
                isTrue = SDRegexUtil.isDecimals(content);
                break;
        }
        tvResult.setText("测试结果：" + isTrue);
    }
}
