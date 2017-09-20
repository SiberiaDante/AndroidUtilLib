package com.sample.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.sample.R;
import com.sample.adapter.CustomAdapter;
import com.sample.adapter.MainFragmentAdapter;
import com.sample.bean.MainData;
import com.sample.bean.UtilData;
import com.sample.constants.Constants;
import com.sample.ui.BaseFragmentN;
import com.sample.ui.activity.WebViewActivity;
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
import com.siberiadante.lib.util.ScreenUtil;
import com.siberiadante.lib.util.TransitionTools;
import com.squareup.haha.perflib.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/7/19
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class MainFragment extends LazyFragment implements RecyclerArrayAdapter.OnItemClickListener {
    private Button mBtnLib, mBtnTitleLayout, mBtnRXJava;
    private EasyRecyclerView mRecyclerView;
    private List<MainData> datas;
    private MainFragmentAdapter adapter;

    public static MainFragment getInstance(View view) {
        return new MainFragment();
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_main);
        initView();
        initData();
    }

    protected void initView() {
        mRecyclerView = ((EasyRecyclerView) findViewById(R.id.recyclerView_main));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, TransitionTools.dip2px(1f), 0, 0);
        itemDecoration.setDrawHeaderFooter(false);
        mRecyclerView.addItemDecoration(itemDecoration);
        adapter = new MainFragmentAdapter(getActivity());
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    private void initData() {
        datas = new ArrayList<>();
        datas.add(new MainData("Android开发常备工具库", Constants.URL_SIBERIA_DANTE_LIB));
        datas.add(new MainData("Android万能通用标题栏封装", Constants.URL_TITLE_LAYOUT));
        datas.add(new MainData("CustomDialog——一个多功能、通用、可自定义的Dialog", Constants.URL_CUSTOM_DIALOG));
        adapter.addAll(datas);
    }


    @Override
    public void onItemClick(int position) {
        startBrowser(datas.get(position).getUrl());
    }

    public void startBrowser(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }
}
