package com.siberiadante.utilsample.activity.view;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.siberiadante.androidutil.util.SDTransitionUtil;
import com.siberiadante.androidutil.view.decoration.LinearItemDecoration;
import com.siberiadante.androidutil.view.decoration.SDNormalDecoration;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

public class SDDecorationActivity extends BaseActivity {

    @Override
    public int setLayoutId() {
        return R.layout.activity_sddecoration;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        RecyclerView recyclerView = new RecyclerView(this);
        SDNormalDecoration sdNormalDecoration = new SDNormalDecoration(ContextCompat.getColor(this, R.color.colorAccent), SDTransitionUtil.dip2px(1));
        SDNormalDecoration sdNormalDecoration1 = new SDNormalDecoration(ContextCompat.getColor(this, R.color.colorAccent),
                SDTransitionUtil.dip2px(16), SDTransitionUtil.dip2px(1));
        SDNormalDecoration sdNormalDecoration2 = new SDNormalDecoration(ContextCompat.getColor(this, R.color.colorAccent),
                SDTransitionUtil.dip2px(16), SDTransitionUtil.dip2px(16), SDTransitionUtil.dip2px(1));


        LinearItemDecoration linearItemDecoration = new LinearItemDecoration.Builder(this)
                .colorRes(R.color.colorAccent)
                .marginLeft(SDTransitionUtil.dip2px(10))
                .marginRight(SDTransitionUtil.dip2px(10))
                .drawHeader(false)
                .drawFooter(false)
                .dividerHeight(SDTransitionUtil.dip2px(1))
                .build();
    }
}
