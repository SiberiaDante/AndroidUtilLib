package com.siberiadante.lib.constants;

import com.siberiadante.lib.util.SDSPUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/7
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class AppInfo {
    private SDSPUtil info;

    private AppInfo() {
        info = new SDSPUtil(SDConstants.INFO);
    }

    public static AppInfo getInstance() {
        return AppInfoHolder.appInfo;
    }

    public SDSPUtil getSPUtils() {
        return info;
    }

    private static class AppInfoHolder {
        private static final AppInfo appInfo = new AppInfo();
    }

    public boolean isDebug() {
        return info.getBoolean("is_debug");
    }
}
