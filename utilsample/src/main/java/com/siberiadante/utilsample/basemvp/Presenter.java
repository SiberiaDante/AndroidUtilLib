package com.siberiadante.utilsample.basemvp;

/**
 * create date: 2018/11/13
 */
public interface Presenter<M extends BaseModel, V extends BaseView> {
    void registerModel(M model);

    void registerView(V view);

    V getView();

    void destroy();
}
