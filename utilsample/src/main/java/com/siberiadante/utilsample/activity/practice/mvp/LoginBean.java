package com.siberiadante.utilsample.activity.practice.mvp;

/**
 * create date: 2018/11/13
 */
public class LoginBean {
    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg == null ? "" : errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
