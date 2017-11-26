package com.siberiadante.lib.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siberiadante.lib.R;
import com.siberiadante.lib.view.base.SDDialog;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/21
 * @UpDate:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDEnsureSubDialog extends SDDialog {

    private ImageView mIvLogo;
    private TextView mTvTitle;
    private TextView mTvContent;
    private TextView mTvSure;

    public ImageView getIvLogo() {
        return mIvLogo;
    }

    public TextView getTvTitle() {
        return mTvTitle;
    }

    public TextView getTvSure() {
        return mTvSure;
    }

    public TextView getTvContent() {
        return mTvContent;
    }

    public void setLogo(int resId) {
        mIvLogo.setImageResource(resId);
    }

    public void setTitle(String title) {
        mTvTitle.setText(title);
    }

    public void setSure(String content) {
        mTvSure.setText(content);
    }


    public void setContent(String str) {
//        if (RxRegUtils.isURL(str)) {
//            // 响应点击事件的话必须设置以下属性
//            mTvContent.setMovementMethod(LinkMovementMethod.getInstance());
//            mTvContent.setText(RxTextUtils.getBuilder("").setBold().append(str).setUrl(str).create());//当内容为网址的时候，内容变为可点击
//        } else {
//            mTvContent.setText(str);
//        }
        mTvContent.setText(str);

    }

    private void initView() {
        View dialog_view = LayoutInflater.from(getContext()).inflate(R.layout.sd_dialog_sure, null);
        mTvSure = (TextView) dialog_view.findViewById(R.id.tv_sure);
        mTvTitle = (TextView) dialog_view.findViewById(R.id.tv_title);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mTvTitle.setTextIsSelectable(true);
        }
        mTvContent = (TextView) dialog_view.findViewById(R.id.tv_content);
        mTvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mTvContent.setTextIsSelectable(true);
        }
        mIvLogo = (ImageView) dialog_view.findViewById(R.id.iv_logo);
        setContentView(dialog_view);
    }

    public SDEnsureSubDialog(Context context, int themeResId) {
        super(context, themeResId);
        initView();
    }

    public SDEnsureSubDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView();
    }

    public SDEnsureSubDialog(Context context) {
        super(context);
        initView();
    }

    public SDEnsureSubDialog(Activity context) {
        super(context);
        initView();
    }

    public SDEnsureSubDialog(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView();
    }

}
