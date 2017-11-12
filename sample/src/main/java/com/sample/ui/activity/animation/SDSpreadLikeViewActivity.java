package com.sample.ui.activity.animation;

import android.os.Bundle;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.view.likeview.SDSpreadLikeView;
import com.siberiadante.lib.view.titlebar.SDTitleLayout;

import butterknife.BindView;

public class SDSpreadLikeViewActivity extends BaseActivity {
    @BindView(R.id.like_view_one)
    SDSpreadLikeView likeViewOne;
    @BindView(R.id.title_layout)
    SDTitleLayout titleLayout;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdspread_like_view;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        titleLayout.setTitle(getString(R.string.LikeView));
        likeViewOne.init(this);
    }

    @Override
    public void initData() {

    }
}
