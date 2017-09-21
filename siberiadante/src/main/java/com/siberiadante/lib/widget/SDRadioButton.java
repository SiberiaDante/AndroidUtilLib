package com.siberiadante.lib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RadioButton;

import com.siberiadante.lib.R;


/**
 * Created by SiberiaDante on 2016/12/4.
 * 对RadioButton的重写；
 * 使用场景：RadioButton需要设置为图片+文字，并且对图片大小进行代码控制
 * 在xml中设置RadioButton中的图片size
 * drawableSize
 * drawableTop
 * drawableLeft
 * drawableRight
 * drawableBottom
 *
 * @Tips: 在xml中需要必填属性：android:clickable"="true";
 */

public class SDRadioButton extends RadioButton {
    private int mDrawableSize;// xml文件中设置的大小

    public SDRadioButton(Context context) {
        this(context, null, 0);
    }

    public SDRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SDRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        Drawable drawableLeft = null, drawableTop = null, drawableRight = null, drawableBottom = null;
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.SDRadioButton);

        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            Log.i("MyRadioButton", "attr:" + attr);
            if (attr == R.styleable.SDRadioButton_drawableSize) {
                mDrawableSize = a.getDimensionPixelSize(R.styleable.SDRadioButton_drawableSize, 50);
                Log.i("MyRadioButton", "mDrawableSize:" + mDrawableSize);
            }
            if (attr == R.styleable.SDRadioButton_drawableTop) {
                drawableTop = a.getDrawable(attr);
            }
            if (attr == R.styleable.SDRadioButton_drawableBottom) {
                drawableRight = a.getDrawable(attr);
            }
            if (attr == R.styleable.SDRadioButton_drawableRight) {
                drawableBottom = a.getDrawable(attr);
            }
            if (attr == R.styleable.SDRadioButton_drawableLeft) {
                drawableLeft = a.getDrawable(attr);
            }
        }
        a.recycle();

        setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom);

    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left,
                                                        Drawable top, Drawable right, Drawable bottom) {

        if (left != null) {
            left.setBounds(0, 0, mDrawableSize, mDrawableSize);
        }
        if (right != null) {
            right.setBounds(0, 0, mDrawableSize, mDrawableSize);
        }
        if (top != null) {
            top.setBounds(0, 0, mDrawableSize, mDrawableSize);
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, mDrawableSize, mDrawableSize);
        }
        setCompoundDrawables(left, top, right, bottom);
    }

}
