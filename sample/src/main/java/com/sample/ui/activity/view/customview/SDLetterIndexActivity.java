package com.sample.ui.activity.view.customview;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.view.SDLetterIndexView;

public class SDLetterIndexActivity extends BaseActivity {

    private Handler handler = new Handler();


    @Override
    public int setLayoutId() {
        return R.layout.activity_sdletter_index;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        final TextView tvIndicator = (TextView) findViewById(R.id.tv_indicator);

        SDLetterIndexView letterIndexView = (SDLetterIndexView) findViewById(R.id.letterIndexView);
        letterIndexView.setOnLetterTouchListener(new SDLetterIndexView.OnLetterTouchListener() {
            @Override
            public void onTouchIndex(String letter, boolean isShow) {
                if (isShow) {
                    tvIndicator.setVisibility(View.VISIBLE);
                    tvIndicator.setText(letter);
                } else {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvIndicator.setVisibility(View.GONE);
                        }
                    }, 300);
                }

            }
        });
    }

    @Override
    public void initData() {

    }

}
