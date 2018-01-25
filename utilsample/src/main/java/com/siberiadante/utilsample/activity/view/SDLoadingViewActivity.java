package com.siberiadante.utilsample.activity.view;

import android.os.Bundle;
import android.view.View;

import com.siberiadante.androidutil.view.load.SDCircleMove;
import com.siberiadante.androidutil.view.load.SDSkipLoadView;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SDLoadingViewActivity extends BaseActivity {

    @BindView(R.id.sd_circle_move)
    SDCircleMove sdCircleMove;
    @BindView(R.id.sd_skip_load_view)
    SDSkipLoadView sdSkipLoadView;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdloading_view;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sdSkipLoadView.setVisibility(View.GONE);
    }
}
