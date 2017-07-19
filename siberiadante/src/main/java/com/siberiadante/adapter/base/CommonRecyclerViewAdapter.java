//package com.siberiadante.adapter.base;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.util.SparseArray;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import java.util.List;
//
///**
// * @Created SiberiaDante
// * @Describe： RecyclerView 适配器的封装
// * @Time: 2017/7/19
// * @Email: 994537867@qq.com
// * @GitHub: https://github.com/SiberiaDante
// */
//
//public abstract class CommonRecyclerViewAdapter<T> extends RecyclerView.Adapter<CommonRecyclerViewAdapter.ViewHolder> {
//
//    private Context mContext;
//    private LayoutInflater mInflater;
//    private List<T> mData;//数据怎么办？利用泛型
//    private int mLayoutId;// 布局怎么办？直接从构造里面传递
//    // 多布局支持
//    private MultiTypeSupport mMultiTypeSupport;
//
//    public CommonRecyclerViewAdapter(Context context, List<T> data, int layoutId) {
//        this.mContext = context;
//        this.mData = data;
//        this.mLayoutId = layoutId;
//        this.mInflater = LayoutInflater.from(context);
//    }
//
//    /**
//     * 多布局支持
//     */
//    public CommonRecyclerViewAdapter(Context context, List<T> data, MultiTypeSupport<T> multiTypeSupport) {
//        this(context, data, -1);
//        this.mMultiTypeSupport = multiTypeSupport;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        // 多布局支持
//        if (mMultiTypeSupport != null) {
//            mLayoutId = viewType;
//        }
//        View inflate = mInflater.inflate(mLayoutId, parent, false);
//        return new ViewHolder(inflate);
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        // 多布局支持
//        if (mMultiTypeSupport != null) {
//            return mMultiTypeSupport.getLayoutId(mData.get(position), position);
//        }
//
//        return super.getItemViewType(position);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, final int position) {
//        // 设置点击和长按事件
//        if (mItemClickListener != null) {
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mItemClickListener.onItemClick(position);
//                }
//            });
//        }
//        if (mLongClickListener != null) {
//            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    return mLongClickListener.onLongClick(position);
//                }
//            });
//        }
//        // 绑定怎么办？回传出去
//        convert(holder, mData.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mData != null ? mData.size() : 0;
//    }
//
//    public abstract void convert(ViewHolder viewHolder, T item);
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        private SparseArray<View> mViews;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            mViews = new SparseArray<>();
//        }
//
//        public <T extends View> T getView(int resId) {
//            View view = mViews.get(resId);
//            if (view == null) {
//                view = itemView.findViewById(resId);
//                mViews.put(resId, view);
//            }
//            return (T) view;
//        }
//    }
//
//    /***************
//     * 设置条目点击和长按事件
//     *********************/
//    public OnItemClickListener mItemClickListener;
//    public OnLongClickListener mLongClickListener;
//
//    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
//        this.mItemClickListener = itemClickListener;
//    }
//
//    public void setOnLongClickListener(OnLongClickListener longClickListener) {
//        this.mLongClickListener = longClickListener;
//    }
//
//    public interface OnItemClickListener {
//        void onItemClick(int position);
//    }
//
//    public interface OnLongClickListener {
//        boolean onLongClick(int position);
//    }
//
//    public interface MultiTypeSupport<T> {
//        // 根据当前位置或者条目数据返回布局
//        int getLayoutId(T item, int position);
//    }
//}
