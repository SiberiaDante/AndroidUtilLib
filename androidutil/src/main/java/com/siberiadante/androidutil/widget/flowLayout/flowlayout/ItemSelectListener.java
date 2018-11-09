package com.siberiadante.androidutil.widget.flowLayout.flowlayout;

import android.view.View;


public interface ItemSelectListener {

    /**
     * 标签选中
     *
     * @param view     标签
     * @param position 标签位置
     */
    void onItemSelect(View view, int position);

    /**
     * 标签取消选中
     *
     * @param view     标签
     * @param position 标签位置
     */
    void onItemUnSelect(View view, int position);

    /**
     * 标签不能被选中
     *
     * @param view     标签
     * @param position 不能选中的标签位置
     */
    void canNotSelect(View view, int position);

    /**
     * 超出设置的最大选中数量
     *
     * @param limit 最大选中数量
     */
    void onExceedsLimit(int limit);
}
