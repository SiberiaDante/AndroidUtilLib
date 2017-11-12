package com.sample.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.sample.R;
import com.sample.bean.Data;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/14
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class CustomAdapter extends RecyclerArrayAdapter<Data> {

    public CustomAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new UtilHolder(parent);
    }

    public class UtilHolder extends BaseViewHolder<Data> {

        private TextView mTitle;

        public UtilHolder(ViewGroup parent) {
            super(parent, R.layout.item);
            mTitle = $(R.id.btn_item);
        }

        @Override
        public void setData(Data data) {
            super.setData(data);
            mTitle.setText(data.getTitle());
        }
    }

}
