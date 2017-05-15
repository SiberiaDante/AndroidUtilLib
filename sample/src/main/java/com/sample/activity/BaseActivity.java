package com.sample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sample.R;

public  class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basa);
        initView();
        initData();
    }

    private void initView() {

    }

    private void initData() {
    }


}
