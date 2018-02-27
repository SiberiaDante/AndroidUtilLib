package com.siberiadante.utilsample.abouttest;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.siberiadante.utilsample.R;

public class AnimatorTest {
    //    private void testValueAnimator() {
//        //使用xml属性动画
//        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.valueanimator);
//        //动画监听
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                Integer animatedValue = (Integer) animation.getAnimatedValue();
//                view.scrollTo(animatedValue, 0);
//            }
//        });
//        valueAnimator.start();
//    ImageView imageView = new ImageView();
    //        /**
//         propertyName参数说明：
//         alpha：透明度
//         rotation：旋转
//         translationX：平移
//         scaleY：缩放
//         */
//    ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(imageView, "alpha", 1, 10, 10, 5, 1);
    //    }
//    private void testObjectAnimator() {
//        ImageView imageView = new ImageView();
//        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(imageView, "alpha", 1, 10, 10, 5, 1);
//        alphaAnimator.setDuration(2000);
//        alphaAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        alphaAnimator.setRepeatCount(10);
//        alphaAnimator.setInterpolator(new DecelerateInterpolator());
//        alphaAnimator.start();
//        alphaAnimator.setStartDelay(1000);
//    }
}
