package com.siberiadante.custom.model;

import com.siberiadante.custom.bean.LoginResponse;
import com.siberiadante.custom.bean.base.WrapResult;
import com.siberiadante.custom.http.ApiService;
import com.siberiadante.custom.http.RetrofitManager;
import com.siberiadante.custom.model.impl.ILoginModel;
import com.siberiadante.custom.presenter.impl.ILoginPresenter;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/17
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class LoginModel implements ILoginModel {
    private ILoginPresenter iLoginPresenter;

    public LoginModel(ILoginPresenter iLoginPresenter) {
        this.iLoginPresenter = iLoginPresenter;
    }

    @Override
    public void login(String username, String psd) {
        final HashMap<String, String> map = new HashMap<>();
        final WrapResult<LoginResponse> loginResponseWrapResult = null;
        RetrofitManager.getInstance().createReq(ApiService.class)
                .getLoginApi(map)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WrapResult<LoginResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull WrapResult<LoginResponse> loginResponseWrapResult) {
                        iLoginPresenter.showoSuccess(loginResponseWrapResult);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        iLoginPresenter.showFailde(loginResponseWrapResult.getInfo());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
