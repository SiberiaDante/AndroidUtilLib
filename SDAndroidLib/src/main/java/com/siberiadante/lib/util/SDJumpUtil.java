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
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDJumpUtil {
    public static final String SETTINGS_ACTION = "android.settings.APPLICATION_DETAILS_SETTINGS";

    /**
     * open setting
     */
    public static void openSetting() {
        Intent intent = new Intent()
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setAction(Settings.ACTION_SETTINGS);
        SDAndroidLib.getContext().startActivity(intent);
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

    /**
     * email
     */
    public static void openEmail() {
        Intent intent = new Intent()
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setAction(Intent.ACTION_SENDTO);
        SDAndroidLib.getContext().startActivity(intent);
    }

    /**
     * @param email email
     */

    public static void openEmail(String email) {
        Uri uri = Uri.parse("mailto:" + email);
        Intent intent = new Intent()
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setAction(Intent.ACTION_SENDTO)
                .setData(uri);
        SDAndroidLib.getContext().startActivity(intent);
    }

}
