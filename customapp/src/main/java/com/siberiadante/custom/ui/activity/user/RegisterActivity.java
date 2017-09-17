package com.siberiadante.custom.ui.activity.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.siberiadante.custom.R;
import com.siberiadante.custom.presenter.UserRegisterPresenter;
import com.siberiadante.custom.presenter.impl.IUserRegisterPredenter;
import com.siberiadante.custom.view.impl.IUserRegisterView;

public class RegisterActivity extends AppCompatActivity implements IUserRegisterView {

    private IUserRegisterPredenter iUserRegisterPredenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        iUserRegisterPredenter = new UserRegisterPresenter(this);
    }

    public void onStartRegister() {
        iUserRegisterPredenter.startRegister();
    }

    @Override
    public void showDialog(boolean isNeedShow) {

    }

    @Override
    public void registerSuccess(String result) {

    }

    @Override
    public void registerFail(int errorCode) {

    }
}
