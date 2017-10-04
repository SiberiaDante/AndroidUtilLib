package com.sample.ui.activity.view;

import android.os.Bundle;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.SDLogUtil;
import com.siberiadante.lib.view.SDRatingBarView;

public class RantingBarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_bar);
        /** RatingBar 评分条测试**/
        SDRatingBarView ratingBar = (SDRatingBarView) findViewById(R.id.ratingBar);
//        ratingBar.setInitRate(3);
        ratingBar.setonRateSelectedListener(new SDRatingBarView.OnRateSelectedListener() {
            @Override
            public void onRateSelect(int rate) {
                SDLogUtil.i( "当前选择个数是" + rate + "个");
            }
        });
    }
}
