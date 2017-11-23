package com.siberiadante.lib.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import com.siberiadante.lib.SDAndroidLib;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/10/26
 * @UpDateTime:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDJumpUtil {
    public static final String SETTINGS_ACTION = "android.settings.APPLICATION_DETAILS_SETTINGS";

    /**
     * open setting
     *
     * @param activity
     */
    public static void openSetting(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        activity.startActivity(intent);
    }

    /**
     * open app details setting
     */
    public static void openAppSetting() {
        Intent intent = new Intent()
                .setAction(SETTINGS_ACTION)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setData(Uri.fromParts("package", SDAndroidLib.getContext().getPackageName(), null));
        SDAndroidLib.getContext().startActivity(intent);
    }
}
