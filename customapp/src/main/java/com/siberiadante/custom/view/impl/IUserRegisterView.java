package com.siberiadante.custom.view.impl;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/17
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public interface IUserRegisterView {

    void showDialog(boolean isNeedShow);

    void registerSuccess(String result);

    void registerFail(int errorCode);


}
