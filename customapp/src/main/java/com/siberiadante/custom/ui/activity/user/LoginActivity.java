package com.siberiadante.custom.ui.activity.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.siberiadante.custom.R;
import com.siberiadante.custom.bean.LoginResponse;
import com.siberiadante.custom.bean.base.WrapResult;
import com.siberiadante.custom.presenter.LoginPresenter;
import com.siberiadante.custom.view.impl.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenter(this);
    }

    public void startLogin() {
        loginPresenter.startLogin("", "");
    }


    @Override
    public void showDialog(boolean isShow) {
        if (isShow) {

        } else {

        }

    }

    @Override
    public void loginSuccess(WrapResult<LoginResponse> result) {

    }


    @Override
    public void loginFailed(String msg) {

    }
}
