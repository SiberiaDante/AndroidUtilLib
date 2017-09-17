package com.siberiadante.custom.model;

import com.siberiadante.custom.model.impl.IUserRegisterModel;
import com.siberiadante.custom.presenter.impl.IUserRegisterPredenter;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/17
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class UserRegisterModel implements IUserRegisterModel {
    private IUserRegisterPredenter iUserRegisterPredenter;

    public UserRegisterModel(IUserRegisterPredenter iUserRegisterPredenter) {
        this.iUserRegisterPredenter = iUserRegisterPredenter;
    }

    @Override
    public void startRegister() {
        //开始发起注册代码
    }
}
