package com.siberiadante.custom.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.siberiadante.custom.R;
import com.siberiadante.custom.bean.LoginResponse;
import com.siberiadante.custom.bean.base.WrapResult;
import com.siberiadante.custom.constant.Constants;
import com.siberiadante.custom.http.ApiService;
import com.siberiadante.custom.http.Request;
import com.siberiadante.custom.http.RetrofitManager;
import com.siberiadante.lib.util.SDLogUtil;
import com.siberiadante.lib.util.SDToastUtil;
import com.siberiadante.lib.view.titlebar.SDTitleBar;

import java.util.HashMap;

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
    SDTitleBar mSDTitleBar;
    private LinearLayout mLLProgress;
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
        SDToastUtil.toast("第二个页面");
        Log.d(TAG, "onCreateViewLazy: FragmentTwo");
        initView();
        initIntent();
        initData();
    }

    private void initView() {
        mSDTitleBar = (SDTitleBar) findViewById(R.id.title_bar);
        mLLProgress = ((LinearLayout) findViewById(R.id.ll_progress_bar));
        mSDTitleBar.setTitle("SiberiaDante-ZCL");
        mSDTitleBar.setRightImage(R.mipmap.ic_recommend_default);
        recyclerView = (RecyclerView) findViewById(R.id.rv_fragment_two);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void initIntent() {
        getLoginTest();
        getLoginTest2();
    }

    private void getLoginTest2() {

        Request.getInstance().getLoginParams("15122835113", "123456")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WrapResult<LoginResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        SDLogUtil.d(TAG, "---------------------onSubscribe-----------------------");
                    }

                    @Override
                    public void onNext(@NonNull WrapResult<LoginResponse> listWrapResult) {
                        SDLogUtil.d(TAG, "onNext:2222222222222222222----------------------- " + listWrapResult.getInfo());
//                        adapter = new NewsAdapter(getActivity(), listWrapResult.getData());
//                        recyclerView.setAdapter(adapter);
                        mLLProgress.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        SDLogUtil.d(TAG, "onError");
                    }

                    @Override
                    public void onComplete() {
                        SDLogUtil.d(TAG, "onComplete");
                        mLLProgress.setVisibility(View.GONE);
                    }
                });
    }
    private void getLoginTest() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("access_token", Constants.ACCESS_TOKEN);
        hashMap.put("method", Constants.METHOD_POST);
        hashMap.put("username", "15122835113");
        hashMap.put("password", "123456");
        hashMap.put("type", "mobile");
        RetrofitManager.getInstance().createReq(ApiService.class)
                .getLoginApi(hashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WrapResult<LoginResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        SDLogUtil.d(TAG, "---------------------onSubscribe-----------------------");
                    }

                    @Override
                    public void onNext(@NonNull WrapResult<LoginResponse> listWrapResult) {
                        SDLogUtil.d(TAG, "onNext:11111111111111111----------------------- " + listWrapResult.getInfo());
//                        adapter = new NewsAdapter(getActivity(), listWrapResult.getData());
//                        recyclerView.setAdapter(adapter);
                        mLLProgress.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        SDLogUtil.d(TAG, "onError");

                    }

                    @Override
                    public void onComplete() {
                        SDLogUtil.d(TAG, "onComplete");
                        mLLProgress.setVisibility(View.GONE);
                    }
                });
    }
    private void initData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
