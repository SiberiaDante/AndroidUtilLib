package com.siberiadante.custom.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.siberiadante.custom.R;
import com.siberiadante.custom.bean.NewsData;
import com.siberiadante.custom.bean.base.WrapResult;
import com.siberiadante.custom.constant.Constants;
import com.siberiadante.custom.http.ApiService;
import com.siberiadante.custom.http.Request;
import com.siberiadante.custom.http.RetrofitManager;
import com.siberiadante.custom.ui.adapter.NewsAdapter;
import com.siberiadante.lib.util.LogUtil;
import com.siberiadante.lib.util.ToastUtil;
import com.siberiadante.lib.view.TitleBar;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/8
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class TwoFragment extends LazyFragment {
    public static final String TAG = TwoFragment.class.getSimpleName();
    private int mPage = 1;
    TitleBar mTitleBar;
    private LinearLayout mLLProgress;
    private NewsAdapter adapter;
    private RecyclerView recyclerView;

    public static TwoFragment getInstance() {
        return new TwoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: 1");
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        Log.d(TAG, "onCreateViewLazy: 2");
        setContentView(R.layout.fragment_two);
        ToastUtil.toast("第二个页面");
        Log.d(TAG, "onCreateViewLazy: FragmentTwo");
        initView();
        initIntent();
        initData();
    }

    private void initView() {
        mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        mLLProgress = ((LinearLayout) findViewById(R.id.ll_progress_bar));
        mTitleBar.setTitle("SiberiaDante-ZCL");
        mTitleBar.setRightImage(R.mipmap.ic_recommend_default);

        recyclerView = (RecyclerView) findViewById(R.id.rv_fragment_two);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NewsAdapter(getActivity(), null);
        recyclerView.setAdapter(adapter);
    }

    private void initIntent() {
        getNewsData(mPage);
    }

    private void getNewsData(int mPage) {

        Request.getInstance().getNewsData(1, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WrapResult<List<NewsData>>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull WrapResult<List<NewsData>> listWrapResult) {
                        LogUtil.d(TAG, listWrapResult.getInfo());

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        LogUtil.d(TAG, e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

//        RetrofitManager.getInstance().createReq(ApiService.class)
//                .newsApi(Constants.ACCESS_TOKEN, Constants.METHOD_GET, String.valueOf(mPage), "100")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<WrapResult<List<NewsData>>>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        LogUtil.d(TAG, "onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(@NonNull WrapResult<List<NewsData>> listWrapResult) {
//                        LogUtil.d(TAG, "onNext: ");
//                        adapter.addRes(listWrapResult.getData());
////                        adapter = new NewsAdapter(getActivity(), listWrapResult.getData());
////                        recyclerView.setAdapter(adapter);
//
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        LogUtil.d(TAG, "onError");
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        LogUtil.d(TAG, "onComplete");
//                        mLLProgress.setVisibility(View.GONE);
//                    }
//                });
    }

    private void initData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
