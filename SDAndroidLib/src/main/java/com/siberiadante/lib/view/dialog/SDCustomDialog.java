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

import java.util.ArrayList;
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
    private int[] mIds = new int[]{};  // 要监听的控件id
    private int mAnimationResId = 0;//主题style
    private OnCustomDialogItemClickListener listener;
    private boolean mIsDismiss = true;//是否默认所有按钮点击后取消dialog显示，false时需要在点击事件后手动调用dismiss
    private boolean mIsDismissTouchOut = true;//是否允许触摸dialog外部区域取消显示dialog
    private int mPosition = 0; //Dialog 相对页面显示的位置
    private List<View> mViews = new ArrayList<>();//监听的View的集合

    public void setOnSDCustomDialogItemClickListener(OnCustomDialogItemClickListener listener) {
        this.listener = listener;
    }

    public SDCustomDialog(Context context, int ids) {
        super(context, R.style.Custom_Dialog_Style);
        this.context = context;
        this.mLayoutResId = ids;

    }

    public SDCustomDialog(Context context, int layoutResID, int[] ids) {
        super(context, R.style.Custom_Dialog_Style); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mIds = ids;
    }


    public SDCustomDialog(Context context, int layoutResID, int[] ids, int animationResId) {
        super(context, R.style.Custom_Dialog_Style); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mIds = ids;
        this.mAnimationResId = animationResId;
    }


    public SDCustomDialog(Context context, int layoutResID, int[] ids, boolean isDismiss) {
        super(context, R.style.Custom_Dialog_Style); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mIds = ids;
        this.mIsDismiss = isDismiss;
    }


    public SDCustomDialog(Context context, int layoutResID, int[] ids, boolean isDismiss, int position) {
        super(context, R.style.Custom_Dialog_Style); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mIds = ids;
        this.mIsDismiss = isDismiss;
        this.mPosition = position;
    }

    /**
     * @param context
     * @param layoutResID       布局Id
     * @param ids               需要监听的View id集合
     * @param animationResId    动画资源id
     * @param isDismiss         是否默认点击所有View 取消dialog显示
     * @param isDismissTouchOut 是否触摸dialog外部区域消失dialog显示
     * @param position          dialog显示的位置
     */
    public SDCustomDialog(Context context,
                          int layoutResID,
                          int[] ids,
                          int animationResId,
                          boolean isDismiss,
                          boolean isDismissTouchOut,
                          int position) {
        super(context, R.style.Custom_Dialog_Style); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mIds = ids;
        this.mAnimationResId = animationResId;
        this.mIsDismiss = isDismiss;
        this.mIsDismissTouchOut = isDismissTouchOut;
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
        setCanceledOnTouchOutside(mIsDismissTouchOut);
        //遍历控件id,添加点击事件，添加资源到集合
        for (int id : mIds) {
            View view = findViewById(id);
            view.setOnClickListener(this);
            mViews.add(view);
        }
    }

    /**
     * 获取需要监听的View集合
     *
     * @return
     */
    public List<View> getViews() {
        return mViews;
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {

    }


    public interface OnCustomDialogItemClickListener {
        void OnCustomDialogItemClick(SDCustomDialog dialog, View view);
    }


    @Override
    public void onClick(View view) {
        //是否默认所有按钮点击后取消dialog显示，false是需要在点击事件后手动调用dismiss。
        if (mIsDismiss) {
            dismiss();
        }
        listener.OnCustomDialogItemClick(this, view);
    }
}
