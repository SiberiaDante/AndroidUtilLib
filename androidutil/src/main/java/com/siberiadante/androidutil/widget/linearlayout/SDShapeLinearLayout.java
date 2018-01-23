package com.siberiadante.androidutil.widget.linearlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.siberiadante.androidutil.widget.base.SDRoundViewAttr;


/**
 * @Created SiberiaDante
 * @Describe： 简化LinearLayout shape 画背景
 * @Time: 2017/9/4
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDShapeLinearLayout extends LinearLayout {

    private SDRoundViewAttr roundViewAttr;

    public SDShapeLinearLayout(Context context) {
        this(context, null);
    }

    public SDShapeLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
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
