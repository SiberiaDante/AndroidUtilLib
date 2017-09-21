package com.sample.ui.activity.view;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.LogUtil;
import com.siberiadante.lib.view.SDTitleLayout;

public class ShapeViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_view);
        SDTitleLayout titleBarLayout = (SDTitleLayout) findViewById(R.id.title_layout);
        titleBarLayout.setTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.d("title 被点击了");
            }
        });
        //设置Titlesize
        titleBarLayout.setTitleSize(30);
        //一键设置标题样式
        titleBarLayout.setTitleStyle("我是标题", 18, ContextCompat.getColor(this, R.color.action_sheet_blue));
        titleBarLayout.setRightImageClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.d("右边图片被点击了");
            }
        });
        titleBarLayout.setIsImmersiveStateBar(true);
    }
}
