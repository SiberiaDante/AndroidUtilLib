package com.siberiadante.androidutil.widget.behavior;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import com.siberiadante.androidutil.util.SDLogUtil;

/**
 * CreateTime: 2018/6/21
 * UpDateTime:
 * Describe:
 * onLayoutChild——onStartNestedScroll——onNestedScrollAccepted——onNestedPreScroll——onNestedScroll——
 * onNestedPreFling——onNestedFling——onStartNestedScroll——onNestedScrollAccepted——onStopNestedScroll——onNestedPreScroll——onStopNestedScroll
 */
public class AppBarLayoutOverScrollViewBehavior extends AppBarLayout.Behavior {
    public static final String TAG = AppBarLayoutOverScrollViewBehavior.class.getSimpleName();
    private static final String scrollTag = "overScroll";
    private static final float TARGET_HEIGHT = 500; // 最大滑动距离
    private View mTargetView;
    private int mParentHeight;
    private int mTargetViewHeight;
    private float mTotalDy;     // 总滑动的像素数
    private float mLastScale;   // 最终放大比例
    private int mLastBottom;    // AppBarLayout的最终Bottom值
    private boolean isAnimate;  //是否有动画

    public AppBarLayoutOverScrollViewBehavior() {
    }

    public AppBarLayoutOverScrollViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 当CoordinatorLayout的子View尝试发起嵌套滚动时调用
     *
     * @param parent            父布局CoordinatorLayout
     * @param child             使用此Behavior的AppBarLayout
     * @param directTargetChild CoordinatorLayout的子View，或者是包含嵌套滚动操作的目标View
     * @param target            发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     * @param nestedScrollAxes  嵌套滚动的方向
     * @param type
     * @return 返回true表示接受滚动
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int nestedScrollAxes, int type) {
        SDLogUtil.e(TAG, "-----------------onStartNestedScroll-------------------");
        // 开始滑动时，启用动画
        isAnimate = true;
        return super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes, type);
    }

    /**
     * 当准备开始嵌套滚动时调用
     *
     * @param coordinatorLayout 父布局CoordinatorLayout
     * @param child             使用此Behavior的AppBarLayout
     * @param target            发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     * @param dx                用户在水平方向上滑动的像素数
     * @param dy                用户在垂直方向上滑动的像素数
     * @param consumed          输出参数，consumed[0]为水平方向应该消耗的距离，consumed[1]为垂直方向应该消耗的距离
     * @param type
     */
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed, int type) {
        SDLogUtil.e(TAG, "-----------------onNestedPreScroll-------------------");
        // 1.mTargetView不为null
        // 2.是向下滑动，dy<0表示向下滑动
        // 3.AppBarLayout已经完全展开，child.getBottom() >= mParentHeight
        if (mTargetView != null && dy < 0 && child.getBottom() >= mParentHeight) {
            // 累加垂直方向上滑动的像素数
            mTotalDy += -dy;
            // 不能大于最大滑动距离
            mTotalDy = Math.min(mTotalDy, TARGET_HEIGHT);
            // 计算目标View缩放比例，不能小于1
            mLastScale = Math.max(1f, 1f + mTotalDy / TARGET_HEIGHT);
            // 缩放目标View
            ViewCompat.setScaleX(mTargetView, mLastScale);
            ViewCompat.setScaleY(mTargetView, mLastScale);
            // 计算目标View放大后增加的高度
            mLastBottom = mParentHeight + (int) (mTargetViewHeight / 2 * (mLastScale - 1));
            // 修改AppBarLayout的高度
            child.setBottom(mLastBottom);

        }
        // 1.mTargetView不为null
        // 2.是向上滑动，dy>0表示向下滑动
        // 3.AppBarLayout尚未恢复到原始高度child.getBottom() > mParentHeight
        else if (mTargetView != null && dy > 0 && child.getBottom() > mParentHeight) {
            // 累减垂直方向上滑动的像素数
            mTotalDy -= dy;
            // 计算目标View缩放比例，不能小于1
            mLastScale = Math.max(1f, 1f + mTotalDy / TARGET_HEIGHT);
            // 缩放目标View
            ViewCompat.setScaleX(mTargetView, mLastScale);
            ViewCompat.setScaleY(mTargetView, mLastScale);
            // 计算目标View缩小后减少的高度
            mLastBottom = mParentHeight + (int) (mTargetViewHeight / 2 * (mLastScale - 1));
            // 修改AppBarLayout的高度
            child.setBottom(mLastBottom);
            // 保持target不滑动
            target.setScrollY(0);
        } else {
            super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);

        }

    }

    /**
     * @param coordinatorLayout 父布局CoordinatorLayout
     * @param child             使用此Behavior的AppBarLayout
     * @param target            发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     * @param dxConsumed        由目标View滚动操作消耗的水平像素数
     * @param dyConsumed        由目标View滚动操作消耗的垂直像素数
     * @param dxUnconsumed      由用户请求但是目标View滚动操作未消耗的水平像素数
     * @param dyUnconsumed      由用户请求但是目标View滚动操作未消耗的垂直像素数
     * @param type
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        SDLogUtil.e(TAG, "-----------------onNestedScroll-------------------");
    }

    /**
     * 当停止滚动时调用
     *
     * @param coordinatorLayout 父布局CoordinatorLayout
     * @param abl               使用此Behavior的AppBarLayout
     * @param target            发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     * @param type
     */
    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout abl, View target, int type) {
        recovery(abl);
        super.onStopNestedScroll(coordinatorLayout, abl, target, type);
        SDLogUtil.e(TAG, "-----------------onStopNestedScroll-------------------");
    }

    /**
     * AppBarLayout 布局时调用
     *
     * @param parent          父布局CoordinatorLayout
     * @param abl             使用此Behavior的AppBarLayout
     * @param layoutDirection layoutDirection 布局方向
     * @return 返回true表示子View重新布局，返回false表示请求默认布局
     */
    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, AppBarLayout abl, int layoutDirection) {
        SDLogUtil.e(TAG, "-----------------onLayoutChild-------------------");
        boolean handled = super.onLayoutChild(parent, abl, layoutDirection);
        if (mTargetView == null) {
            mTargetView = parent.findViewWithTag(scrollTag);
            if (mTargetView != null) {
                initial(abl);
            }
        }
        return handled;
    }

    private void initial(AppBarLayout appBarLayout) {
        // 必须设置ClipChildren为false，这样目标View在放大时才能超出布局的范围
        appBarLayout.setClipChildren(false);
        mParentHeight = appBarLayout.getHeight();
        mTargetViewHeight = mTargetView.getHeight();
        SDLogUtil.i(TAG, "----------------mParentHeight=" + mParentHeight + "-----------mTargetViewHeight:" + mTargetViewHeight);
    }

    private void recovery(final AppBarLayout abl) {
        if (mTotalDy > 0) {
            mTotalDy = 0;
            if (isAnimate) {
                ValueAnimator anim = ValueAnimator.ofFloat(mLastScale, 1f).setDuration(200);
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        ViewCompat.setScaleX(mTargetView, value);
                        ViewCompat.setScaleY(mTargetView, value);
                        abl.setBottom((int) (mLastBottom - (mLastBottom - mParentHeight) * animation.getAnimatedFraction()));
                    }
                });
                anim.start();
            } else {
                ViewCompat.setScaleX(mTargetView, 1f);
                ViewCompat.setScaleY(mTargetView, 1f);
                abl.setBottom(mParentHeight);
            }
        }
    }

