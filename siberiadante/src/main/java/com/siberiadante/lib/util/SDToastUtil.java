package com.siberiadante.lib.util;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.support.annotation.CheckResult;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.siberiadante.lib.R;
import com.siberiadante.lib.SiberiaDanteLib;
import com.siberiadante.lib.exception.SiberiaDanteLibException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SiberiaDante on 2017/5/4.
 *
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/5/14
 * @UpDate: 2017/09/20——
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * 使用单例ToastUtil时注意一点：比如使用了带位置的方法后，下次再使用不带位置的单例方法时，会显示成上次方法的Toast的位置
 * 所以强烈建议：全局统一的Toast使用该类中的单例方法，一旦使用了一种以上的方法，需要在不常使用的方法调用后调用resetToast()方法，重置Toast位置等（不适重置Toast对象）
 * 举例：
 * 全局一般使用的Toast是底部弹出一行简单的文字，调用：
 * ToastUtils.toast("常规的Toast方法)；
 * 然后我们有特殊需要，要居中显示一个Toast提示用户，调用：
 * SDToastUtil.showSingletonText("居中显示",Toast.LENGTH_SHORT,Gravity.CENTER);
 * 这个方法调用完，其实相当于是更改了Toast的对象。不再是第一个我们常规使用的方法中所创建的，所以，
 * 我们需要重置Toast对象，其实就是创建一个新的常规对象
 */

public class SDToastUtil {
    @ColorInt
    private static final int DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");

    @ColorInt
    private static final int ERROR_COLOR = Color.parseColor("#FD4C5B");

    @ColorInt
    private static final int INFO_COLOR = Color.parseColor("#3F51B5");

    @ColorInt
    private static final int SUCCESS_COLOR = Color.parseColor("#388E3C");

    @ColorInt
    private static final int WARNING_COLOR = Color.parseColor("#FFA900");

    private static final String TOAST_TYPEFACE = "sans-serif-condensed";


    private static final int POSITION_NULL = -1;//不设置位置，使用默认位置
    private static final int DURATION_NULL = -1;//不设置显示时间，使用默认时间
    private static final int TEXT_SIZE_NULL = -1;//不设置TextView大小，使用默认size
    private static final int TEXT_COLOR_NULL = -1;//不设置TextView颜色，使用默认
    private static final int BACKGROUND_COLOR_NULL = -2;//不设置背景
    @ColorInt
    private static int DEFAULT_TEXT_COLOR_BLACK = Color.BLACK;//默认TextView颜色
    @Size
    private static int DEFAULT_TEXT_SIZE = 16;//默认TextView大小
    private static int DEFAULT_BACKGROUND_COLOR = Color.GRAY;//设置默认背景颜色
    private static Toast currentToast;
    private static Toast toast;
    private static Toast mToastLines;
    private static Toast mToastView;
    private static Toast mCustomToast;
    private static Toast mToastBottom;
    private static Toast mToastCenter;
    private static Toast mToastTop;
    private static List<Toast> toastList = new ArrayList<>();

    private static boolean isNeedReset = false;//加入自动判断，是否需要重置Toast对象的各种设置——后期开发

    public SDToastUtil() {
        new SiberiaDanteLibException(SDToastUtil.class.getName());
    }

    /**
     * 如果只需要简单的Toast提示，用此方法就可以了，最通用Toast
     *
     * @param content
     */
    public static void toast(CharSequence content) {
        if (mCustomToast == null) {
            mCustomToast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        }
        mCustomToast.setText(content);
        mCustomToast.show();
    }

    /**
     * @param content
     */
    public static void toastBottomShort(String content) {
        showSingleToastBottom(content, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param content
     */
    public static void toastBottomLong(String content) {
        showSingleToastBottom(content, Toast.LENGTH_LONG).show();
    }

    /**
     * @param content
     * @return mToastBottom 对象，可自定义设置
     */
    public static Toast getToastBottom(String content) {
        return showSingleToastBottom(content, DURATION_NULL);
    }

    /**
     *
     * @param content
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @return
     */
    @CheckResult
    private static Toast showSingleToastBottom(String content, int duration) {
        if (null == mToastBottom) {
            mToastBottom = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        }
        toastList.add(mToastBottom);
        mToastBottom.setText(content);
        if (DURATION_NULL == duration) {
            mToastBottom.setDuration(Toast.LENGTH_LONG);
        } else {
            mToastBottom.setDuration(duration);
        }
        return mToastBottom;
    }

    /**
     * @param content
     */
    public static void toastCenterShort(String content) {
        showSingleToastCenter(content, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param content
     */
    public static void toastCenterLong(String content) {
        showSingleToastCenter(content, Toast.LENGTH_LONG).show();
    }

    /**
     * @param content
     * @return mToastCenter 对象，可自定义设置
     */
    public static Toast getToastCenter(String content) {
        return showSingleToastCenter(content, DURATION_NULL);
    }

    /**
     *
     * @param content
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @return
     */
    @CheckResult
    private static Toast showSingleToastCenter(String content, int duration) {
        if (null == mToastCenter) {
            mToastCenter = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        }
        toastList.add(mToastCenter);
        mToastCenter.setText(content);
        if (DURATION_NULL == duration) {
            mToastCenter.setDuration(Toast.LENGTH_LONG);
        } else {
            mToastCenter.setDuration(duration);
        }
        mToastCenter.setGravity(Gravity.CENTER, 0, 0);
        return mToastCenter;
    }

    /**
     * @param content
     */
    public static void toastTopShort(String content) {
        showSingleToastTop(content, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param content
     */
    public static void toastTopLong(String content) {
        showSingleToastTop(content, Toast.LENGTH_LONG).show();
    }

    /**
     * @param content
     * @return mToastTop 对象，可自定义设置
     */
    public static Toast getToastTop(String content) {
        return showSingleToastTop(content, DURATION_NULL);
    }

    /**
     *
     * @param content
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @return
     */
    @CheckResult
    private static Toast showSingleToastTop(String content, int duration) {
        if (null == mToastTop) {
            mToastTop = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        }
        toastList.add(mToastTop);
        mToastTop.setText(content);
        if (DURATION_NULL == duration) {
            mToastTop.setDuration(Toast.LENGTH_LONG);
        } else {
            mToastTop.setDuration(duration);
        }
        mToastTop.setGravity(Gravity.TOP, 0, 50);
        return mToastTop;
    }

    /**
     * Toast 无背景透明的文本
     *
     * @param content
     */
    public static void toastTranslucent(String content) {
        showTranslucentText(content, DURATION_NULL, DEFAULT_TEXT_SIZE, DEFAULT_TEXT_COLOR).show();
    }

    /**
     * Toast 无背景透明的文本
     *
     * @param content
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     */
    public static void toastTranslucent(String content, int duration) {
        showTranslucentText(content, duration, DEFAULT_TEXT_SIZE, DEFAULT_TEXT_COLOR).show();
    }

    /**
     * @param content
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @param textSize
     * @param textColor
     */
    public static void toastTranslucent(String content, int duration, float textSize, int textColor) {
        showTranslucentText(content, duration, textSize, textColor).show();
    }

    /**
     * Toast 无背景透明的文本
     *
     * @param content  内容
     * @param duration  显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     */
    @CheckResult
    private static Toast showTranslucentText(String content, int duration, float textSize, int textColor) {
        if (toast == null) {
            toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        }
        toastList.add(toast);
        LinearLayout linearLayout = new LinearLayout(SiberiaDanteLib.getContext());//创建线性布局
        linearLayout.setOrientation(LinearLayout.VERTICAL);//设置布局垂直
        TextView textView = new TextView(SiberiaDanteLib.getContext());
        if (textSize == TEXT_SIZE_NULL) {
            textView.setTextSize(DEFAULT_TEXT_SIZE);
        } else {
            textView.setTextSize(textSize);
        }
        if (textColor == TEXT_COLOR_NULL) {
            textView.setTextColor(DEFAULT_TEXT_COLOR_BLACK);
        } else {
            textView.setTextColor(textColor);
        }
        textView.setText(content);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        if (DURATION_NULL == duration) {
            toast.setDuration(Toast.LENGTH_LONG);
        } else {
            toast.setDuration(duration);
        }
        toast.show();
        return toast;
    }

    /**
     * 显示多行文字
     *
     * @param contents
     */
    public static void showLinesText(List<String> contents) {
        showLinesToastText(contents, BACKGROUND_COLOR_NULL, DEFAULT_TEXT_SIZE, DEFAULT_TEXT_COLOR, 30, 10, 30, 10).show();
    }

    /**
     * 显示多行文字
     *
     * @param contents
     * @param textSize
     * @param textColor
     */
    public static void showLinesText(List<String> contents, int textSize, int textColor) {
        showLinesToastText(contents, BACKGROUND_COLOR_NULL, textSize, textColor, 30, 10, 30, 10).show();
    }

    /**
     * 显示多行文字
     *
     * @param contents
     * @param textSize
     * @param textColor
     */
    public static void showLinesText(List<String> contents, int backgroundColor, int textSize, int textColor) {
        showLinesToastText(contents, backgroundColor, textSize, textColor, 30, 10, 30, 10).show();
    }

    /**
     * 显示多行文字
     *
     * @param contents
     * @param backgroundColor
     * @param textSize
     * @param textColor
     * @param paddingStart
     * @param paddingTop
     * @param paddingRight
     * @param paddingLeft
     */
    public static void showLinesText(List<String> contents, int backgroundColor, int textSize, int textColor, int paddingStart, int paddingTop, int paddingRight, int paddingLeft) {
        showLinesToastText(contents, backgroundColor, textSize, textColor, paddingStart, paddingTop, paddingRight, paddingLeft).show();
    }

    /**
     * Toast 多行文本
     *
     * @param textSize  字体大小
     * @param textColor 字体颜色
     * @param contents  list 形式的文本内容
     */
    @CheckResult
    private static Toast showLinesToastText(List<String> contents, int backgroundColor, int textSize,
                                            int textColor, int paddingStart, int paddingTop, int paddingRight, int paddingLeft) {
        if (null == mToastLines) {
            mToastLines = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        }
        toastList.add(mToastLines);
        LinearLayout linearLayoutTop = new LinearLayout(SiberiaDanteLib.getContext());//创建线性布局
        linearLayoutTop.setPadding(SDTransitionUtil.dip2px(paddingStart), SDTransitionUtil.dip2px(paddingTop), SDTransitionUtil.dip2px(paddingRight), SDTransitionUtil.dip2px(paddingLeft));

        if (BACKGROUND_COLOR_NULL == backgroundColor) {
            linearLayoutTop.setBackgroundColor(DEFAULT_BACKGROUND_COLOR);
        } else {
            linearLayoutTop.setBackgroundColor(backgroundColor);
        }
        linearLayoutTop.setOrientation(LinearLayout.VERTICAL);//设置布局垂直
        for (int i = 0; i < contents.size(); i++) {
            TextView textView = new TextView(SiberiaDanteLib.getContext());
            textView.setText(contents.get(i));
            textView.setTextSize(textSize);
            textView.setTextColor(textColor);
            linearLayoutTop.addView(textView);
        }
        mToastLines.setView(linearLayoutTop);
        mToastLines.setDuration(Toast.LENGTH_LONG);
        return mToastLines;
    }

    /**
     * @param resId 布局id
     */
    public static void showView(@LayoutRes int resId) {
        showView(resId, POSITION_NULL, 0, 0, DURATION_NULL).show();
    }

    /**
     * @param resId    布局id
     * @param position
     * @param xOffset
     * @param yOffset
     */
    public static void showView(@LayoutRes int resId, int position, int xOffset, int yOffset) {
        showView(resId, POSITION_NULL, 0, 0, DURATION_NULL).show();
    }


    /**
     * @param resId    布局id
     * @param position 显示位置 {@code Gravity.CENTER} {@code Gravity.BOTTOM} {@code Gravity.TOP} or {@code Gravity.TOP|Gravity.BOTTOM}
     * @param xOffset  相对x轴的偏移量
     * @param yOffset  相对y轴的偏移量
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @return
     */
    private static Toast showView(@LayoutRes int resId, int position, int xOffset, int yOffset, int duration) {
        if (null == mToastView) {
            mToastView = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        }
        View view = LayoutInflater.from(SiberiaDanteLib.getContext()).inflate(resId, null);
        toastList.add(mToastView);
        mToastView.setView(view);
        if (duration == DURATION_NULL) {
            mToastView.setDuration(Toast.LENGTH_LONG);
        } else {
            mToastView.setDuration(duration);
        }
        if (position == POSITION_NULL) {
            mToastView.setGravity(Gravity.CENTER, 0, 0);
        } else {
            mToastView.setGravity(position, xOffset, yOffset);
        }
        return mToastView;
    }

    /**
     * Toast图片
     * 单例模式，自定义时间
     *
     * @param resId    图片资源ID
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     */
    public static void showSingletonImageCenter(int resId, int duration) {
        if (toast == null) {
            toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        }
        ImageView imageView = new ImageView(SiberiaDanteLib.getContext());
        imageView.setImageResource(resId);
        toast.setView(imageView);
        toast.setDuration(duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * Toast图片
     * 非单例模式，自定义时间
     *
     * @param resId    图片资源ID
     * @param duration  显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     */
    public static void showImageCenter(int resId, int duration) {
        toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        toastList.add(toast);
        ImageView imageView = new ImageView(SiberiaDanteLib.getContext());//创建图片控件
        imageView.setImageResource(resId);//给控件设置图片
        toast.setView(imageView);//把图片绑定到Toast上
        toast.setDuration(duration);//Toast显示的时间;
        //设置图片显示的位置：三个参数
        //第一个：位置，可以用|添加并列位置，第二个：相对于X的偏移量，第三个：相对于Y轴的偏移量
        //注意一点：第二和第三个参数是相对于第一个参数设定的位置偏移的
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();//显示Toast
    }

    /**
     * Toast图片
     * 单例模式，自定义时间,自定义位置
     *
     * @param resId    图片资源ID
     * @param duration Toast.LENGTH_LONG/Toast.LENGTH_LONG
     * @param position 显示位置 {@code Gravity.CENTER} {@code Gravity.BOTTOM} {@code Gravity.TOP} or {@code Gravity.TOP|Gravity.BOTTOM}
     */
    public static void showSingletonImage(int resId, int duration, int position) {
        if (toast == null) {
            toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        }
        ImageView imageView = new ImageView(SiberiaDanteLib.getContext());//创建图片控件
        imageView.setImageResource(resId);
        toast.setView(imageView);
        toast.setDuration(duration);
        toast.setGravity(position, 0, 0);
        toast.show();
    }

    /**
     * Toast图片
     * 非单例模式，自定义时间,自定义位置
     *
     * @param resId    图片资源ID
     * @param duration  显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @param position 显示位置 {@code Gravity.CENTER} {@code Gravity.BOTTOM} {@code Gravity.TOP} or {@code Gravity.TOP|Gravity.BOTTOM}
     */
    public static void showImage(int resId, int duration, int position) {
        toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        toastList.add(toast);
        ImageView imageView = new ImageView(SiberiaDanteLib.getContext());//创建图片控件
        imageView.setImageResource(resId);
        toast.setView(imageView);
        toast.setDuration(duration);
        toast.setGravity(position, 0, 0);
        toast.show();
    }

    /**
     * Toast图片
     * 非单例模式，自定义时间,自定义位置
     *
     * @param bitmap   图片资源ID
     * @param duration  显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @param position 显示位置 {@code Gravity.CENTER} {@code Gravity.BOTTOM} {@code Gravity.TOP} or {@code Gravity.TOP|Gravity.BOTTOM}
     */
    public static void showImage(Bitmap bitmap, int duration, int position) {
        toast = Toast.makeText(SiberiaDanteLib.getContext(), "", duration);
        toastList.add(toast);
        ImageView imageView = new ImageView(SiberiaDanteLib.getContext());//创建图片控件
        imageView.setImageBitmap(bitmap);
        toast.setView(imageView);
        toast.setDuration(duration);
        toast.setGravity(position, 0, 0);
        toast.show();
    }


    /**
     * 重置Toast对象
     */
    public static void resetToast() {
        toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
    }

    public static void cancel() {
        if (toast != null) {
            toast.cancel();
        }
    }

    public static void cancelAll() {
        for (int i = 0; i < toastList.size(); i++) {
            if (toastList.get(i) != null) {
                toastList.get(i).cancel();
            }
        }
    }

    // TODO: 2017/9/20


    /**
     * @param message
     */
    public static void normal(@NonNull String message) {
        normal(SiberiaDanteLib.getContext(), message, Toast.LENGTH_SHORT, null, false).show();
    }

    /**
     * @param context
     * @param message
     * @return
     */
    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull String message) {
        return normal(context, message, Toast.LENGTH_SHORT, null, false);
    }

    /**
     * @param message
     * @param icon
     */
    public static void normal(@NonNull String message, Drawable icon) {
        normal(SiberiaDanteLib.getContext(), message, Toast.LENGTH_SHORT, icon, true).show();
    }

    /**
     * @param context
     * @param message
     * @param icon
     * @return
     */
    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull String message, Drawable icon) {
        return normal(context, message, Toast.LENGTH_SHORT, icon, true);
    }

    /**
     * @param message
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     */
    public static void normal(@NonNull String message, int duration) {
        normal(SiberiaDanteLib.getContext(), message, duration, null, false).show();
    }

    /**
     * @param context
     * @param message
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @return
     */
    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull String message, int duration) {
        return normal(context, message, duration, null, false);
    }

    /**
     * @param message
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @param icon
     */
    public static void normal(@NonNull String message, int duration, Drawable icon) {
        normal(SiberiaDanteLib.getContext(), message, duration, icon, true).show();
    }

    /**
     * @param context
     * @param message
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @param icon
     * @return
     */
    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull String message, int duration, Drawable icon) {
        return normal(context, message, duration, icon, true);
    }

    /**
     * @param message
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @param icon
     * @param withIcon
     * @return
     */
    public static Toast normal(@NonNull String message, int duration, Drawable icon, boolean withIcon) {
        return custom(SiberiaDanteLib.getContext(), message, icon, DEFAULT_TEXT_COLOR, duration, withIcon);
    }

    /**
     * @param context
     * @param message
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @param icon
     * @param withIcon
     * @return
     */
    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull String message, int duration, Drawable icon, boolean withIcon) {
        return custom(context, message, icon, DEFAULT_TEXT_COLOR, duration, withIcon);
    }


    /**
     *
     * @param message
     */
    public static void warning(@NonNull String message) {
        warning(SiberiaDanteLib.getContext(), message, Toast.LENGTH_SHORT, true).show();
    }

    /**
     *
     * @param message
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     */
    public static void warning(@NonNull String message, int duration) {
        warning(SiberiaDanteLib.getContext(), message, duration, true).show();
    }

    /**
     *
     * @param message
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @param withIcon
     * @return
     */
    public static Toast warning(@NonNull String message, int duration, boolean withIcon) {
        return custom(SiberiaDanteLib.getContext(), message, getDrawable(R.drawable.ic_error_outline_white_48dp), DEFAULT_TEXT_COLOR, WARNING_COLOR, duration, withIcon, true);
    }

    /**
     *
     * @param message
     */
    public static void info(@NonNull String message) {
        info(SiberiaDanteLib.getContext(), message, Toast.LENGTH_SHORT, true).show();
    }

    /**
     *
     * @param message
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     */
    public static void info(@NonNull String message, int duration) {
        info(SiberiaDanteLib.getContext(), message, duration, true).show();
    }

    /**
     *
     * @param message
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @param withIcon
     * @return
     */
    public static Toast info(@NonNull String message, int duration, boolean withIcon) {
        return custom(SiberiaDanteLib.getContext(), message, getDrawable(R.drawable.ic_info_outline_white_48dp), DEFAULT_TEXT_COLOR, INFO_COLOR, duration, withIcon, true);
    }

    /**
     *
     * @param message
     */
    public static void success(@NonNull String message) {
        success(SiberiaDanteLib.getContext(), message, Toast.LENGTH_SHORT, true).show();
    }

    /**
     *
     * @param message
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     */
    public static void success(@NonNull String message, int duration) {
        success(SiberiaDanteLib.getContext(), message, duration, true).show();
    }

    /**
     *
     * @param message
     * @param duration 显示时长 {@code Toast.LENGTH_LONG} {@code Toast.LENGTH_SHORT}
     * @param withIcon
     * @return
     */
    public static Toast success(@NonNull String message, int duration, boolean withIcon) {
        return custom(SiberiaDanteLib.getContext(), message, getDrawable(R.drawable.ic_check_white_48dp), DEFAULT_TEXT_COLOR, SUCCESS_COLOR, duration, withIcon, true);
    }

    /**
     *
     * @param message
     */
    public static void error(@NonNull String message) {
        error(SiberiaDanteLib.getContext(), message, Toast.LENGTH_SHORT, true).show();
    }

    //*******************************************常规方法********************************************

    public static void error(@NonNull String message, int duration) {
        error(SiberiaDanteLib.getContext(), message, duration, true).show();
    }

    public static Toast error(@NonNull String message, int duration, boolean withIcon) {
        return custom(SiberiaDanteLib.getContext(), message, getDrawable(R.drawable.ic_clear_white_48dp), DEFAULT_TEXT_COLOR, ERROR_COLOR, duration, withIcon, true);
    }


    @CheckResult
    public static Toast warning(@NonNull Context context, @NonNull String message) {
        return warning(context, message, Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast warning(@NonNull Context context, @NonNull String message, int duration) {
        return warning(context, message, duration, true);
    }

    @CheckResult
    public static Toast warning(@NonNull Context context, @NonNull String message, int duration, boolean withIcon) {
        return custom(context, message, getDrawable(R.drawable.ic_error_outline_white_48dp), DEFAULT_TEXT_COLOR, WARNING_COLOR, duration, withIcon, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @NonNull String message) {
        return info(context, message, Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @NonNull String message, int duration) {
        return info(context, message, duration, true);
    }

    @CheckResult
    public static Toast info(@NonNull Context context, @NonNull String message, int duration, boolean withIcon) {
        return custom(context, message, getDrawable(R.drawable.ic_info_outline_white_48dp), DEFAULT_TEXT_COLOR, INFO_COLOR, duration, withIcon, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @NonNull String message) {
        return success(context, message, Toast.LENGTH_SHORT, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @NonNull String message, int duration) {
        return success(context, message, duration, true);
    }

    @CheckResult
    public static Toast success(@NonNull Context context, @NonNull String message, int duration, boolean withIcon) {
        return custom(context, message, getDrawable(R.drawable.ic_check_white_48dp), DEFAULT_TEXT_COLOR, SUCCESS_COLOR, duration, withIcon, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @NonNull String message) {
        return error(context, message, Toast.LENGTH_SHORT, true);
    }

    //===========================================常规方法============================================

    @CheckResult
    public static Toast error(@NonNull Context context, @NonNull String message, int duration) {
        return error(context, message, duration, true);
    }

    @CheckResult
    public static Toast error(@NonNull Context context, @NonNull String message, int duration, boolean withIcon) {
        return custom(context, message, getDrawable(R.drawable.ic_clear_white_48dp), DEFAULT_TEXT_COLOR, ERROR_COLOR, duration, withIcon, true);
    }

    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull String message, Drawable icon,
                               @ColorInt int textColor, int duration, boolean withIcon) {
        return custom(context, message, icon, textColor, -1, duration, withIcon, false);
    }

    //*******************************************内需方法********************************************

    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull String message, @DrawableRes int iconRes,
                               @ColorInt int textColor, @ColorInt int tintColor, int duration, boolean withIcon, boolean shouldTint) {
        return custom(context, message, getDrawable(iconRes), textColor, tintColor, duration, withIcon, shouldTint);
    }

    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull String message, Drawable icon, @ColorInt int textColor, @ColorInt int tintColor, int duration, boolean withIcon, boolean shouldTint) {
        if (currentToast == null) {
            currentToast = new Toast(context);
        }
        final View toastLayout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.sd_toast_layout, null);
        final ImageView toastIcon = (ImageView) toastLayout.findViewById(R.id.toast_icon);
        final TextView toastTextView = (TextView) toastLayout.findViewById(R.id.toast_text);
        Drawable drawableFrame;

        if (shouldTint) {
            drawableFrame = tint9PatchDrawableFrame(context, tintColor);
        } else {
            drawableFrame = getDrawable(R.drawable.toast_frame);
        }
        setBackground(toastLayout, drawableFrame);

        if (withIcon) {
            if (icon == null) {
                throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
            } else {
                setBackground(toastIcon, icon);
            }
        } else {
            toastIcon.setVisibility(View.GONE);
        }

        toastTextView.setTextColor(textColor);
        toastTextView.setText(message);
        toastTextView.setTypeface(Typeface.create(TOAST_TYPEFACE, Typeface.NORMAL));

        currentToast.setView(toastLayout);
        currentToast.setDuration(duration);
        return currentToast;
    }

    private static  Drawable tint9PatchDrawableFrame(@NonNull Context context, @ColorInt int tintColor) {
        final NinePatchDrawable toastDrawable = (NinePatchDrawable) getDrawable(R.drawable.toast_frame);
        toastDrawable.setColorFilter(new PorterDuffColorFilter(tintColor, PorterDuff.Mode.SRC_IN));
        return toastDrawable;
    }



    private static  void setBackground(@NonNull View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    private static  Drawable getDrawable(@DrawableRes int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            return SiberiaDanteLib.getContext().getDrawable(id);
        else
            return SiberiaDanteLib.getContext().getResources().getDrawable(id);
    }
}
