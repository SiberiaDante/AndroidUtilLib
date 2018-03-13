package com.siberiadante.utilsample.activity.view;

import android.os.Bundle;


import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.androidutil.widget.special.SDRatingBarView;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;

public class SDRankingActivity extends BaseActivity {


    @BindView(R.id.ratingBar)
    SDRatingBarView ratingBar;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdranking;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        ratingBar.setonRateSelectedListener(new SDRatingBarView.OnRateSelectedListener() {
            @Override
            public void onRateSelect(int rate) {
                SDLogUtil.i( "当前选择个数是" + rate + "个");
            }
        });
    }

    @Override
    public void initData() {

    }
}
