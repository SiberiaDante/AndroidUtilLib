package com.siberiadante.utilsample.adapter.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.siberiadante.androidutil.adapter.recycleradapter.SDBaseViewHolder;
import com.siberiadante.androidutil.adapter.recycleradapter.SDRecyclerViewAdapter;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.bean.document.DocumentList;

/**
 * create date: 2018/11/3
 */
public class SDRVAdapter extends SDRecyclerViewAdapter<DocumentList> {

    public SDRVAdapter(Context context) {
        super(context);
    }

    @Override
    public SDBaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new DocViewHolder(parent);
    }

    private class DocViewHolder extends SDBaseViewHolder<DocumentList> {
        TextView tvDocument;
        private DocViewHolder(ViewGroup parent) {
            super(parent, R.layout.list_document_item);
            tvDocument = $(R.id.tv_document);
        }

        @Override
        public void setData(DocumentList data) {
            super.setData(data);
            tvDocument.setText(data.getTitle());
        }
    }

}
