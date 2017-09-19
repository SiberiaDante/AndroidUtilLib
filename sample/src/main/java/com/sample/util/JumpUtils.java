package com.sample.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;

import com.sample.SampleApplication;
import com.sample.constants.Constants;
import com.sample.ui.activity.util.PermissionManagerActivity;
import com.sample.ui.activity.util.ScreenActivity;
import com.sample.ui.activity.view.DialogActivity;
import com.sample.ui.activity.view.ImageSpanActivity;
import com.sample.ui.activity.view.KeyBoardActivity;
import com.sample.ui.activity.view.QQStepViewActivity;
import com.sample.ui.activity.view.ShapeViewActivity;
import com.siberiadante.lib.util.ActivityUtil;

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
        ActivityUtil.launchActivity("com.sample", activityName);
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
