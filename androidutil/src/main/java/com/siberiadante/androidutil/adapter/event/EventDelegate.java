package com.siberiadante.androidutil.adapter.event;

/**
 * create date: 2018/11/6
 */
public interface EventDelegate {
    void addData(int length);
    void clear();

    void stopLoadMore();
    void pauseLoadMore();
    void resumeLoadMore();

//    void setMore(View view, SDRecyclerViewAdapter.OnMoreListener listener);
//    void setNoMore(View view, SDRecyclerViewAdapter.OnNoMoreListener listener);
//    void setErrorMore(View view, SDRecyclerViewAdapter.OnErrorListener listener);
//    void setMore(int res, SDRecyclerViewAdapter.OnMoreListener listener);
//    void setNoMore(int res, SDRecyclerViewAdapter.OnNoMoreListener listener);
//    void setErrorMore(int res, SDRecyclerViewAdapter.OnErrorListener listener);
}
