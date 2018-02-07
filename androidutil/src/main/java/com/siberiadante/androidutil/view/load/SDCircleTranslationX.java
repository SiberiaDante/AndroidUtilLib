package com.siberiadante.androidutil.view.load;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.siberiadante.androidutil.R;
import com.siberiadante.androidutil.util.SDLogUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/12/22
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */

public class SDCircleTranslationX extends View {
    public static final String TAG = SDCircleTranslationX.class.getSimpleName();
    /**
     * 开始执行的第一个动画的索引，
     * 由于第一个和第二个同时当执行，
     * 当第一遍执行完毕后就让第一个停下来在中间位置，换原来中间位置的第三个开始执行动画，
     * 以此类推，当第二遍执行完毕后第二个停下来，中间位置的开始执行动画。
     */
    private int sweepIndex = 0;
    /**
     * 交换执行动画的颜色数组
     */
    private int[] colors = new int[]{getResources().getColor(R.color.sdColorYellow),
            getResources().getColor(R.color.sdColorRed),
            getResources().getColor(R.color.sdColorBlue)};

    /**
     * 动画所执行的最大偏移量（即中间点和最左边的距离）
     */
    private Float maxWidth = 200f;

    /**
     * 三个圆的半径
     */
    private Float radius = 30f;

    /**
     * 当前偏移的X坐标
     */
    private Float currentX = 0f;
    /**
     * 画笔
     */
    private Paint paint;
    /**
     * 属性动画
     */
    private ValueAnimator valueAnimator;

    public SDCircleTranslationX(Context context) {
        super(context);
        startAnimator();
    }

    public SDCircleTranslationX(Context context, AttributeSet attrs) {
        super(context, attrs);
        startAnimator();
    }

    public SDCircleTranslationX(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        startAnimator();
    }


    /**
     * 用属性动画实现位移动画
     */
    private void startAnimator() {
        valueAnimator = ValueAnimator.ofFloat(0f, maxWidth, 0);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentX = (Float) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                sweep(sweepIndex);
            }
        });
        valueAnimator.setInterpolator(new LinearInterpolator());
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setDuration(1000);
        valueAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        SDLogUtil.d(TAG, "--------onDraw-----");
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        /**画左边的圆**/
        paint.setColor(colors[0]);
        canvas.drawCircle(centerX - currentX, centerY, radius, paint);

        /**画右边的圆**/
        paint.setColor(colors[1]);
        canvas.drawCircle(centerX + currentX, centerY, radius, paint);

        /**画中间的圆**/
        paint.setColor(colors[2]);
        canvas.drawCircle(centerX, centerY, radius, paint);

    }

    /**
     * 每次让先执行动画的目标和中间停止的动画目标交换
     *
     * @param a 最先执行的动画的索引
     */
    private void sweep(int a) {
        int temp = colors[2];
        colors[2] = colors[a];
        colors[a] = temp;

        if (a == 0) {
            sweepIndex = 1;
        } else {
            sweepIndex = 0;
        }
    }

    /**
     * 在View销毁时停止动画
     */
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        valueAnimator.cancel();
    }
}