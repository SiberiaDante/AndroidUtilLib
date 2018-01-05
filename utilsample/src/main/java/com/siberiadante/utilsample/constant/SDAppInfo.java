package com.siberiadante.utilsample.constant;

import com.siberiadante.androidutil.util.SDSPUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2018/1/5
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */

public class SDAppInfo {
    private SDSPUtil sdspUtil;

    private SDAppInfo() {
        sdspUtil = new SDSPUtil(Constants.COMMON_APP_INFO);
    }

    public static SDAppInfo getInstance() {
        return AppInfoHolder.appInfo;
    }


    private static class AppInfoHolder {
        private static final SDAppInfo appInfo = new SDAppInfo();
    }

    public boolean isLogin() {
        return sdspUtil.getBoolean("is_login", false);
    }

    public void setIsLogin(boolean isLogin) {
        sdspUtil.put("is_login", isLogin);
    }

    public boolean getBoolean() {
        return sdspUtil.getBoolean("booleanValue", false);
    }

    public void setBoolean(boolean booleanValue) {
        sdspUtil.put("booleanValue", booleanValue);
    }

    public void setNumber(int number) {
        sdspUtil.put("number", number);
    }

    public int getNumber() {
        return sdspUtil.getInt("number");
    }

    public void setText(String inputContent) {
        sdspUtil.put("inputContent", inputContent);
    }

    public String getText() {
        return sdspUtil.getString("inputContent");
    }
}
