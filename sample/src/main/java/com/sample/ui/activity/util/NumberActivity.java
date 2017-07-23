package com.sample.ui.activity.util;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.util.NumberUtil;
import com.siberiadante.view.TitleBar;

import butterknife.ButterKnife;

public class NumberActivity extends BaseActivity implements View.OnClickListener {

    private EditText edtInput;
    private Button mBtnOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        TitleBar mTitleBar = (TitleBar) findViewById(R.id.title_bar_number);
        mTitleBar.setBackgroundResource(R.color.red);
        mTitleBar.setTitle("NumberUtil测试");
        mTitleBar.setImmersive(true);
        edtInput = (EditText) findViewById(R.id.edt_input);
        mBtnOne = ((Button) findViewById(R.id.btn_number_test_one));

        mBtnOne.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_number_test_one:
                testIsNumber();
                break;
        }
    }

    private void testIsNumber() {
        if (NumberUtil.isNumeric(edtInput.getText().toString())) {
            mBtnOne.setText("true");
        } else {
            mBtnOne.setText("false");
        }
    }
}
