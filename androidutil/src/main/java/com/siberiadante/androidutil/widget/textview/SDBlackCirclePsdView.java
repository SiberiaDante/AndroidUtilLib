package com.siberiadante.androidutil.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * CreateTime: 2018/6/13
 * UpDateTime:
 * Describe:
 */
public class SDBlackCirclePsdView extends AppCompatTextView {


    private float radius;

    private boolean hasPwd;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public SDBlackCirclePsdView(Context context) {
        this(context, null);
    }

    public SDBlackCirclePsdView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SDBlackCirclePsdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (hasPwd) {
            // 画一个黑色的圆
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
        }
    }

    public void clearPwd() {
        this.hasPwd = false;
        invalidate();
    }


    public void drawPwd(float radius) {
        this.hasPwd = true;
        if (radius == 0) {
            this.radius = getWidth() / 4;
        } else {
            this.radius = radius;
        }
        invalidate();
    }

}