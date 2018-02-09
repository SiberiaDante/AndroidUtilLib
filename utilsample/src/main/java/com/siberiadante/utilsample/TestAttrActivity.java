package com.siberiadante.utilsample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;

public class TestAttrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_attr);
        testValueAnimator();
    }

    private void testValueAnimator() {
        //动画从0到10再到5再到0
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 10, 5, 0);
        //动画中每一帧更新的时候调用
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float animatedValue = (float) animation.getAnimatedValue();
            }
        });
        //动画的监听
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            //动画取消
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            //动画结束
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            //动画重复
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            //动画开始
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            //动画暂停
            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }

            //动画重启
            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        });
        //动画执行时间
        valueAnimator.setDuration(500);
        //动画重复次数
        valueAnimator.setRepeatCount(Integer.MAX_VALUE);
        //动画循环模式
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        //动画差值器
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        //设置动画延迟播放
        valueAnimator.setStartDelay(1000);
        //开始播放动画
        valueAnimator.start();
    }
}
