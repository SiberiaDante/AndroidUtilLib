package com.siberiadante.androidutil.widget.edittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.siberiadante.androidutil.R;
import com.siberiadante.androidutil.util.SDLogUtil;


/**
 * Created: SiberiaDante
 * Describe： 自定义下划线的EditText
 * CreateTime: 2017/12/18
 * UpDateTime:
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 */

public class SDLineEditText extends AppCompatEditText {

    private Paint mPaint;
    private int mLineColor = Color.BLACK;
    private int mLineHeight = 1;
//    private int mLinePaddingTop = 1;

    public SDLineEditText(Context context) {
        super(context);
    }

    public SDLineEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData(context, attrs);
    }

    private void initData(Context context, AttributeSet attrs) {
        TypedArray attrArrays = context.obtainStyledAttributes(attrs, R.styleable.SDLineEditText);
        mPaint = new Paint();
        mLineColor = attrArrays.getColor(R.styleable.SDLineEditText_sd_line_color, mLineColor);
        mLineHeight = attrArrays.getDimensionPixelSize(R.styleable.SDLineEditText_sd_line_height, mLineHeight);
//        mLinePaddingTop = attrArrays.getDimensionPixelSize(R.styleable.SDLineEditText_sd_line_paddingTop, mLinePaddingTop);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mLineColor);
        mPaint.setStrokeWidth(mLineHeight);
        attrArrays.recycle();
    }

    public SDLineEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawLine(0, getHeight() - mLinePaddingTop, getWidth(), getHeight() - mLinePaddingTop, mPaint);
        canvas.drawLine(0, getHeight(), getWidth(), getHeight(), mPaint);
    }
}