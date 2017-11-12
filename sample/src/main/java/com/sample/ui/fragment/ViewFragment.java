package com.sample.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.sample.R;
import com.sample.adapter.CustomAdapter;
import com.sample.bean.Data;
import com.sample.constants.Constants;
import com.siberiadante.lib.util.SDActivityUtil;
import com.siberiadante.lib.util.SDLogUtil;
import com.siberiadante.lib.util.SDTransitionUtil;

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
    private List<Data> datas;
    private CustomAdapter adapter;
    private static FloatingActionButton mTop;

    public static ViewFragment getInstance(View view) {
        mTop = ((FloatingActionButton) view);
        return new ViewFragment();
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_view);
        SDLogUtil.d("-------------ViewFragment----------------");
        initView();
        initData();
    }

    protected void initView() {
        mRecyclerView = ((EasyRecyclerView) findViewById(R.id.erv_view));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, SDTransitionUtil.dip2px(1f), 0, 0);
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
        adapter.addAll(Constants.getViewData());
    }

    @Override
    public void onItemClick(int position) {
        SDActivityUtil.startActivity(Constants.getViewData().get(position).getCls());
    }
}
