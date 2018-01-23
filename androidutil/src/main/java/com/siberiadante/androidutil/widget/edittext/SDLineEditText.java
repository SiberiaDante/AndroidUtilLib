package com.siberiadante.androidutil.widget.edittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.siberiadante.androidutil.R;


/**
 * @Created SiberiaDante
 * @Describe： 自定义下划线的EditText
 * @CreateTime: 2017/12/18
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDLineEditText extends AppCompatEditText {

    private Paint mPaint;
    private int mLineColor = Color.BLACK;

    public SDLineEditText(Context context) {
        super(context);
    }

    public SDLineEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData(context, attrs);
    }

    public SDLineEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context, attrs);
    }

    private void initData(Context context, AttributeSet attrs) {
        TypedArray attrArrays = context.obtainStyledAttributes(attrs, R.styleable.SDLineEditText);

        mPaint = new Paint();
        mLineColor = attrArrays.getColor(R.styleable.SDLineEditText_line_color, mLineColor);
//        int lenght = attrArrays.getIndexCount();
//        for (int i = 0; i < lenght; i++) {
//            int index = attrArrays.getIndex(i);
//            switch (index) {
//                case R.styleable.LineEditText_line_color:
//                    mLineColor = attrArrays.getColor(index, mLineColor);
//                    break;
//            }
//        }
        attrArrays.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mLineColor);
        canvas.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1, mPaint);
    }
}