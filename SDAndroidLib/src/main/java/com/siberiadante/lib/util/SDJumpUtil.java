package com.siberiadante.lib.util;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/10/26
 * @UpDateTime:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDJumpUtil {
    /**
     * open setting
     *
     * @param activity
     */
    public static void openSetting(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        activity.startActivity(intent);
    }
}
