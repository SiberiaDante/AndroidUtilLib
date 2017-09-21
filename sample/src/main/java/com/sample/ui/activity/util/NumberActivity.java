package com.sample.ui.activity.util;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.SDNumberUtil;
import com.siberiadante.lib.view.titlebar.SDTitleBar;

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
        SDTitleBar mSDTitleBar = (SDTitleBar) findViewById(R.id.title_bar_number);
        mSDTitleBar.setBackgroundResource(R.color.red);
        mSDTitleBar.setTitle("NumberUtil测试");
        mSDTitleBar.setImmersive(true);
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
        if (SDNumberUtil.isNumeric(edtInput.getText().toString())) {
            mBtnOne.setText("true");
        } else {
            mBtnOne.setText("false");
        }
    }
}
