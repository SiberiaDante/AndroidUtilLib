package com.siberiadante.androidutil.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.siberiadante.androidutil.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: SiberiaDante
 * Describe： 通用Dialog，只需要传入布局id,和需要设置点击事件的控件id;
 * 额外支持：设置dialog位置，Dialog弹出动画，dialog是否点击按钮自动消失等
 * Time: 2017/9/19
 * UpDate:
 * Email: 994537867@qq.com
 * GitHub: https://github.com/SiberiaDante
 */

public class SDCustomDialog extends Dialog implements View.OnClickListener {
    private Context context;      // 上下文
    private int mLayoutResId;      // 布局文件id
    private int[] mIds = new int[]{};  // 要监听的控件id
    private int mAnimationResId = 0;//主题style
    private OnCustomDialogItemClickListener listener;
    private boolean mIsDismiss = true;//是否默认所有按钮点击后取消dialog显示，false时需要在点击事件后手动调用dismiss
    private boolean mIsDismissTouchOut = true;//是否允许触摸dialog外部区域取消显示dialog
    private boolean isKeyDownForbid = false;//是否拦截返回键事件
    private int mPosition = 0; //Dialog 相对页面显示的位置
    private List<View> mViews = new ArrayList<>();//监听的View的集合
    private Display display;

    public SDCustomDialog(Context context, int layoutResID) {
        super(context, R.style.CustomDialogStyle);
        this.context = context;
        this.mLayoutResId = layoutResID;
    }


    public SDCustomDialog(Context context, int layoutResID, int[] listenedIds) {
        super(context, R.style.CustomDialogStyle); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mIds = listenedIds;
    }

    public SDCustomDialog(Context context, int layoutResID, int[] listenedIds, int animationResId) {
        super(context, R.style.CustomDialogStyle); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mIds = listenedIds;
        this.mAnimationResId = animationResId;
    }

    public SDCustomDialog(Context context, int layoutResID, int[] listenedIds, boolean isDismiss) {
        super(context, R.style.CustomDialogStyle); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mIds = listenedIds;
        this.mIsDismiss = isDismiss;
    }

    public SDCustomDialog(Context context, int layoutResID, int[] listenedIds, boolean isDismiss, boolean isDismissTouchOut) {
        super(context, R.style.CustomDialogStyle); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mIds = listenedIds;
        this.mIsDismiss = isDismiss;
        this.mIsDismissTouchOut = isDismissTouchOut;
    }

    public SDCustomDialog(Context context, int layoutResID, int[] listenedIds, boolean isDismiss, int position) {
        super(context, R.style.CustomDialogStyle); //dialog的样式
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mIds = listenedIds;
        this.mPosition = position;
        this.mIsDismiss = isDismiss;
    }

    /**
     * @param context
     * @param layoutResID       布局Id
     * @param listenedIds       需要监听的View id集合
     * @param animationResId    动画资源id
     * @param isDismiss         是否默认点击所有View 取消dialog显示
     * @param isDismissTouchOut 是否触摸dialog外部区域消失dialog显示
     * @param isKeyDownForbid   设置Dialog显示时是否拦截返回键事件
     * @param position          dialog显示的位置
     */
    public SDCustomDialog(Context context,
                          int layoutResID,
                          int[] listenedIds,
                          int animationResId,
                          boolean isDismiss,
                          boolean isDismissTouchOut,
                          boolean isKeyDownForbid,
                          int position) {
        super(context, R.style.CustomDialogStyle);
        this.context = context;
        this.mLayoutResId = layoutResID;
        this.mIds = listenedIds;
        this.mAnimationResId = animationResId;
        this.mIsDismiss = isDismiss;
        this.mIsDismissTouchOut = isDismissTouchOut;
        this.isKeyDownForbid = isKeyDownForbid;
        this.mPosition = position;

    }

    public void setOnDialogItemClickListener(OnCustomDialogItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mLayoutResId);
        setCanceledOnTouchOutside(mIsDismissTouchOut);
        //add all view that need get event
        for (int id : mIds) {
            View view = findViewById(id);
            view.setOnClickListener(this);
            mViews.add(view);
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Window window = getWindow();
        Point point = new Point();
        if (windowManager != null) {
            display = windowManager.getDefaultDisplay();
            display.getSize(point);
        }
        if (window != null) {
            if (0 == mPosition) {
                window.setGravity(Gravity.CENTER); // dialog default position:center
            } else {
                window.setGravity(mPosition);// you defined position
            }
            if (mAnimationResId == 0) {
                window.setWindowAnimations(R.style.BottomAnimation); // default animation
            } else {
                window.setWindowAnimations(mAnimationResId);//your defined animation
            }
            window.setLayout(point.x * 4 / 5, WindowManager.LayoutParams.WRAP_CONTENT);
        }
//        WindowManager windowManager = ((Activity) context).getWindowManager();
//        Display display = windowManager.getDefaultDisplay();
//        WindowManager.LayoutParams lp = getWindow().getAttributes();
//        lp.width = display.getWidth() * 4 / 5; // 设置dialog宽度为屏幕的4/5
//        getWindow().setAttributes(lp);

    }

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        return isKeyDownForbid || super.onKeyDown(keyCode, event);
    }

    /**
     * 获取需要监听的View集合
     *
     * @return
     */
    public List<View> getViews() {
        return mViews;
    }

    /**
     * 设置Dialog显示时是否拦截返回键事件
     *
     * @param keyDownForbid
     */
    public void setKeyDownForbid(boolean keyDownForbid) {
        this.isKeyDownForbid = keyDownForbid;
    }

    /**
     * 设置是否触摸Dialog以外区域取消Dialog
     *
     * @param isDismissTouchOut
     */
    public void setIsDismissTouchOut(boolean isDismissTouchOut) {
        this.mIsDismissTouchOut = isDismissTouchOut;
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {

    }

    @Override
    public void onClick(View view) {
        //是否默认所有按钮点击后取消dialog显示，false是需要在点击事件后手动调用dismiss。
        if (mIsDismiss) {
            dismiss();
        }
        listener.OnCustomDialogItemClick(this, view);
    }

    public interface OnCustomDialogItemClickListener {
        void OnCustomDialogItemClick(SDCustomDialog dialog, View view);
    }
}
