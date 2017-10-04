package com.siberiadante.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.siberiadante.lib.R;

/**
 * @Created： SiberiaDante
 * @Date： 2017/10/2
 * @Describe： 评分组件
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */

public class SDRatingBarView extends View {

    private Bitmap mNormalStar;
    private Bitmap mSelectStar;
    private int mStarPadding;
    private int mStarNum;
    private Paint mPaint;
    private int mCurrentStarPos = 0;

    public SDRatingBarView(Context context) {
        this(context, null);
    }

    public SDRatingBarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SDRatingBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SDRatingBar);
        int normalRes = typedArray.getResourceId(R.styleable.SDRatingBar_sd_normalStar, 0);
        mNormalStar = BitmapFactory.decodeResource(getResources(), normalRes);
        int selectRes = typedArray.getResourceId(R.styleable.SDRatingBar_sd_selectStar, 0);
        mSelectStar = BitmapFactory.decodeResource(getResources(), selectRes);
        mStarNum = typedArray.getInt(R.styleable.SDRatingBar_sd_starNum, 5);
        mStarPadding = typedArray.getDimensionPixelOffset(R.styleable.SDRatingBar_sd_starPadding, 0);
        typedArray.recycle();
        mPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //高度设置为 星星的高度
        int height = mNormalStar.getHeight();
        //宽度设置为 星星总宽度 + 间隔
        int width = mNormalStar.getWidth() * mStarNum + mStarPadding * (mStarNum - 1);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mStarNum; i++) {
            int x = (mNormalStar.getWidth() + mStarPadding) * i;
            if (mCurrentStarPos > i) {
                //绘制选中
                canvas.drawBitmap(mSelectStar, x, 0, mPaint);
            } else {
                //绘制默认
                canvas.drawBitmap(mNormalStar, x, 0, mPaint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_DOWN:
                //触摸位置
                float dx = event.getX();
                //计算触摸的级别
                int currentStarPos = (int) (dx / (mNormalStar.getWidth() + mStarPadding) + 1);
                if (currentStarPos > mStarNum) {
                    mCurrentStarPos = mStarNum;
                }
                if (currentStarPos <= 0) {
                    mCurrentStarPos = 1;
                }
                //如果滑动级别未发生变化，return，不重绘
                if (currentStarPos == mCurrentStarPos) {
                    return true;
                }
                mCurrentStarPos = currentStarPos;
                invalidate();
                //回调当前选中的级别
                onRateSelectedListener.onRateSelect(mCurrentStarPos);
                break;
        }
        return true;
    }

    /**
     * 初始化级别
     *
     * @param rate
     */
    public void setInitRate(int rate) {
        if (rate > mStarNum) {
            throw new RuntimeException("初始化的SDRatingBar的值不能大于" + mStarNum);
        }
        this.mCurrentStarPos = rate;
        invalidate();
    }

    public OnRateSelectedListener onRateSelectedListener;

    public void setonRateSelectedListener(OnRateSelectedListener listener) {
        this.onRateSelectedListener = listener;
    }

    public interface OnRateSelectedListener {
        /**
         *
         * @param rate ：触摸选中的组件个数
         */
        void onRateSelect(int rate);
    }
}
