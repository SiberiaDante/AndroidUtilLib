package com.siberiadante.custom.view.impl;

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

public interface ILoginView {
    void showDialog(boolean isShow);

    void loginSuccess(WrapResult<LoginResponse> result);

    void loginFailed(String msg);

}
