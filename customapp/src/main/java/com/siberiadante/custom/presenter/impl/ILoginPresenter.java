package com.siberiadante.custom.presenter.impl;

import com.siberiadante.custom.bean.LoginResponse;
import com.siberiadante.custom.bean.base.WrapResult;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/17
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public interface ILoginPresenter {
    void startLogin(String usn, String psd);

    void showoSuccess(WrapResult<LoginResponse> result);

    void showFailde(String msg);
}
