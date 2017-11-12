package com.sample.ui.activity.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;

/**
 * EditText和Keyboard交互处理
 */
public class KeyBoardActivity extends BaseActivity {

    private EditText mEdtOne, mEdtTwo;
    private View mBtnOne;

    @Override
    public int setLayoutId() {
        return R.layout.activity_key_board;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mEdtOne = (EditText) findViewById(R.id.edt_one);
        mEdtTwo = (EditText) findViewById(R.id.edt_two);
        mBtnOne = findViewById(R.id.btn_one);
    }

    @Override
    public void initData() {

    }

//    @Override
//    public View[] filterViewByIds() {
//        View[] views = {mBtnOne};
//        return views;
//    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.edt_one, R.id.edt_two};
        return ids;
    }
}
