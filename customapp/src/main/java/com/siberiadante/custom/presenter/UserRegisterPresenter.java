package com.siberiadante.custom.presenter;

import com.siberiadante.custom.model.UserRegisterModel;
import com.siberiadante.custom.model.impl.IUserRegisterModel;
import com.siberiadante.custom.presenter.impl.IUserRegisterPredenter;
import com.siberiadante.custom.view.impl.IUserRegisterView;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/17
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class UserRegisterPresenter implements IUserRegisterPredenter {
    private IUserRegisterView iUserRegisterView;
    private IUserRegisterModel iUserRegisterModel;

    public UserRegisterPresenter(IUserRegisterView iUserRegisterView) {
        this.iUserRegisterView = iUserRegisterView;
        this.iUserRegisterModel = new UserRegisterModel(this);
    }

    @Override
    public void startRegister() {
        iUserRegisterView.showDialog(true);
        iUserRegisterModel.startRegister();
    }


    @Override
    public void registerSuccess(String result) {
        iUserRegisterView.showDialog(false);
        iUserRegisterView.registerSuccess(result);

    }

    @Override
    public void registerFail(int errorCode) {
        iUserRegisterView.showDialog(false);
        iUserRegisterView.registerFail(errorCode);

    }
}
