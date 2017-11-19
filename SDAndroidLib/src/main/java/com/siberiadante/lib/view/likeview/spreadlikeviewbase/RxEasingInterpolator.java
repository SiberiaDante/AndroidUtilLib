package com.siberiadante.lib.view.likeview.spreadlikeviewbase;

import android.animation.TimeInterpolator;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

/**
 * The Easing class provides a collection of ease functions. It does not use the standard 4 param
 * ease signature. Instead it uses a single param which indicates the current linear ratio (0 to 1) of the tween.
 */
@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class RxEasingInterpolator implements TimeInterpolator {

    private final RxEase ease;

    public RxEasingInterpolator(@NonNull RxEase rxEase) {
        this.ease = rxEase;
    }

    @Override
    public float getInterpolation(float input) {
        return RxEasingProvider.get(this.ease, input);
    }

    public RxEase getEase() {
        return ease;
    }
}
