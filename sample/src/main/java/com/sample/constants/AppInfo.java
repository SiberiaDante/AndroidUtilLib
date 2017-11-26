package com.sample.constants;

import com.siberiadante.lib.util.SDSPUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/3
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class AppInfo {
    private SDSPUtil SDSPUtil;

    /**
     * 初始化SPUtil
     */
    private AppInfo() {
        SDSPUtil = new SDSPUtil(Constants.APP_INFO);
    }

    public static AppInfo getInstance() {
        return new AppInfo();
    }

    private SDSPUtil getSDSPUtil() {
        return SDSPUtil;
    }

    /**
     * 判断用户是否登录
     *
     * @return
     */
    public boolean isLogin() {
        return SDSPUtil.getBoolean("is_login");
    }

    /**
     * 设置用户登录状态
     *
     * @param isLogin
     */
    public void setLogin(boolean isLogin) {
        this.SDSPUtil.put("is_login", isLogin);
        final SDSPUtil SDSPUtil = AppInfo.getInstance().getSDSPUtil();
        SDSPUtil.put("is_login", true);
    }

    /**
     * 是否第一次使用app,默认true
     */
    public boolean isFirstInstall() {
        return SDSPUtil.getBoolean("is_first_install", true);
    }

    public void setIsFirstInstall(boolean bool) {
        SDSPUtil.put("is_first_install", bool);
    }

    /**
     * 退出登录
     */
    public void loginOut() {
        SDSPUtil.clear();
        SDSPUtil.put("is_first_install", false);
    }
}
