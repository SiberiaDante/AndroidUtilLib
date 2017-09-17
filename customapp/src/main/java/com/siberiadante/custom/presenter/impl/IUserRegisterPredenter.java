package com.siberiadante.custom.presenter.impl;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/17
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public interface IUserRegisterPredenter {

    void startRegister();

    void registerSuccess(String result);

    void registerFail(int errorCode);
}
