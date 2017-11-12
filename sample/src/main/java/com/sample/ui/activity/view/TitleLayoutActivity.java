package com.sample.ui.activity.view;

import android.os.Bundle;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.view.titlebar.SDTitleLayout;

public class TitleLayoutActivity extends BaseActivity {

    public int setLayoutId() {
        return R.layout.activity_title_layout;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        final SDTitleLayout titleLayout = (SDTitleLayout) findViewById(R.id.title_layout_three);
        titleLayout.setTitle("Java代码设置标题");
    }

    @Override
    public void initData() {

    }
}
