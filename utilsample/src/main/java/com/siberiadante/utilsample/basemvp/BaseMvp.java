package com.siberiadante.utilsample.basemvp;

/**
 * create date: 2018/11/13
 */
public interface BaseMvp<M extends BaseModel, V extends BaseView, P extends BasePresenter> {

    M createModel();

    V createView();

    P createPresenter();
}
