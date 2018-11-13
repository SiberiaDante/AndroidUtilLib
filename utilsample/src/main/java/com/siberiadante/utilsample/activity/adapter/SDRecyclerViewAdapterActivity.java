package com.siberiadante.utilsample.activity.adapter;

import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siberiadante.androidutil.adapter.recycleradapter.SDRecyclerViewAdapter;
import com.siberiadante.androidutil.util.SDToastUtil;
import com.siberiadante.androidutil.view.decoration.SDNormalDecoration;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;
import com.siberiadante.utilsample.adapter.widget.SDRVAdapter;
import com.siberiadante.utilsample.bean.document.DocumentData;

import butterknife.BindView;

public class SDRecyclerViewAdapterActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdrecycler_view_adapter;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle("SDRecyclerViewAdapter");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SDNormalDecoration(ContextCompat.getColor(this, R.color.colorGray), 1));

        final SDRVAdapter adapter = new SDRVAdapter(this);
        adapter.addHeader(new SDRecyclerViewAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.list_document_item, null);
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
        adapter.addFooter(new SDRecyclerViewAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.list_document_item, null);
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
        recyclerView.setAdapter(adapter);
        adapter.addAll(DocumentData.getDocumentData(0, 10));

        adapter.setOnItemClickListener(new SDRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                SDToastUtil.toast("单击---------" + adapter.getAllData().get(position).getTitle());
            }
        });
        adapter.setOnItemLongClickListener(new SDRecyclerViewAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(int position) {
                SDToastUtil.toast("长按--------" + adapter.getAllData().get(position).getTitle());
                return false;
            }
        });
    }
}
