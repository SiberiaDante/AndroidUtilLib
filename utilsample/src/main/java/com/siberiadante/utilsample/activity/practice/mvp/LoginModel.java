package com.siberiadante.utilsample.activity.practice.mvp;


import com.siberiadante.utilsample.basemvp.BaseModel;

import io.reactivex.Observable;

/**
 * create date: 2018/11/13
 */
public interface LoginModel extends BaseModel {

    Observable<LoginBean> doLogin();
}
