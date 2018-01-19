package com.siberiadante.androidutil.widget.radiobutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

import com.siberiadante.androidutil.R;


/**
 * @Created SiberiaDante
 * @Describe： 带通知圆点的RadioButton
 * @CreateTime: 2017/12/13
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDNotifyRadioButton extends AppCompatRadioButton {
    private Paint mPaint = new Paint();
    private int mRadius;
    private boolean isShow = true;

    public SDNotifyRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        final TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SDNotifyRadioButton);
        isShow = attributes.getBoolean(R.styleable.SDNotifyRadioButton_sd_notify_show, isShow);
        mRadius = attributes.getDimensionPixelSize(R.styleable.SDNotifyRadioButton_sd_notify_radius, 4);
        int color = attributes.getColor(R.styleable.SDNotifyRadioButton_sd_notify_color, Color.RED);

        mPaint.setAntiAlias(true);
        mPaint.setColor(color);
        attributes.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isShow) {
            //获取到DrawableTop,  0 drawableleft 1 drawabletop 2 drawableright 3 drawablebottom
            Drawable[] compoundDrawables = getCompoundDrawables();
            Drawable drawableTop = compoundDrawables[1];
            //drawableTop的 right top bottom的值
            final Rect rect = drawableTop.getBounds();
            /**
             * getMeasuredWidth() / 2：控件宽度的一半
             * rect.width()/2：图片宽度的一半
             * radius / 2：圆点宽度的一半
             */
            final float rx = getMeasuredWidth() / 2 + rect.width() / 2 - mRadius / 2;
            float ry = rect.height() / 4;
            canvas.drawCircle(rx, ry, mRadius, mPaint);
        }
    }

    /**
     * 设置圆点是否显示
     *
     * @param isShow
     */
    public void isShow(boolean isShow) {
        this.isShow = isShow;
        invalidate();
    }
}