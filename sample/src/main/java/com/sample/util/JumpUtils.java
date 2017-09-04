package com.sample.util;

import android.app.Activity;
import android.content.Intent;

import com.sample.ui.activity.view.DialogActivity;
import com.sample.ui.activity.view.ImageSpanActivity;
import com.sample.ui.activity.view.QQStepViewActivity;
import com.sample.ui.activity.view.ShapeViewActivity;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/4
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class JumpUtils {

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
}
