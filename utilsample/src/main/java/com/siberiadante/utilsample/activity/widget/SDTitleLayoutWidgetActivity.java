package com.siberiadante.utilsample.activity.widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.siberiadante.androidutil.util.SDStatusBarUtil;
import com.siberiadante.androidutil.widget.special.SDTitleLayout;
import com.siberiadante.utilsample.R;

public class SDTitleLayoutWidgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdtitle_layout_widget);
        SDStatusBarUtil.setStatusTranslucent(this);
//        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.title_layout_one);
//        titleBarLayout.setTitleClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("MainActivity","title 被点击了");
//            }
//        });
//        //设置Titlesize
//        titleBarLayout.setTitleSize(30);
//        //一键设置标题样式
//        titleBarLayout.setTitleStyle("我是标题", 18, ContextCompat.getColor(this, R.color.colorAccent));
//        titleBarLayout.setRightImageClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("MainActivity","右边图片被点击了");
//            }
//        });
        final SDTitleLayout titleBarLayout2 = (SDTitleLayout) findViewById(R.id.title_layout_two);
        titleBarLayout2.setTitle("Java代码设置新的标题");

        final SDTitleLayout titleBarLayout = (SDTitleLayout) findViewById(R.id.title_layout_four);
        titleBarLayout.setIsLeftBackView(true);
    }
}
