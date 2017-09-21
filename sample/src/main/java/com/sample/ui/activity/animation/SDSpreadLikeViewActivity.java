package com.sample.ui.activity.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.view.likeview.SDSpreadLikeView;

public class SDSpreadLikeViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdspread_like_view);

        ((SDSpreadLikeView) findViewById(R.id.like_view_one)).init(this);
    }
}
