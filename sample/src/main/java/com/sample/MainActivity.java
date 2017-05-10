package com.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sample.activity.Main2Activity;
import com.siberiadante.SiberiaDanteLib;
import com.siberiadante.util.ActivityUtil;
import com.siberiadante.util.ScreenUtil;
import com.siberiadante.util.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScreenUtil.init(this);
        Toast.toast(String.valueOf(ScreenUtil.ScreenHeight));
        initView();
        testOne();

    }

    private void testOne() {
        boolean activityExists = ActivityUtil.isActivityExists("com.sample", Main2Activity.class.getName());
        Log.d(TAG, "testOne: activityExists:"+Main2Activity.class.getName()+"activityExists???"+activityExists);
    }

    private void initView() {
        Button mBtnStartActivity = (Button) findViewById(R.id.btn_start_other_activity);
        mBtnStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtil.launchActivity("com.sample", Main2Activity.class.getName());
            }
        });
    }

}
