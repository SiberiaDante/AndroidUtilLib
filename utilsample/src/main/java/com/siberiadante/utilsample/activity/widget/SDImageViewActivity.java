package com.siberiadante.utilsample.activity.widget;

import android.os.Bundle;
import android.view.View;

import com.siberiadante.androidutil.widget.imageview.SDCircleImageView;
import com.siberiadante.androidutil.widget.imageview.SDNotifyImageView;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SDImageViewActivity extends BaseActivity {

    @BindView(R.id.sd_iv_notify)
    SDNotifyImageView sdIvNotify;
    @BindView(R.id.iv_circle)
    SDCircleImageView ivCircle;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdimage_view;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @OnClick({R.id.sd_iv_notify, R.id.iv_circle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sd_iv_notify:
                sdIvNotify.isShow(false);
                break;
            case R.id.iv_circle:
                break;
        }
    }
}
