package com.siberiadante.utilsample.activity.practice.mvp;


import com.siberiadante.utilsample.http.RetrofitManager;

import io.reactivex.Observable;

/**
 * create date: 2018/11/13
 */
public class LoginModelImpl implements LoginModel {
    @Override
    public Observable<LoginBean> doLogin() {
        return RetrofitManager.getApiService().getLoginApi("SiberiaDante","123456");
    }

}
