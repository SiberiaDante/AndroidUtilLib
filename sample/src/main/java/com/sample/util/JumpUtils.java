package com.sample.util;

import android.content.Intent;
import android.net.Uri;

import com.sample.SampleApplication;
import com.siberiadante.lib.util.SDActivityUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/4
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class JumpUtils {

    /**
     * 启动一个Activity
     *
     * @param activityName
     */
    public static void startJumpActivity(String activityName) {
        SDActivityUtil.launchActivity("com.sample", activityName);
    }

    /**
     * 通过浏览器打开一个链接
     *
     * @param url
     */
    public static void startJumpBrowser(String url) {
        SampleApplication.getInstance().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

}
