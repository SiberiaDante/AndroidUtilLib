package com.siberiadante.lib.constants;

import com.siberiadante.lib.util.SDSPUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/7
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDAppInfo {
    private SDSPUtil info;

    private SDAppInfo() {
        info = new SDSPUtil(SDConstants.INFO);
    }

    public static SDAppInfo getInstance() {
        return AppInfoHolder.appInfo;
    }

    public SDSPUtil getSPUtils() {
        return info;
    }

    private static class AppInfoHolder {
        private static final SDAppInfo appInfo = new SDAppInfo();
    }

    public boolean isDebug() {
        return info.getBoolean("is_debug");
    }
}
