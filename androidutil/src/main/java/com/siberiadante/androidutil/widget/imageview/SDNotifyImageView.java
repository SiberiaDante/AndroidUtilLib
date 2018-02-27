package com.siberiadante.androidutil.widget.imageview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.siberiadante.androidutil.R;


/**
 * Created: SiberiaDante
 * Describe： 带通知圆点的ImageView
 * CreateTime: 2017/12/12
 * UpDateTime:
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 */

public class SDNotifyImageView extends AppCompatImageView {
    private Paint mPaint = new Paint();
    private int mRadius=4;
    private boolean isNotifyShow = true;

    public SDNotifyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        @SuppressLint("CustomViewStyleable") TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SDCircleNotifyView );
        isNotifyShow = attributes.getBoolean(R.styleable.SDCircleNotifyView_sd_notify_show, isNotifyShow);
        mRadius = attributes.getDimensionPixelSize(R.styleable.SDCircleNotifyView_sd_notify_radius, mRadius);
        int color = attributes.getColor(R.styleable.SDCircleNotifyView_sd_notify_color, Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setColor(color);
        attributes.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isNotifyShow) {
            final Drawable drawable = getDrawable();
            final Rect rect = drawable.getBounds();
            float rx = getMeasuredWidth() / 2 + rect.width() / 2 - mRadius / 2;
            float ry = rect.height() / 4;
            canvas.drawCircle(rx, ry, mRadius, mPaint);
        }
    }

    public void isShow(boolean isShow) {
        this.isNotifyShow = isShow;
        invalidate();
    }
}
