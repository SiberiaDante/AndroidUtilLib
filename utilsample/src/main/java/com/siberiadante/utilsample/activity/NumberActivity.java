//package com.siberiadante.utilsample.util;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//
//import butterknife.ButterKnife;
//
//public class NumberActivity extends BaseActivity implements View.OnClickListener {
//
//    private EditText edtInput;
//    private Button mBtnOne, mBtnTwo, mBtnThree, mBtnFour, mBtnFive;
//
//    @Override
//    public void beforeSetContentView() {
//        super.beforeSetContentView();
//        ButterKnife.bind(this);
//    }
//
//    @Override
//    public int setLayoutId() {
//        return R.layout.activity_number;
//    }
//
//    @Override
//    public void initView(Bundle savedInstanceState) {
//        SDTitleBar mSDTitleBar = (SDTitleBar) findViewById(R.id.title_bar_number);
//        mSDTitleBar.setBackgroundResource(R.color.red);
//        mSDTitleBar.setTitle("NumberUtil测试");
//        mSDTitleBar.setImmersive(true);
//        edtInput = (EditText) findViewById(R.id.edt_input);
//        mBtnOne = ((Button) findViewById(R.id.btn_number_test_one));
//        mBtnTwo = ((Button) findViewById(R.id.btn_number_test_two));
//        mBtnThree = ((Button) findViewById(R.id.btn_number_test_three));
//        mBtnFour = ((Button) findViewById(R.id.btn_number_test_four));
//        mBtnFive = ((Button) findViewById(R.id.btn_number_test_five));
//
//        mBtnOne.setOnClickListener(this);
//        mBtnTwo.setOnClickListener(this);
//        mBtnThree.setOnClickListener(this);
//        mBtnFour.setOnClickListener(this);
//        mBtnFive.setOnClickListener(this);
//    }
//
//    @Override
//    public void initData() {
//
//    }
//    @Override
//    public void onClick(View view) {
//        String content = edtInput.getText().toString();
//        switch (view.getId()) {
//            case R.id.btn_number_test_one:
//                if (SDNumberUtil.isNumeric(content)) {
//                    mBtnOne.setText("true");
//                } else {
//                    mBtnOne.setText("false");
//                }
//                break;
//            case R.id.btn_number_test_two:
//                if (SDNumberUtil.isPositionInteger(content)) {
//                    mBtnTwo.setText("true");
//                } else {
//                    mBtnTwo.setText("false");
//                }
//                break;
//            case R.id.btn_number_test_three:
//                if (SDNumberUtil.isNegativeInteger(content)) {
//                    mBtnThree.setText("true");
//                } else {
//                    mBtnThree.setText("false");
//                }
//                break;
//            case R.id.btn_number_test_four:
//                if (SDNumberUtil.isInteger(content)) {
//                    mBtnFour.setText("true");
//                } else {
//                    mBtnFour.setText("false");
//                }
//                break;
//            case R.id.btn_number_test_five:
//                if (SDNumberUtil.isDecimals(content)) {
//                    mBtnFive.setText("true");
//                } else {
//                    mBtnFive.setText("false");
//                }
//                break;
//            case R.id.btn_number_test_phone_num:
//                if (SDRegexUtil.isMobileExact(content)) {
//                    mBtnFive.setText("true");
//                } else {
//                    mBtnFive.setText("false");
//                }
//                break;
//            case R.id.btn_number_test_card_num:
//                if (SDRegexUtil.isIDCard18(content)) {
//                    mBtnFive.setText("true");
//                } else {
//                    mBtnFive.setText("false");
//                }
//                break;
//        }
//    }
//}
