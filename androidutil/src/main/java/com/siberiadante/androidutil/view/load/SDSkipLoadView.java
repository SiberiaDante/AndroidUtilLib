package com.siberiadante.androidutil.view.load;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import com.siberiadante.androidutil.R;
import com.siberiadante.androidutil.util.SDTransitionUtil;
import com.siberiadante.androidutil.view.load.base.SDShapeChangeView;


/**
 * Created:： SiberiaDante
 * @Date： 2017/10/3
 * Describe： 跳跃动画
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */
@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class SDSkipLoadView extends LinearLayout {

    private SDShapeChangeView mShapeChangeView;
    private View mShadowView;
    private int translateDistance;
    private long animateTime = 800;
    private boolean isStopAnimation = false;

    public SDSkipLoadView(Context context) {
        super(context);
        translateDistance = SDTransitionUtil.dp2px(88);
        initLayout();
    }

    public SDSkipLoadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        translateDistance = SDTransitionUtil.dp2px(88);
        initLayout();
    }

    public SDSkipLoadView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        translateDistance = SDTransitionUtil.dp2px(88);
        initLayout();
    }

    /**
     * 加载布局
     */
    private void initLayout() {

        inflate(getContext(), R.layout.sd_skip_load_view, this);
        mShapeChangeView = (SDShapeChangeView) findViewById(R.id.shapeChangeView);
        mShadowView = findViewById(R.id.shadowView);
        //开启动画
        post(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void run() {
                startFallAnimation();
            }
        });
    }

    /**
     * 分析：1.布局分为三块，分别为最上面ShapeChangeView,中间的阴影mShadowView,和下面的TextView
     * 2.ShapeChangeView 和 mShadowView有动画效果
     * 3.ShapeChangeView的动画效果是，下落和弹起。而当ShapeChangeView下落时伴随着阴影mShadowView
     * 的变小;弹起时阴影变大，如此往复
     * 4.当ShapeChangeView弹起时，为其添加旋转动画
     */

    /**
     * 定义 下落动画 和 阴影缩小动画
     */
    private void startFallAnimation() {
        if (isStopAnimation) {
            return;
        }
        //下落的动画
        ObjectAnimator translateAnimation = ObjectAnimator.ofFloat(mShapeChangeView, "translationY", 0, translateDistance);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        //阴影缩小动画
        ObjectAnimator scaleAnimation = ObjectAnimator.ofFloat(mShadowView, "scaleX", 1f, 0.4f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translateAnimation, scaleAnimation);
        animatorSet.setDuration(animateTime);
        animatorSet.setInterpolator(new AccelerateInterpolator());

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mShapeChangeView.changeShape();
                startUpAnimation();
            }
        });
        animatorSet.start();
    }

    private void startUpAnimation() {
        if (isStopAnimation) {
            return;
        }
        //弹起的动画
        ObjectAnimator translateAnimation = ObjectAnimator.ofFloat(mShapeChangeView, "translationY", translateDistance, 0);
        //阴影放大的动画
        ObjectAnimator scaleAnimation = ObjectAnimator.ofFloat(mShadowView, "scaleX", 0.4f, 1f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translateAnimation, scaleAnimation);
        animatorSet.setDuration(animateTime);
        animatorSet.setInterpolator(new DecelerateInterpolator());

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                //弹起时旋转
                startRotateAnimation();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startFallAnimation();
            }
        });
        animatorSet.start();

    }

    private void startRotateAnimation() {
        if (isStopAnimation) {
            return;
        }
        ObjectAnimator rotateAnimation = null;
        switch (mShapeChangeView.getCurShape()) {
            case CIRCLE:
            case RECTANGLE:
                rotateAnimation = ObjectAnimator.ofFloat(mShapeChangeView, "rotation", 0, 180);
                break;
            case TRIANGLE:
                rotateAnimation = ObjectAnimator.ofFloat(mShapeChangeView, "rotation", 0, -120);
                break;
        }
        rotateAnimation.setDuration(animateTime);
        rotateAnimation.start();
    }

    /**
     * 不处理会有内存泄露
     *
     * @param visibility
     */
    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(View.INVISIBLE);
        //清除View的动画
        mShapeChangeView.clearAnimation();
        mShadowView.clearAnimation();

        ViewGroup parent = (ViewGroup) getParent();
        if (parent != null) {
            //将view从父布局移除
            parent.removeView(this);
            //移除自身所有的view
            removeAllViews();
        }
        isStopAnimation = true;
    }
}
