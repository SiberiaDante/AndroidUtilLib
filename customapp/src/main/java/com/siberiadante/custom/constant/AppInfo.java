package com.siberiadante.custom.constant;

import com.siberiadante.lib.util.SDSPUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/8
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class AppInfo {
    private SDSPUtil SDSPUtil;

    private AppInfo() {
        SDSPUtil = new SDSPUtil(Constants.INFO);
    }

    public static AppInfo getInstance() {
        return AppInfoHolder.appInfo;
    }

    public SDSPUtil getSDSPUtil() {
        return SDSPUtil;
    }

    private static class AppInfoHolder {
        private static final AppInfo appInfo = new AppInfo();
    }

    public boolean isDebug() {
        return SDSPUtil.getBoolean("is_debug");
    }
}
