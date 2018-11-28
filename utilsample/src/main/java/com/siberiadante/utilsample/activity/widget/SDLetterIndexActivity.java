package com.siberiadante.utilsample.activity.widget;

import android.os.Bundle;
import android.widget.TextView;

import com.siberiadante.androidutil.widget.special.SDLetterIndexView;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;

public class SDLetterIndexActivity extends BaseActivity {

    @BindView(R.id.sd_letter_index)
    SDLetterIndexView sdLetterIndex;
    @BindView(R.id.tv_letter)
    TextView tvLetter;


    @Override
    public int setLayoutId() {
        return R.layout.activity_sdletter_index;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        sdLetterIndex.setOnLetterTouchListener(new SDLetterIndexView.OnLetterTouchListener() {
            @Override
            public void onTouchIndex(String letter, boolean isShow) {
                tvLetter.setText(letter);
            }
        });
    }
}
