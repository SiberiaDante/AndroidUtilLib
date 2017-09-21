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
import com.sample.bean.UtilData;
import com.sample.ui.activity.util.ActivityUtilActivity;
import com.sample.ui.activity.util.AppActivity;
import com.sample.ui.activity.util.ClearActivity;
import com.sample.ui.activity.util.DateUtilActivity;
import com.sample.ui.activity.util.LogUtilActivity;
import com.sample.ui.activity.util.NetworkActivity;
import com.sample.ui.activity.util.NumberActivity;
import com.sample.ui.activity.util.PermissionManagerActivity;
import com.sample.ui.activity.util.SDCardUtilActivity;
import com.sample.ui.activity.util.ScreenActivity;
import com.sample.ui.activity.util.ToastActivity;
import com.sample.util.JumpUtils;
import com.siberiadante.lib.util.SDLogUtil;
import com.siberiadante.lib.util.SDTransitionUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/14
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class UtilFragment extends LazyFragment implements RecyclerArrayAdapter.OnItemClickListener {
    private static String TAG = UtilFragment.class.getSimpleName();
    private EasyRecyclerView mRecyclerView;
    private List<UtilData> datas;
    private CustomAdapter adapter;
    private static FloatingActionButton mTop;

    public static UtilFragment getInstance(View view) {
        mTop = (FloatingActionButton) view;
        return new UtilFragment();
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_util);
        SDLogUtil.d("-------------UtilFragment----------------");
        initView();
        initData();
    }

    protected void initView() {
        mRecyclerView = ((EasyRecyclerView) findViewById(R.id.recyclerView_util));
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
        datas = new ArrayList<>();
        datas.add(new UtilData("测试ActivityUtil类", ActivityUtilActivity.class.getName()));
        datas.add(new UtilData("测试AppUtil类", AppActivity.class.getName()));
        datas.add(new UtilData("测试ClearUtil类", ClearActivity.class.getName()));
        datas.add(new UtilData("测试DataUtil类", DateUtilActivity.class.getName()));
        datas.add(new UtilData("测试LogUtil类", LogUtilActivity.class.getName()));
        datas.add(new UtilData("测试NetworkUtil类", NetworkActivity.class.getName()));
        datas.add(new UtilData("测试NumberUtil类", NumberActivity.class.getName()));
        datas.add(new UtilData("测试PermissionManagerUtil类", PermissionManagerActivity.class.getName()));
        datas.add(new UtilData("测试ScreenUtil类", ScreenActivity.class.getName()));
        datas.add(new UtilData("测试SDCardUtil类", SDCardUtilActivity.class.getName()));
        datas.add(new UtilData("测试ToastUtil类", ToastActivity.class.getName()));
        adapter.addAll(datas);
    }

    @Override
    public void onItemClick(int position) {
        startUtilActivity(position);
    }

    private void startUtilActivity(int position) {
        JumpUtils.startJumpActivity(datas.get(position).getCls());
    }

}
