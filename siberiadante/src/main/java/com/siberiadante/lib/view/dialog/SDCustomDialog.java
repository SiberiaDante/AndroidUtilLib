package com.siberiadante.lib.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.siberiadante.lib.R;

import java.util.List;

/**
 * @Created SiberiaDante
 * @Describe： 通用Dialog，只需要传入布局id,和需要设置点击事件的控件id;
 * 额外支持：设置dialog位置，Dialog弹出动画，dialog是否点击按钮自动消失等
 * @Time: 2017/9/19
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDCustomDialog extends Dialog implements View.OnClickListener {
    private Context context;      // 上下文
    private int mLayoutResId;      // 布局文件id
    private int[] mListenedItems;  // 要监听的控件id
    private int mAnimationResId;//主题style
    private OnCenterItemClickListener listener;
    private boolean mIsDismiss = false;//是否默认所有按钮点击后取消dialog显示，false是需要在点击事件后手动调用dismiss
    private int mPosition = 0; //Dialog 相对页面显示的位置

    public void setOnCenterItemClickListener(OnCenterItemClickListener listener) {
        this.listener = listener;
    }

    /**
     * 全部使用默认设置，你需要传入布局id，和需要设置点击事件的控件id
     *
     * @param context
     * @param layoutResID   自己定义的布局
     * @param listenedItems 需要设置点击事件的资源id
     */
    public SDCustomDialog(Context context, int layoutResID, int[] listenedItems) {
        super(context, R.style.Custom_Dialog_Style); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mListenedItems = listenedItems;
    }


//

    /**
     * @param context
     * @param layoutResID    自己定义的布局
     * @param listenedItems  需要设置点击事件的资源id
     * @param animationResId dialog style，如果不使用自己的，则传0
     */
    public SDCustomDialog(Context context, int layoutResID, int[] listenedItems, int animationResId) {
        super(context, R.style.Custom_Dialog_Style); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mListenedItems = listenedItems;
        this.mAnimationResId = animationResId;
    }

    /**
     * @param context
     * @param layoutResID   自己定义的布局
     * @param listenedItems 需要设置点击事件的资源id
     * @param isDismiss     按钮点击后是否默认取消dialog {@code true}取消 {@code false} 不取消
     */
    public SDCustomDialog(Context context, int layoutResID, int[] listenedItems, boolean isDismiss) {
        super(context, R.style.Custom_Dialog_Style); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mListenedItems = listenedItems;
        this.mIsDismiss = isDismiss;
    }

    /**
     * @param context
     * @param layoutResID   自己定义的布局
     * @param listenedItems 需要设置点击事件的资源id
     * @param isDismiss     按钮点击后是否默认取消dialog {@code true}取消 {@code false} 不取消
     * @param position      dialog 显示位置，默认CENTER,不设置时可以传0
     */
    public SDCustomDialog(Context context, int layoutResID, int[] listenedItems, boolean isDismiss, int position) {
        super(context, R.style.Custom_Dialog_Style); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mListenedItems = listenedItems;
        this.mIsDismiss = isDismiss;
        this.mPosition = position;
    }

    /**
     * 满足你各种需求
     *
     * @param context
     * @param layoutResID    自己定义的布局
     * @param listenedItems  需要设置点击事件的资源id
     * @param animationResId dialog 弹出动画，如果不使用自己的，则传0
     * @param isDismiss      按钮点击后是否默认取消dialog {@code true}取消 {@code false} 不取消
     * @param position       dialog 显示位置，默认CENTER,不设置时可以传0
     */
    public SDCustomDialog(Context context, int layoutResID, int[] listenedItems, int animationResId, boolean isDismiss, int position) {
        super(context, R.style.Custom_Dialog_Style); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mListenedItems = listenedItems;
        this.mAnimationResId = animationResId;
        this.mIsDismiss = isDismiss;
        this.mPosition = position;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (0 == mPosition) {
            window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置为居中
        } else {
            window.setGravity(mPosition);// 此处可以设置自定义的dialog位置
        }
        if (mAnimationResId == 0) {
            window.setWindowAnimations(R.style.bottom_animation); // 添加动画效果
        } else {
            window.setWindowAnimations(mAnimationResId);//添加自定义动画
        }
        setContentView(mLayoutResId);

        WindowManager windowManager = ((Activity) context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = display.getWidth() * 4 / 5; // 设置dialog宽度为屏幕的4/5
        getWindow().setAttributes(lp);
        setCanceledOnTouchOutside(true);// 点击Dialog外部消失
        //遍历控件id,添加点击事件
        for (int id : mListenedItems) {
            findViewById(id).setOnClickListener(this);
        }
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {

    }


    public interface OnCenterItemClickListener {
        void OnCenterItemClick(SDCustomDialog dialog, View view);
    }


    @Override
    public void onClick(View view) {
        //是否默认所有按钮点击后取消dialog显示，false是需要在点击事件后手动调用dismiss。
        if (mIsDismiss) {
            dismiss();
        }
        listener.OnCenterItemClick(this, view);
    }
}
