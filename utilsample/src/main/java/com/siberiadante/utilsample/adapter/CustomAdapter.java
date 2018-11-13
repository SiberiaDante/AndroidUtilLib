//package com.siberiadante.utilsample.adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.BaseView;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//
//import java.util.List;
//
///**
// * Created: SiberiaDante
// * Describe：
// * CreateTime: 2017/12/22
// * UpDateTime:
// * Email: 2654828081@qq.com
// * GitHub: https://github.com/SiberiaDante
// * Blog: http://www.cnblogs.com/shen-hua/
// */
//
//public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
//
//    private Context mContext;
//    private List<BaseData> mData;
//    private LayoutInflater inflater;
//
//    public CustomAdapter(Context mContext, List<BaseData> mData) {
//        this.mContext = mContext;
//        this.mData = mData;
//        inflater = LayoutInflater.from(mContext);
//    }
//
//    @Override
//    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        BaseView view = inflater.inflate(R.layout.item_custom, parent, false);
//        return new CustomViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(CustomViewHolder holder, final int position) {
//        holder.textView.setText(mData.get(position).getTitle());
//
//        holder.textView.setOnClickListener(new BaseView.OnClickListener() {
//            @Override
//            public void onClick(BaseView v) {
//                mContext.startActivity(new Intent(mContext, mData.get(position).getCls()));
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mData.size();
//    }
//
//    public class CustomViewHolder extends RecyclerView.ViewHolder {
//
//        TextView textView;
//
//        public CustomViewHolder(BaseView itemView) {
//            super(itemView);
//            textView = itemView.findViewById(R.id.tv_item);
//        }
//    }
//}
