package com.siberiadante.lib.view.likeview.spreadlikeviewbase;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.RequiresApi;


/**
 * 16/7/5 下午5:09
 **/
@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class RxShineAnimator extends ValueAnimator {

    float MAX_VALUE = 1.5f;
    long ANIM_DURATION = 1500;
    Canvas canvas;

    RxShineAnimator() {
        setFloatValues(1f, MAX_VALUE);
        setDuration(ANIM_DURATION);
        setStartDelay(200);
        setInterpolator(new RxEasingInterpolator(RxEase.QUART_OUT));
    }

    RxShineAnimator(long duration, float max_value, long delay) {
        setFloatValues(1f, max_value);
        setDuration(duration);
        setStartDelay(delay);
        setInterpolator(new RxEasingInterpolator(RxEase.QUART_OUT));
    }

    public void startAnim(final RxShineView rxShineView, final int centerAnimX, final int centerAnimY) {

        start();
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }


}
