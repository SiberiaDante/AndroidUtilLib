package com.siberiadante.custom.ui.adapter.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/29
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;

    public ViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }

    public <T extends View> T getView(int resId) {
        View view = mViews.get(resId);
        if (view == null) {
            view = itemView.findViewById(resId);
            mViews.put(resId, view);
        }
        return (T) view;
    }

    public ViewHolder setText(int resId, CharSequence text) {
        TextView textView = getView(resId);
        textView.setText(text);
        return this;
    }

    public ViewHolder setViewVisibility(int resId, int visibility) {
        getView(resId).setVisibility(visibility);
        return this;
    }

    public void setOnItemClickListener(View.OnClickListener clickListener) {
        itemView.setOnClickListener(clickListener);
    }

    public void setOnItemLongClickListener(View.OnLongClickListener clickListener) {
        itemView.setOnLongClickListener(clickListener);
    }
}
