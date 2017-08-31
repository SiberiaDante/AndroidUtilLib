package com.siberiadante.custom.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.siberiadante.custom.R;
import com.siberiadante.custom.bean.NewsData;
import com.siberiadante.custom.ui.adapter.base.ViewHolder;
import com.siberiadante.lib.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/29
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class NewsAdapter extends WrapRecyclerViewAdapter<NewsData> {
    private static final String TAG = NewsAdapter.class.getSimpleName();
    private List<NewsData> item;

    public NewsAdapter(Context mContext, List<NewsData> mData) {
        super(mContext, mData, R.layout.item_news_one);
        if (mData != null) {
            this.item = mData;
        } else {
            this.item = new ArrayList<>();
        }
    }

    @Override
    void convert(ViewHolder holder, NewsData item) {
        LogUtil.d(TAG, "3");
        TextView textView = holder.getView(R.id.tv_news_title_one);
        textView.setText(item.getTitle());
//        holder.setText(R.id.tv_news_title_one, item.getTitle());
        holder.setText(R.id.tv_news_des_one, item.getDescription());
        LogUtil.d(TAG, item.getTitle());
    }

    public void addRes(List<NewsData> data) {
        LogUtil.d(TAG, "1");
        if (data != null) {
            item.clear();
            item.addAll(data);
            notifyDataSetChanged();
        }
    }


}
