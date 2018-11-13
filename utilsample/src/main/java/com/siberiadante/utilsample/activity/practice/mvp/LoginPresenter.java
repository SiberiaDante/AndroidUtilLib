package com.siberiadante.utilsample.activity.practice.mvp;

import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.utilsample.basemvp.BasePresenter;
import com.siberiadante.utilsample.http.BaseObserver;
import com.siberiadante.utilsample.http.NetException;
import com.siberiadante.utilsample.http.RxSchedulersHelper;

import io.reactivex.disposables.Disposable;

/**
 * create date: 2018/11/13
 */
public class LoginPresenter extends BasePresenter<LoginModel, LoginView> {

    @Override
    protected void onViewDestroy() {
    }

    public void doLoginData() {
        if (getView() != null) getView().showProgress();
        if (model == null) {
            return;
        }
        model.doLogin().compose(RxSchedulersHelper.<LoginBean>compose())
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addCompositeDisposable(d);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        SDLogUtil.d("----------:"+loginBean.getErrorMsg());
                        if (getView() != null) {
                            getView().setData(loginBean.getErrorMsg());
                            getView().hideProgress();
                        }
                    }

                    @Override
                    public void onError(NetException.ResponseThrowable e) {
                        if (getView() != null) getView().hideProgress();
                    }
                });

    }
}
