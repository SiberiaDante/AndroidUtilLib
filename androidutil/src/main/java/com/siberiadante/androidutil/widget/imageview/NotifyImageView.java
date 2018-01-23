package com.siberiadante.androidutil.widget.imageview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.siberiadante.androidutil.R;


/**
 * @Created SiberiaDante
 * @Describe： 带通知圆点的ImageView
 * @CreateTime: 2017/12/12
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class NotifyImageView extends AppCompatImageView {
    private Paint mPaint = new Paint();
    private float radius;
    private boolean isShow;

    public NotifyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        radius = context.getResources().getDimension(R.dimen.notify_radius);
        mPaint.setAntiAlias(true);
        mPaint.setColor(ContextCompat.getColor(context, R.color.viewColorCircleNotify));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isShow) {
            final Drawable drawable = getDrawable();
            final Rect rect = drawable.getBounds();
            float rx = getMeasuredWidth() / 2 + rect.width() / 2 - radius / 2;
            float ry = rect.height() / 4;
            canvas.drawCircle(rx, ry, radius, mPaint);
        }
    }

    public void isShow(boolean isShow) {
        this.isShow = isShow;
        invalidate();
    }
}
