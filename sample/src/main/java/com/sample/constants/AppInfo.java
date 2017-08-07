package com.sample.constants;

import com.siberiadante.util.SPUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/3
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class AppInfo {
    private SPUtil spUtil;

    /**
     * 初始化SPUtil
     */
    private AppInfo() {
        spUtil = new SPUtil(Constants.APP_INFO);
    }

    public static AppInfo getInstance() {
        return new AppInfo();
    }

    private SPUtil getSpUtil() {
        return spUtil;
    }

    /**
     * 判断用户是否登录
     *
     * @return
     */
    public boolean isLogin() {
        return spUtil.getBoolean("is_login");
    }

    /**
     * 设置用户登录状态
     *
     * @param isLogin
     */
    public void setLogin(boolean isLogin) {
        spUtil.put("is_login", isLogin);
        final SPUtil spUtil = AppInfo.getInstance().getSpUtil();
        spUtil.put("is_login", true);
    }

    /**
     * 是否第一次使用app,默认true
     */
    public boolean isFirstInstall() {
        return spUtil.getBoolean("is_first_install", true);
    }

    public void setIsFirstInstall(boolean bool) {
        spUtil.put("is_first_install", bool);
    }

    /**
     * 退出登录
     */
    public void loginOut() {
        spUtil.clear();
        spUtil.put("is_first_install", false);
    }
}
