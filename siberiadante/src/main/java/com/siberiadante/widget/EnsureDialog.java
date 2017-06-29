package com.siberiadante.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siberiadante.R;

/**
 * @Created SiberiaDante
 * @Describe： 常规的提示确认dialog
 * @Time: 2017/6/29
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class EnsureDialog {
    private final Display display;
    private Context context;
    private TextView mTvTitle;
    private TextView mTvSure;
    private TextView mTvCancel;
    private ImageView mIvIcon;
    private Dialog dialog;
    private Window dialogWindow;

    public EnsureDialog(Context context) {
        this.context = context;
        final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
        dialog = new Dialog(context, R.style.CustomDialog);
        dialogWindow = dialog.getWindow();

    }

    /**
     * 构建
     *
     * @return
     */
    public EnsureDialog builder() {
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_ensure_layout, null, false);
        LinearLayout mLinearDialog = ((LinearLayout) view.findViewById(R.id.linear_dialog));
        mIvIcon = ((ImageView) view.findViewById(R.id.iv_icon));
        mTvTitle = ((TextView) view.findViewById(R.id.tv_title));
        mTvSure = ((TextView) view.findViewById(R.id.tv_sure));
        mTvCancel = ((TextView) view.findViewById(R.id.tv_cancel));
        dialog.setContentView(view);
        mLinearDialog.setLayoutParams(new FrameLayout.LayoutParams(((int) (display.getWidth() * 0.80)), LinearLayout.LayoutParams.WRAP_CONTENT));
        dialogWindow.setGravity(Gravity.CENTER);
        return this;
    }

    /**
     * setting dialog position
     *
     * @param gravity
     * @return
     */
    public EnsureDialog setGravity(int gravity) {
        dialogWindow.setGravity(gravity);
        return this;
    }

    /**
     * setting dialog icon
     *
     * @param drawable
     * @return
     */
    public EnsureDialog setIncon(int drawable) {
        mIvIcon.setVisibility(View.VISIBLE);
        mIvIcon.setImageResource(drawable);
        return this;
    }

    /**
     * setting dialog title
     *
     * @param title
     * @return
     */
    public EnsureDialog setTitle(String title) {
        if ("".equals(title)) {
            mTvTitle.setText("标题");
        } else {
            mTvTitle.setText(title);
        }
        return this;
    }

    /**
     * @param title
     * @param color
     * @return
     */
    public EnsureDialog setTitle(String title, int color) {
        if ("".equals(title)) {
            mTvTitle.setText("标题");
        } else {
            mTvTitle.setText(title);
        }
        mTvTitle.setTextColor(color);
        return this;
    }

    /**
     * setting dialog right button
     *
     * @param text
     * @param listener
     * @return
     */
    public EnsureDialog setPositiveButton(String text, final View.OnClickListener listener) {
        if ("".equals(text)) {
            mTvSure.setText("确认");
        } else {
            mTvSure.setText(text);
        }

        mTvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
            }
        });
        return this;
    }

    /**
     * 可设置颜色
     *
     * @param text
     * @param color
     * @param listener
     * @return
     */
    public EnsureDialog setPositiveButton(String text, int color, final View.OnClickListener listener) {
        if ("".equals(text)) {
            mTvSure.setText("确认");
        } else {
            mTvSure.setText(text);
        }

        mTvSure.setTextColor(color);
        mTvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
            }
        });
        return this;
    }

    /**
     * setting dialog left button
     *
     * @param text
     * @param listener
     * @return
     */
    public EnsureDialog setNegativeButton(String text, final View.OnClickListener listener) {
        if ("".equals(text)) {
            mTvCancel.setText("取消");
        } else {
            mTvCancel.setText(text);
        }

        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    public EnsureDialog setNegativeButton(String text, int color, final View.OnClickListener listener) {
        if ("".equals(text)) {
            mTvCancel.setText("取消");
        } else {
            mTvCancel.setText(text);
        }
        mTvCancel.setTextColor(color);
        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    /**
     * setting dialog cancelable
     *
     * @param cancelable
     * @return
     */
    public EnsureDialog setCancelable(boolean cancelable) {
        dialog.setCancelable(cancelable);
        return this;
    }

    /**
     * cancel dialog
     *
     * @return
     */
    public EnsureDialog dismiss() {
        dialog.dismiss();
        return this;
    }

    /**
     * show dialog
     */
    public void show() {
        dialog.show();
    }
}
