package com.siberiadante.utilsample.adapter.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDToastUtil;
import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.utilsample.R;


import java.util.ArrayList;
import java.util.List;


public class SDFlowTabLayoutAdapter extends BaseAdapter {
    private static final String TAG = SDFlowTabLayoutAdapter.class.getSimpleName();
    private List<String> data;

    private Context context;
    private LayoutInflater inflater;

    public SDFlowTabLayoutAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_sd_flow_tab_label_tv, null);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.tv_label);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(data.get(position));
        SDLogUtil.d(TAG, "---------------------------" + data.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SDToastUtil.toast(data.get(position));
            }
        });
        return convertView;
    }

    public void addAllData(List<String> allSearch) {
        data.clear();
        data.addAll(allSearch);
        notifyDataSetChanged();
    }

    public void clearAll() {
        data.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder {
        TextView textView;
    }

}
