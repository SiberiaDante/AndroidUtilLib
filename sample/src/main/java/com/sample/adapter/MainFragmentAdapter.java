package com.sample.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.sample.R;
import com.sample.bean.MainData;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/14
 * @UpDate:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class MainFragmentAdapter extends RecyclerArrayAdapter<MainData> {

    public MainFragmentAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainFragmentHolder(parent);
    }

    public class MainFragmentHolder extends BaseViewHolder<MainData> {

        private TextView mTitle;

        public MainFragmentHolder(ViewGroup parent) {
            super(parent, R.layout.item);
            mTitle = $(R.id.btn_item);
        }

        @Override
        public void setData(MainData data) {
            super.setData(data);
            mTitle.setText(data.getTitle());
        }
    }

}
