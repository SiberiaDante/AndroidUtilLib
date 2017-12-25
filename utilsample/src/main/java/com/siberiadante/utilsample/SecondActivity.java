package com.siberiadante.utilsample;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends BaseActivity {

    @BindView(R.id.tv_content)
    TextView tvContent;
    private String message;

    @Override
    public void beforeSetContentView() {
        super.beforeSetContentView();
        message = getIntent().getStringExtra("message");
    }

    public int setLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        if (!TextUtils.isEmpty(message)) {
            tvContent.setText(message);
        }
    }

}