//    private void recovery(final AppBarLayout abl) {
//        if (mTotalDy > 0) {
//            mTotalDy = 0;
//            // 使用属性动画还原
//            ValueAnimator anim = ValueAnimator.ofFloat(mLastScale, 1f).setDuration(200);
//            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(ValueAnimator animation) {
//                    float value = (float) animation.getAnimatedValue();
//                    ViewCompat.setScaleX(mTargetView, value);
//                    ViewCompat.setScaleY(mTargetView, value);
//                    abl.setBottom((int) (mLastBottom - (mLastBottom - mParentHeight) * animation.getAnimatedFraction()));
//                }
//            });
//            anim.start();
//        }
//    }

    private void scale(AppBarLayout abl, View target, int dy) {
        mTotalDy += -dy;
        mTotalDy = Math.min(mTotalDy, TARGET_HEIGHT);
        mLastScale = Math.max(1f, 1f + mTotalDy / TARGET_HEIGHT);
        ViewCompat.setScaleX(mTargetView, mLastScale);
        ViewCompat.setScaleY(mTargetView, mLastScale);
        mLastBottom = mParentHeight + (int) (mTargetViewHeight / 2 * (mLastScale - 1));
        abl.setBottom(mLastBottom);
        target.setScrollY(0);
    }

    /**
     * 当嵌套滚动已由CoordinatorLayout接受时调用
     *
     * @param coordinatorLayout 父布局CoordinatorLayout
     * @param child             使用此Behavior的AppBarLayout
     * @param directTargetChild CoordinatorLayout的子View，或者是包含嵌套滚动操作的目标View
     * @param target            发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     * @param axes              嵌套滚动的方向
     * @param type
     */
    @Override
    public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, axes, type);
        SDLogUtil.e(TAG, "-----------------onNestedScrollAccepted-------------------");
    }

    /**
     * 当嵌套滚动的子View快速滚动时调用
     *
     * @param coordinatorLayout 父布局CoordinatorLayout
     * @param child             使用此Behavior的AppBarLayout
     * @param target            发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     * @param velocityX         水平方向的速度
     * @param velocityY         垂直方向的速度
     * @param consumed          如果嵌套的子View消耗了快速滚动则为true
     * @return 如果Behavior消耗了快速滚动返回true
     */
    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        SDLogUtil.e(TAG, "-----------------onNestedFling-------------------");
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    /**
     * 当嵌套滚动的子View准备快速滚动时调用
     *
     * @param coordinatorLayout 父布局CoordinatorLayout
     * @param child             使用此Behavior的AppBarLayout
     * @param target            发起嵌套滚动的目标View(即AppBarLayout下面的ScrollView或RecyclerView)
     * @param velocityX         水平方向的速度
     * @param velocityY         垂直方向的速度
     * @return 如果Behavior消耗了快速滚动返回true
     */
    @Override
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout child, @NonNull View target, float velocityX, float velocityY) {
        SDLogUtil.e(TAG, "-----------------onNestedPreFling-------------------");
        // 如果触发了快速滚动且垂直方向上速度大于100，则禁用动画
        if (velocityY > 100) {
            isAnimate = false;
        }
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }
}
