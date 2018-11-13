package com.siberiadante.utilsample.basemvp;

/**
 * create date: 2018/11/13
 */
public interface Presenter<M extends BaseModel, V extends BaseView> {
    //register model
    void registerModel(M model);

    //register view
    void registerView(V view);

    //get view
    V getView();

    void destroy();
}
