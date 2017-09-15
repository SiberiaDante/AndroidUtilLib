package com.sample.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.sample.R;
import com.sample.adapter.CustomAdapter;
import com.sample.bean.UtilData;
import com.sample.ui.BaseFragmentN;
import com.sample.ui.activity.WebVideoActivity;
import com.sample.ui.activity.view.DialogActivity;
import com.sample.ui.activity.view.ImageSpanActivity;
import com.sample.ui.activity.view.KeyBoardActivity;
import com.sample.ui.activity.view.QQStepViewActivity;
import com.sample.ui.activity.view.ShapeViewActivity;
import com.siberiadante.lib.util.ActivityUtil;
import com.siberiadante.lib.util.LogUtil;
import com.siberiadante.lib.util.TransitionTools;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/6/30
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class ViewFragment extends LazyFragment implements RecyclerArrayAdapter.OnItemClickListener {
    public static final String TAG = ViewFragment.class.getSimpleName();
    private EasyRecyclerView mRecyclerView;
    private List<UtilData> datas;
    private CustomAdapter adapter;
    private FloatingActionButton mTop;

    public static ViewFragment getInstance() {
        return new ViewFragment();
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_view);
        LogUtil.d("-------------ViewFragment----------------");

        initView();
        initData();
    }

    protected void initView() {
        mTop = ((FloatingActionButton) findViewById(R.id.fab_view_top));
        mRecyclerView = ((EasyRecyclerView) findViewById(R.id.erv_view));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, TransitionTools.dip2px(1f), 0, 0);
        itemDecoration.setDrawHeaderFooter(false);
        mRecyclerView.addItemDecoration(itemDecoration);
        adapter = new CustomAdapter(getActivity());
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

        mTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecyclerView.scrollToPosition(0);
            }
        });
    }


    protected void initData() {
        datas = new ArrayList<>();
        datas.add(new UtilData("各种Dialog", DialogActivity.class.getName()));
        datas.add(new UtilData("测试文字表情混排对齐", ImageSpanActivity.class.getName()));
        datas.add(new UtilData("Shape封装的View测试", ShapeViewActivity.class.getName()));
        datas.add(new UtilData("点击View切换软件盘测试", KeyBoardActivity.class.getName()));
        datas.add(new UtilData("QQ运动计步器View", QQStepViewActivity.class.getName()));
        datas.add(new UtilData("WebVideoActivity", WebVideoActivity.class.getName()));
        adapter.addAll(datas);
    }

    @Override
    public void onItemClick(int position) {
        ActivityUtil.launchActivity("com.sample", datas.get(position).getCls());
    }
}
