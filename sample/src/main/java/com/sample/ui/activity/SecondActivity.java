package com.sample.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.sample.R;
import com.siberiadante.lib.util.LogUtil;
import com.siberiadante.lib.util.ScreenUtil;

public class SecondActivity extends AppCompatActivity {

    private FrameLayout mFLDraw;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ScreenUtil.setStatusTranslucent(this);
        initView();
        initData();
    }

    public void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mFLDraw = (FrameLayout) findViewById(R.id.left_drawer);

        mToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.about_me, R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                LogUtil.d("--------close---------------");
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                LogUtil.d("--------open---------------");
            }
        }
        ;
        drawerLayout.addDrawerListener(mToggle);
    }

    public void initData() {

    }
}
