package com.siberiadante.utilsample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.siberiadante.androidutil.view.decoration.SDNormalDecoration;
import com.siberiadante.androidutil.widget.recyclerview.SDOnScrollListener;
import com.siberiadante.androidutil.widget.recyclerview.SDRecyclerView;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.adapter.DocumentAdapter;
import com.siberiadante.utilsample.bean.document.DocumentData;
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

public class DocumentFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    SDRecyclerView recyclerView;
    private int page = 0;

    public static DocumentFragment getInstance() {
        return new DocumentFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_document;
    }

    @Override
    protected void initViews(View view, @Nullable Bundle savedInstanceState) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SDNormalDecoration(ContextCompat.getColor(mActivity, R.color.colorGray), 1));
        final DocumentAdapter adapter = new DocumentAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setDocumentLists(DocumentData.getDocumentData(0, 10));
        recyclerView.setOnScrollListener(new SDOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                adapter.addDocumentLists(DocumentData.getDocumentData(++page, 10));
            }
        });



//        recyclerView.setOnScrollListener(new SDOnScrollListener(layoutManager) {
//            @Override
//            public void onLoadMore(int current_page) {
//                adapter.addAll(DocumentData.getDocumentData(++page, 10));
//            }
//        });
    }

    @Override
    protected void initData() {

    }
}
