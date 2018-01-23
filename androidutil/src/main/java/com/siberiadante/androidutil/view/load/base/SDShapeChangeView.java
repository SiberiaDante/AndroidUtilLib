package com.siberiadante.androidutil.view.load.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.siberiadante.androidutil.R;


/**
 * @Created： SiberiaDante
 * @Date： 2017/10/3
 * @Describe：
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */

public class SDShapeChangeView extends View {

    //初始形状
    public Shape mCurShape = Shape.CIRCLE;
    private Paint mPaint;
    private Path mPath;

    /**
     * 定义形状的枚举类型
     */
    public enum Shape {
        CIRCLE,
        RECTANGLE,
        TRIANGLE,
    }

    public SDShapeChangeView(Context context) {
        this(context, null);
    }

    public SDShapeChangeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SDShapeChangeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPath = new Path();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

    }

    /**
     * 获取当前View绘制的形状
     * @return
     */
    public Shape getCurShape() {
        return mCurShape;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //指定View的宽高
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width>height?height:width, width>height?height:width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int center = getWidth() / 2;
        switch (mCurShape) {
            case CIRCLE:
                //画圆
                mPaint.setColor(ContextCompat.getColor(getContext(), R.color.viewColorRed));
                canvas.drawCircle(center, center, center, mPaint);
                break;
            case RECTANGLE:
                //画正方形
                mPaint.setColor(ContextCompat.getColor(getContext(), R.color.viewColorGreen));
                canvas.drawRect(0, 0, getRight(), getBottom(), mPaint);
                break;
            case TRIANGLE:
                //用Path画三角形
                mPaint.setColor(ContextCompat.getColor(getContext(),R.color.viewColorGray));
                //指定path的起点
                mPath.moveTo(getWidth() / 2, 0);
                mPath.lineTo(0, (float) (getWidth() / 2 * Math.sqrt(3)));
                mPath.lineTo(getWidth(), (float) (getWidth() / 2 * Math.sqrt(3)));
                canvas.drawPath(mPath, mPaint);
                break;
        }
    }

    /**
     *轮询改变当前View绘制的形状
     */
    public void changeShape() {
        switch (mCurShape) {
            case CIRCLE:
                mCurShape = Shape.RECTANGLE;
                break;
            case RECTANGLE:
                mCurShape = Shape.TRIANGLE;
                break;
            case TRIANGLE:
                mCurShape = Shape.CIRCLE;
                break;
        }
        invalidate();
    }

}
