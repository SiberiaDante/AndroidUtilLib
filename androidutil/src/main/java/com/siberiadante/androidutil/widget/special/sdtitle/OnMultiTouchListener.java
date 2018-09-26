package com.siberiadante.androidutil.widget.special.sdtitle;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class OnMultiTouchListener implements View.OnTouchListener {
    private int clickCount = 0;
    private TitleLayoutListener titleLayoutListener;
    private Handler mHandler;

    public OnMultiTouchListener(TitleLayoutListener titleLayoutListener) {
        this.titleLayoutListener = titleLayoutListener;
        mHandler = new Handler();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            clickCount++;
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (clickCount == 1) {
                        titleLayoutListener.onTitleClickListener();
                    } else if (clickCount == 2) {
                        titleLayoutListener.onTitleDoubleClickListener();
                    }
                    mHandler.removeCallbacksAndMessages(null);
                    clickCount = 0;

                }
            }, 500);
        }
        return false;
    }
}