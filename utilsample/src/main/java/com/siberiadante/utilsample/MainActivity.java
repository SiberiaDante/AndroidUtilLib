package com.siberiadante.utilsample;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.siberiadante.utilsample.activity.base.BaseActivity;
import com.siberiadante.utilsample.adapter.MainAdapter;
import com.siberiadante.utilsample.bean.MainData;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(new MainAdapter(MainData.getData(),this));

    }

}
