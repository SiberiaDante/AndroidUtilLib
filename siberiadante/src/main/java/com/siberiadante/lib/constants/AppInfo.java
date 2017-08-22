package com.siberiadante.lib.constants;

import com.siberiadante.lib.util.SPUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/7
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class AppInfo {
    private SPUtil info;

    private AppInfo() {
        info = new SPUtil(Constants.INFO);
    }

    public static AppInfo getInstance() {
        return AppInfoHolder.appInfo;
    }

    public SPUtil getSPUtils() {
        return info;
    }

    private static class AppInfoHolder {
        private static final AppInfo appInfo = new AppInfo();
    }

    public boolean isDebug() {
        return info.getBoolean("is_debug");
    }
}
