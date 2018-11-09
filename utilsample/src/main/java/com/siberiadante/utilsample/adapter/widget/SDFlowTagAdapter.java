package com.siberiadante.utilsample.adapter.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.androidutil.util.SDToastUtil;
import com.siberiadante.androidutil.widget.flowLayout.SDFlowLayout;
import com.siberiadante.androidutil.widget.flowLayout.flowlayout.SDFlowAdapter;
import com.siberiadante.utilsample.R;


/**
 * create date: 2018/11/8
 */
public class SDFlowTagAdapter extends SDFlowAdapter {
    private String[] datas;
    public SDFlowTagAdapter(String[] datas) {
        this.datas = datas;
    }

    public void addData(String[] datas) {
        this.datas = datas;
    }

    @Override
    public View getView(SDFlowLayout parent, LayoutInflater inflater, int position) {
        TextView view = (TextView) inflater.inflate(R.layout.flow_tag_item, parent, false);
        view.setText(datas[position]);
        return view;
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public void onItemSelect(View view, int position) {
        view.setSelected(true);
        SDToastUtil.toast(datas[position]);
        SDLogUtil.d("FlowLayout", "--------------:" + datas[position]);
    }

    @Override
    public void onItemUnSelect(View view, int position) {
        view.setSelected(false);
    }
}
