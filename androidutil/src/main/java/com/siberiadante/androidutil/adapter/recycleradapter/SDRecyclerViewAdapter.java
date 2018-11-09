package com.siberiadante.androidutil.adapter.recycleradapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.siberiadante.androidutil.BuildConfig;
import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.androidutil.widget.recyclerview.SDRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * create date: 2018/11/6
 */
public abstract class SDRecyclerViewAdapter<M> extends RecyclerView.Adapter<SDBaseViewHolder> {
    private static final String TAG = SDRecyclerView.class.getName();
    protected OnItemClickListener mItemClickListener;
    protected OnItemLongClickListener mItemLongClickListener;
    protected List<M> mObjects;
    protected ArrayList<ItemView> headers = new ArrayList<>();
    protected ArrayList<ItemView> footers = new ArrayList<>();
    private final Object mLock = new Object();
    private boolean mNotifyOnChange = true;
    private Context mContext;

    abstract public SDBaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType);

    public SDRecyclerViewAdapter(Context context) {
        init(context, new ArrayList<M>());
    }

    public SDRecyclerViewAdapter(Context context, M[] objects) {
        init(context, Arrays.asList(objects));
    }

    public SDRecyclerViewAdapter(Context context, List<M> objects) {
        init(context, objects);
    }

    private void init(Context context, List<M> objects) {
        mContext = context;
        mObjects = new ArrayList<>(objects);
    }

    @Override
    public SDBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = createSpViewByType(parent, viewType);
        if (view != null) {
            return new StateViewHolder(view);
        }

        final SDBaseViewHolder viewHolder = OnCreateViewHolder(parent, viewType);

        //itemView 的点击事件
        if (mItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(viewHolder.getAdapterPosition() - headers.size());
                }
            });
        }

        if (mItemLongClickListener != null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return mItemLongClickListener.onItemLongClick(viewHolder.getAdapterPosition() - headers.size());
                }
            });
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SDBaseViewHolder holder, int position) {
        holder.itemView.setId(position);
        if (headers.size() != 0 && position < headers.size()) {
            headers.get(position).onBindView(holder.itemView);
            return;
        }

        int i = position - headers.size() - mObjects.size();
        if (footers.size() != 0 && i >= 0) {
            footers.get(i).onBindView(holder.itemView);
            return;
        }
        OnBindViewHolder(holder, position - headers.size());
    }
    private void OnBindViewHolder(SDBaseViewHolder holder, final int position) {
        holder.setData(getItem(position));
    }

    @Override
    public int getItemCount() {
        return mObjects.size() + headers.size() + footers.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (headers.size() != 0) {
            if (position < headers.size()) return headers.get(position).hashCode();
        }
        if (footers.size() != 0) {
            /*
            eg:
            0:header1
            1:header2   2
            2:object1
            3:object2
            4:object3
            5:object4
            6:footer1   6(position) - 2 - 4 = 0
            7:footer2
             */
            int i = position - headers.size() - mObjects.size();
            if (i >= 0) {
                return footers.get(i).hashCode();
            }
        }
        return getViewType(position - headers.size());
    }

    private int getViewType(int position) {
        return 0;
    }

    private M getItem(int position) {
        return mObjects.get(position);
    }

    private View createSpViewByType(ViewGroup parent, int viewType) {
        for (ItemView headerView : headers) {
            if (headerView.hashCode() == viewType) {
                View view = headerView.onCreateView(parent);
                StaggeredGridLayoutManager.LayoutParams layoutParams;
                if (view.getLayoutParams() != null)
                    layoutParams = new StaggeredGridLayoutManager.LayoutParams(view.getLayoutParams());
                else
                    layoutParams = new StaggeredGridLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.setFullSpan(true);
                view.setLayoutParams(layoutParams);
                return view;
            }
        }
        for (ItemView footerview : footers) {
            if (footerview.hashCode() == viewType) {
                View view = footerview.onCreateView(parent);
                StaggeredGridLayoutManager.LayoutParams layoutParams;
                if (view.getLayoutParams() != null)
                    layoutParams = new StaggeredGridLayoutManager.LayoutParams(view.getLayoutParams());
                else
                    layoutParams = new StaggeredGridLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.setFullSpan(true);
                view.setLayoutParams(layoutParams);
                return view;
            }
        }
        return null;
    }

    public int getCount() {
        return mObjects.size();
    }

    private static void log(String content) {
        if (BuildConfig.DEBUG) {
            SDLogUtil.i(TAG, content);
        }
    }

    public void addHeader(ItemView view) {
        if (view == null) throw new NullPointerException("ItemView can't be null");
        headers.add(view);
        notifyItemInserted(headers.size() - 1);
    }

    public void addFooter(ItemView view) {
        if (view == null) throw new NullPointerException("ItemView can't be null");
        footers.add(view);
        notifyItemInserted(headers.size() + getCount() + footers.size() - 1);
    }

    public void removeAllHeader() {
        int count = headers.size();
        headers.clear();
        notifyItemRangeRemoved(0, count);
    }

    public void removeAllFooter() {
        int count = footers.size();
        footers.clear();
        notifyItemRangeRemoved(headers.size() + getCount(), count);
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<M> getAllData() {
        return new ArrayList<>(mObjects);
    }

    public void add(M object) {
        if (object != null) {
            synchronized (mLock) {
                mObjects.add(object);
            }
        }
        if (mNotifyOnChange) notifyItemInserted(headers.size() + getCount());
        log("add notifyItemInserted " + (headers.size() + getCount()));
    }

    public void addAll(Collection<? extends M> collection) {
        if (collection != null && collection.size() != 0) {
            synchronized (mLock) {
                mObjects.addAll(collection);
            }
        }
        int dataCount = collection == null ? 0 : collection.size();
        if (mNotifyOnChange)
            notifyItemRangeInserted(headers.size() + getCount() - dataCount, dataCount);
        log("addAll notifyItemRangeInserted " + (headers.size() + getCount() - dataCount) + "," + (dataCount));
    }

    public void addAll(M[] items) {
        if (items != null && items.length != 0) {
            synchronized (mLock) {
                Collections.addAll(mObjects, items);
            }
        }
        int dataCount = items == null ? 0 : items.length;
        if (mNotifyOnChange)
            notifyItemRangeInserted(headers.size() + getCount() - dataCount, dataCount);
        log("addAll notifyItemRangeInserted " + ((headers.size() + getCount() - dataCount) + "," + (dataCount)));
    }

    public void insert(M object, int index) {
        synchronized (mLock) {
            mObjects.add(index, object);
        }
        if (mNotifyOnChange) notifyItemInserted(headers.size() + index);
        log("insert notifyItemRangeInserted " + (headers.size() + index));
    }

    public void insertAll(M[] object, int index) {
        synchronized (mLock) {
            mObjects.addAll(index, Arrays.asList(object));
        }
        int dataCount = object == null ? 0 : object.length;
        if (mNotifyOnChange) notifyItemRangeInserted(headers.size() + index, dataCount);
        log("insertAll notifyItemRangeInserted " + ((headers.size() + index) + "," + (dataCount)));
    }

    public void insertAll(Collection<? extends M> object, int index) {
        synchronized (mLock) {
            mObjects.addAll(index, object);
        }
        int dataCount = object == null ? 0 : object.size();
        if (mNotifyOnChange) notifyItemRangeInserted(headers.size() + index, dataCount);
        log("insertAll notifyItemRangeInserted " + ((headers.size() + index) + "," + (dataCount)));
    }

    public void update(M object, int pos) {
        synchronized (mLock) {
            mObjects.set(pos, object);
        }
        if (mNotifyOnChange) notifyItemChanged(pos);
        log("insertAll notifyItemChanged " + pos);
    }

    public void remove(M object) {
        int position = mObjects.indexOf(object);
        synchronized (mLock) {
            if (mObjects.remove(object)) {
                if (mNotifyOnChange) notifyItemRemoved(headers.size() + position);
                log("remove notifyItemRemoved " + (headers.size() + position));
            }
        }
    }

    public void remove(int position) {
        synchronized (mLock) {
            mObjects.remove(position);
        }
        if (mNotifyOnChange) notifyItemRemoved(headers.size() + position);
        log("remove notifyItemRemoved " + (headers.size() + position));
    }

    public void removeAll() {
        int count = mObjects.size();
        synchronized (mLock) {
            mObjects.clear();
        }
        if (mNotifyOnChange) notifyItemRangeRemoved(headers.size(), count);
        log("clear notifyItemRangeRemoved " + (headers.size()) + "," + (count));
    }

    public void clear() {
        int count = mObjects.size();
        synchronized (mLock) {
            mObjects.clear();
        }
        if (mNotifyOnChange) notifyDataSetChanged();
        log("clear notifyItemRangeRemoved " + (headers.size()) + "," + (count));
    }

    public void setNotifyOnChange(boolean notifyOnChange) {
        this.mNotifyOnChange = notifyOnChange;
    }

    private class StateViewHolder extends SDBaseViewHolder {
        private StateViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface ItemView {
        View onCreateView(ViewGroup parent);

        void onBindView(View headerView);
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.mItemLongClickListener = listener;
    }

}
