package com.sample.ui.activity.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.view.QQStepView;

public class QQExercisePedometerActivity extends BaseActivity {

    private QQStepView stepView;
    private TextView mTvStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqexercise_pedometer);
        initView();
    }

    private void initView() {
        mTvStart = (TextView) findViewById(R.id.tv_start);
        stepView = (QQStepView) findViewById(R.id.step_view);
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
        mTvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueAnimator.start();

            }
        });
    }
}
