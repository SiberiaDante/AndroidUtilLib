package com.siberiadante.utilsample.activity.widget;

import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.siberiadante.androidutil.widget.textview.SDAdaptiveTextView;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SDTextViewActivity extends BaseActivity {

    @BindView(R.id.tv_normal)
    TextView tvNormal;
    @BindView(R.id.tv_sd_adaptive)
    SDAdaptiveTextView tvSdAdaptive;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdtext_view;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        tvNormal.setText("这是正常的TextViewSiberiaDanteSiberiaDanteSiberiaDanteSiberiaDanteSiberiaDanteSiberiaDante");
//        tvSdAdaptive.post(new Runnable() {
//            @Override
//            public void run() {
//                tvSdAdaptive.setAdaptiveText("这是重写的SDAdaptiveTextViewSiberiaDanteSiberiaDanteSiberiaDanteSiberiaDanteSiberiaDanteSiberiaDante");
//            }
//        });

        tvSdAdaptive.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                tvSdAdaptive.setAdaptiveText("这是重写的SDAdaptiveTextViewSiberiaDanteSiberiaDanteSiberiaDanteSiberiaDanteSiberiaDanteSiberiaDante");
                tvSdAdaptive.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
