package com.sample.ui.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sample.R;
import com.sample.SampleApplication;
import com.siberiadante.util.ScreenUtil;

public  class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtil.setStatusTranslucent(this);
    }
}
