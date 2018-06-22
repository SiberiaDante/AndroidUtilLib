package com.siberiadante.utilsample.activity.widget;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SDOverScrollBehaviorActivity extends BaseActivity {

    @BindView(R.id.siv_picture)
    ImageView sivPicture;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.appbar)
    AppBarLayout appbar;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdover_scroll_behavior;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        appbar.post(new Runnable() {
            @Override
            public void run() {
                appbar.invalidate();
            }
        });

    }


}
