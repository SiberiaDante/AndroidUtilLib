package com.siberiadante.custom.presenter;

import com.siberiadante.custom.bean.LoginResponse;
import com.siberiadante.custom.bean.base.WrapResult;
import com.siberiadante.custom.model.LoginModel;
import com.siberiadante.custom.model.impl.ILoginModel;
import com.siberiadante.custom.presenter.impl.ILoginPresenter;
import com.siberiadante.custom.view.impl.ILoginView;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/17
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class LoginPresenter implements ILoginPresenter {

    private ILoginView iLoginView;

    private ILoginModel iLoginModel;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        this.iLoginModel = new LoginModel(this);
    }

    @Override
    public void startLogin(String usn, String psd) {
        iLoginView.showDialog(true);
        iLoginModel.login(usn, psd);
    }

    @Override
    public void showoSuccess(WrapResult<LoginResponse> result) {
        iLoginView.showDialog(false);
        iLoginView.loginSuccess(result);

    }

    @Override
    public void showFailde(String msg) {
        iLoginView.loginFailed(msg);

    }
}
