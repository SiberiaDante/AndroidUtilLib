package com.siberiadante.custom.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.siberiadante.custom.ui.adapter.base.MultiTypeSupport;
import com.siberiadante.custom.ui.adapter.base.ViewHolder;
import com.siberiadante.lib.util.LogUtil;

import java.util.List;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/29
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public abstract class WrapRecyclerViewAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<T> mData;
    // 布局怎么办？
    private int mLayoutId;
    // 多布局支持
    private MultiTypeSupport mMultiTypeSupport;

    public WrapRecyclerViewAdapter(Context mContext, List<T> mData, int resId) {
        this.mContext = mContext;
        this.mData = mData;
        this.mLayoutId = resId;
        this.mInflater = LayoutInflater.from(mContext);
    }

    public WrapRecyclerViewAdapter(Context context, List<T> data, MultiTypeSupport mMultiTypeSupport) {
        this(context, data, -1);
        this.mMultiTypeSupport = mMultiTypeSupport;
    }

    @Override
    public int getItemViewType(int position) {

        if (mMultiTypeSupport != null) {
            return mMultiTypeSupport.getLayoutId(mData.get(position), position);
        }
        return super.getItemViewType(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//        View view = mInflater.inflate(resId, parent, false);
//        LogUtil.d("onCreateViewHolder");
//        return new ViewHolder(view);
        if (mMultiTypeSupport != null) {
            mLayoutId = viewType;
        }
        final View view = mInflater.inflate(mLayoutId, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        LogUtil.d("onBindViewHolder");
        convert(holder, mData.get(position));
    }

    abstract void convert(ViewHolder holder, T item);

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

//    /***************
//     * 设置条目点击和长按事件
//     *********************/
//    public AdapterView.OnItemClickListener mItemClickListener;
//    public View.OnLongClickListener mLongClickListener;
//
//    public void setOnItemClickListener(AdapterView.OnItemClickListener itemClickListener) {
//        this.mItemClickListener = itemClickListener;
//    }
//
//    public void setOnLongClickListener(View.OnLongClickListener longClickListener) {
//        this.mLongClickListener = longClickListener;
//    }

//    public interface OnItemClickListener {
//        void setOnItemClickListener(AdapterView.OnItemClickListener listener);
//    }
//
//    public interface OnLongClickListener {
//
//}
}
