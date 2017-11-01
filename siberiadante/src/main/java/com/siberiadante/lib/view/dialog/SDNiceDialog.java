package com.siberiadante.lib.view.dialog;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.siberiadante.lib.view.base.nicedialog.BaseNiceDialog;
import com.siberiadante.lib.view.base.nicedialog.ViewConvertListener;
import com.siberiadante.lib.view.base.nicedialog.ViewHolder;

/**
 * @Created SiberiaDante
 * @Describe： 原作者GitHub代码地址: https://github.com/Othershe/SDNiceDialog
 * @Time: 2017/8/10
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDNiceDialog extends BaseNiceDialog {
    private ViewConvertListener convertListener;

    public static SDNiceDialog init() {
        return new SDNiceDialog();
    }

    @Override
    public int intLayoutId() {
        return layoutId;
    }

    @Override
    public void convertView(ViewHolder holder, BaseNiceDialog dialog) {
        if (convertListener != null) {
            convertListener.convertView(holder, dialog);
        }
    }


    public SDNiceDialog setLayoutId(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    public SDNiceDialog setConvertListener(ViewConvertListener convertListener) {
        this.convertListener = convertListener;
        return this;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            convertListener = (ViewConvertListener) savedInstanceState.getSerializable("listener");
        }
    }

    /**
     * 保存接口
     *
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("listener", convertListener);
    }
}