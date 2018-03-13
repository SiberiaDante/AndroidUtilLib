package com.siberiadante.utilsample.activity.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.siberiadante.androidutil.view.custom.SDStepView;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SDStepViewActivity extends BaseActivity {


    @BindView(R.id.step_view)
    SDStepView stepView;
    @BindView(R.id.tv_start)
    Button tvStart;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdstep;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        stepView.setStepMax(10000);
//        stepView.setCurrentStep(5000);
        //属性动画
        final ValueAnimator valueAnimator = ObjectAnimator.ofFloat(0, 9000);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                stepView.setCurrentStep((int)value);
            }
        });
        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueAnimator.start();

            }
        });
    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.tv_start)
    public void onViewClicked() {
    }
}
