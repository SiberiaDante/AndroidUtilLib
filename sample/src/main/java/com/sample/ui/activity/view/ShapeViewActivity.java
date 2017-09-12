package com.sample.ui.activity.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.LogUtil;
import com.siberiadante.lib.view.TitleBarLayout;

public class ShapeViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_view);
        final TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.title_layout);
        titleBarLayout.setTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.d("title 倍点击了");
            }
        });
    }
}
