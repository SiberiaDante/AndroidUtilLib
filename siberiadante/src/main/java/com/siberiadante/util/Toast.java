package com.siberiadante.util;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siberiadante.Application;

/**
 * Created by SiberiaDante on 2017/5/4.
 * 调用：Toast.toast("哈哈哈")
 */

public class Toast {
    private static android.widget.Toast toast;
    public static void init(Context context) {
//        toast=new Toast(context);
        toast = android.widget.Toast.makeText(context, "", android.widget.Toast.LENGTH_SHORT);
    }

    /**
     * 1
     * 单例模式
     *
     * @param content
     */
    public static void toast(String content) {
        toast.setText(content);
        toast.setDuration(android.widget.Toast.LENGTH_SHORT);
        toast.show();
    }

//    /**
//     * 2
//     *
//     * @param content
//     */
//    public static void showToast(String content) {
//        if (toast == null) {
//            toast = android.widget.Toast.makeText(Application.getInstance(), content, android.widget.Toast.LENGTH_LONG);
//        } else {
//            toast.setText(content);
//        }
//        toast.show();
//    }
}
