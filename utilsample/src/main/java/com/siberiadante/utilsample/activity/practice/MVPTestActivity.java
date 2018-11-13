package com.siberiadante.utilsample.activity.practice;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseMvpActivity;
import com.siberiadante.utilsample.activity.practice.mvp.LoginModel;
import com.siberiadante.utilsample.activity.practice.mvp.LoginModelImpl;
import com.siberiadante.utilsample.activity.practice.mvp.LoginPresenter;
import com.siberiadante.utilsample.activity.practice.mvp.LoginView;

import butterknife.BindView;

public class MVPTestActivity extends BaseMvpActivity<LoginModel, LoginView, LoginPresenter> implements LoginView {

    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    public int setLayoutId() {
        return R.layout.activity_mvptest;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public LoginModel createModel() {
        return new LoginModelImpl();
    }

    @Override
    public LoginView createView() {
        return this;
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void setData(final String content) {
        tvContent.setText(content);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void doSomePresenterWork() {
        if (presenter != null) {
            presenter.doLoginData();
        }
    }
}
