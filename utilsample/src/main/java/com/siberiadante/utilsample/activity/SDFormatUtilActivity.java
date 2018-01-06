package com.siberiadante.utilsample.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDFormatUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SDFormatUtilActivity extends BaseActivity {


    @BindView(R.id.edt_input)
    EditText edtInput;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_format_mobile)
    Button btnFormatMobile;
    @BindView(R.id.btn_format_card)
    Button btnFormatCard;
    @BindView(R.id.btn_format_card_1)
    Button btnFormatCard1;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdformat_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @OnClick({R.id.btn_format_mobile, R.id.btn_format_card, R.id.btn_format_card_1})
    public void onViewClicked(View view) {
        final String inputContent = edtInput.getText().toString();
        String result = "";
        switch (view.getId()) {
            case R.id.btn_format_mobile:
                result = SDFormatUtil.hideMobilePhone4(inputContent);
                break;
            case R.id.btn_format_card:
                result = SDFormatUtil.formatCard(inputContent);
                break;
            case R.id.btn_format_card_1:
                result = SDFormatUtil.formatCardEnd4(inputContent);
                break;
        }
        tvResult.setText("格式化结果："+result);

    }
}
