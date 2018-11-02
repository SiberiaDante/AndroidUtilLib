package com.siberiadante.androidutil.widget.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * create date: 2018/11/2
 */
public class SDRecyclerView extends RecyclerView {
    public SDRecyclerView(Context context) {
        super(context);
    }

    public SDRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SDRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    //方法1：是否滑到屏幕底部
    public boolean isSlipToBottom() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) getLayoutManager();
        //屏幕中最后一个可见子项的position（最后一个子项高度大于屏幕高度时同样会被判断为到达屏幕底部）
        int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
        //当前屏幕所看到的子项个数
        int visibleItemCount = layoutManager.getChildCount();
        //当前RecyclerView的所有子项个数
        int totalItemCount = layoutManager.getItemCount();
        //RecyclerView的滑动状态
        int state = getScrollState();
        return visibleItemCount > 0 && lastVisibleItemPosition == totalItemCount - 1 && state == RecyclerView.SCROLL_STATE_IDLE;
    }

    /**
     * 方法2：是否滑到屏幕底部
     * 方法3：使用系统方案
     * RecyclerView.canScrollVertically(1)的值表示是否能向上滚动，false表示已经滚动到底部
     * RecyclerView.canScrollVertically(-1)的值表示是否能向下滚动，false表示已经滚动到顶部
     */

    public boolean isSlipBottom() {
        /*
        computeVerticalScrollExtent()是当前屏幕显示的区域高度；
        computeVerticalScrollOffset() 是当前屏幕之前滑过的距离；
        computeVerticalScrollRange()是整个View控件的高度；
         */
        return computeVerticalScrollExtent() + computeVerticalScrollOffset() >= computeVerticalScrollRange();
    }
}
