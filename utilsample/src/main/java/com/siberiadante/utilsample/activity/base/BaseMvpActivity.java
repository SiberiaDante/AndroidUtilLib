package com.siberiadante.utilsample.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.utilsample.basemvp.BaseMvp;
import com.siberiadante.utilsample.basemvp.BasePresenter;
import com.siberiadante.utilsample.basemvp.BaseModel;
import com.siberiadante.utilsample.basemvp.BaseView;

/**
 * create date: 2018/11/13
 */
public abstract class BaseMvpActivity<M extends BaseModel, V extends BaseView, P extends BasePresenter> extends BaseActivity implements BaseMvp<M, V, P> {
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        SDLogUtil.d("------------:" + (presenter == null));
        if (presenter != null) {
            presenter.registerModel(createModel());
            presenter.registerView(createView());
        }
        doSomePresenterWork();
    }

    public abstract void doSomePresenterWork();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destroy();
        }
    }
}
