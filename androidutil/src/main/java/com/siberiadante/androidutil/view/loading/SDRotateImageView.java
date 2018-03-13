package com.siberiadante.androidutil.view.loading;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
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

public class SDRotateImageView extends FrameLayout {
    private ImageView imageView;
    RotateAnimation rotate;
    private boolean isAnimatorStart = false;

    public SDRotateImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sd_rotate_image_view, this, true);
        imageView = findViewById(R.id.iv_circle);
        initAnimator();
    }

    private void initAnimator() {
        rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setRepeatCount(-1);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setDuration(800);
        rotate.setFillAfter(true);
        imageView.startAnimation(rotate);
        isAnimatorStart = true;
    }

    public void startAnimator() {
        if (!isAnimatorStart) {
            rotate.start();
        }
    }

    public void stopAnimator() {
        if (isAnimatorStart) {
            rotate.cancel();
        }
    }
//    @Override
//    public void setVisibility(int visibility) {
//        super.setVisibility(visibility);
//        rotate.cancel();
//        this.clearAnimation();
//        ViewGroup parent = (ViewGroup) getParent();
//        if (parent != null) {
//            //将view从父布局移除
//            parent.removeView(this);
//            //移除自身所有的view
//            removeAllViews();
//        }
//    }

    /**
     * 在View销毁时停止动画
     */
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setVisibility(GONE);
    }
}
