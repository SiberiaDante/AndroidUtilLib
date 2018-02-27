package com.siberiadante.utilsample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.adapter.MainAdapter;
import com.siberiadante.utilsample.bean.MainData;
import com.siberiadante.utilsample.fragment.base.BaseFragment;

import butterknife.BindView;


/**
 * Created: SiberiaDante
 * Describe：
 * CreateTime: 2017/12/22
 * UpDateTime:
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * Blog: http://www.cnblogs.com/shen-hua/
 */

public class SDUtilFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    public static SDUtilFragment getInstance() {
        return new SDUtilFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViews(View view, @Nullable Bundle savedInstanceState) {
        recyclerView.setLayoutManager(new GridLayoutManager(mActivity,2));
        recyclerView.setAdapter(new MainAdapter(MainData.getUtilData(),mActivity));
    }

    @Override
    protected void initData() {

    }

}
