package com.sample.util;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

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

    private static Intent intent;

    public static void goToDialogActivity(Activity activity) {
        intent = new Intent(activity, DialogActivity.class);
        activity.startActivity(intent);
    }

    public static void goToQQStepViewActivity(Activity activity) {
        intent = new Intent(activity, QQStepViewActivity.class);
        activity.startActivity(intent);
    }

    public static void goToImageSpanActivity(Activity activity) {
        intent = new Intent(activity, ImageSpanActivity.class);
        activity.startActivity(intent);
    }

    public static void goToShapeViewActivity(Activity activity) {
        intent = new Intent(activity, ShapeViewActivity.class);
        activity.startActivity(intent);
    }

    public static void goToPermissionManagerActivity(Activity activity) {
        intent = new Intent(activity, PermissionManagerActivity.class);
        activity.startActivity(intent);
    }

    public static void goToScreenUtilActivity(Activity activity) {
        intent = new Intent(activity, ScreenActivity.class);
        activity.startActivity(intent);

    }

    public static void goToKeyBoardActivity(Activity activity) {
        intent = new Intent(activity, KeyBoardActivity.class);
        activity.startActivity(intent);

    }
}
