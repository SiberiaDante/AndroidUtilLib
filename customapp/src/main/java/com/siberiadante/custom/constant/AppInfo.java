package com.siberiadante.custom.constant;

import com.siberiadante.util.SPUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/8
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class AppInfo {
    private SPUtil spUtil;

    private AppInfo() {
        spUtil = new SPUtil(Constants.INFO);
    }

    public static AppInfo getInstance() {
        return AppInfoHolder.appInfo;
    }

    public SPUtil getSpUtil() {
        return spUtil;
    }

    private static class AppInfoHolder {
        private static final AppInfo appInfo = new AppInfo();
    }

    public boolean isDebug() {
        return spUtil.getBoolean("is_debug");
    }
}
