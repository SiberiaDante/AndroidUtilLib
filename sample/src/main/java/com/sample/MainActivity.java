package com.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.siberiadante.util.ScreenUtil;
import com.siberiadante.util.Toast;
import com.siberiadante.view.PicassoCircleTransfer;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScreenUtil.init(this);
        Toast.toast(ScreenUtil.ScreenHeight + "");

    }
}
