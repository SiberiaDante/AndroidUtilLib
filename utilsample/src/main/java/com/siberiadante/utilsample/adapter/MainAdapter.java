package com.siberiadante.utilsample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.siberiadante.androidutil.SDActivityUtil;
import com.siberiadante.androidutil.util.SDJumpUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.bean.DataBean;

import java.util.List;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/12/25
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<DataBean> mainDataList;
    private Context mContext;
    private LayoutInflater inflater;

    public MainAdapter(List<DataBean> mainDataList, Context context) {
        this.mainDataList = mainDataList;
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(inflater.inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position) {
        holder.textView.setText(mainDataList.get(position).getTitle());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SDJumpUtil.startActivity(mainDataList.get(position).getCls());

            }
        });

    }

    @Override
    public int getItemCount() {
        return mainDataList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MainViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item_title);
        }
    }
}
