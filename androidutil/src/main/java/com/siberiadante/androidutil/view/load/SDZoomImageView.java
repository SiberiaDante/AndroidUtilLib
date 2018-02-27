package com.siberiadante.androidutil.view.load;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.siberiadante.androidutil.R;

/**
 * Created: SiberiaDante
 * Describe： 旋转一张图片的动画
 * CreateTime: 2018/1/26
 * UpDateTime:
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * Blog: http://www.cnblogs.com/shen-hua/
 */

public class SDZoomImageView extends FrameLayout {
    private ImageView imageView;
    private boolean isAnimatorStart = false;

    public SDZoomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sd_zoom_image_view, this, true);
        imageView = findViewById(R.id.iv_circle);
        startEnlarge();
    }

    private void startEnlarge() {
        final ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 0.5f, 1f);
        final ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 0.5f, 1f);
        final ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "alpha", 0.5f, 1f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleX, scaleY,alpha);
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                //弹起时旋转
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startNarrow();
            }
        });
        animatorSet.start();
    }

    private void startNarrow() {
        final ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 0.5f);
        final ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 0.5f);
        final ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0.5f);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleX, scaleY,alpha);
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                //弹起时旋转
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startEnlarge();
            }
        });
        animatorSet.start();
    }


    /**
     * 在View销毁时停止动画
     */
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
