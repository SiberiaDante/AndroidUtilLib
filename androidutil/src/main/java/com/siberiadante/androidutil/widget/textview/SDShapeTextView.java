package com.siberiadante.androidutil.widget.textview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.siberiadante.androidutil.widget.base.SDRoundViewAttr;


/**
 * @Created SiberiaDante
 * @Describe： 简化TextView shape 画背景
 * @Time: 2017/9/4
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDShapeTextView extends TextView {

    private SDRoundViewAttr roundViewAttr;

    public SDShapeTextView(Context context) {
        this(context, null);
    }

    public SDShapeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SDShapeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        roundViewAttr = new SDRoundViewAttr(this, context, attrs);
    }

    public SDRoundViewAttr getRoundViewAttr() {
        return roundViewAttr;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (roundViewAttr.isWidthHeightEqual() && getWidth() > 0 && getHeight() > 0) {
            int max = Math.max(getWidth(), getHeight());
            int measureSpec = MeasureSpec.makeMeasureSpec(max, MeasureSpec.EXACTLY);
            super.onMeasure(measureSpec, measureSpec);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (roundViewAttr.isRadiusHalfHeight()) {
            roundViewAttr.setCornerRadius(getHeight() / 2);
        } else {
            roundViewAttr.setBgSelector();
        }
    }
}
