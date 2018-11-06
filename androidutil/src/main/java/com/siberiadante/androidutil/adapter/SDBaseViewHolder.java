package com.siberiadante.androidutil.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * create date: 2018/11/6
 */
public class SDBaseViewHolder<M> extends RecyclerView.ViewHolder {
    public SDBaseViewHolder(View itemView) {
        super(itemView);
    }

    public SDBaseViewHolder(ViewGroup parent, @LayoutRes int res) {
        super(LayoutInflater.from(parent.getContext()).inflate(res, parent, false));
    }

    public void setData(M data) {
    }

    protected <T extends View> T $(@IdRes int id) {
        return itemView.findViewById(id);
    }

    protected Context getContext() {
        return itemView.getContext();
    }
}
