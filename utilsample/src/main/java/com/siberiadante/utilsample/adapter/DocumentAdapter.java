package com.siberiadante.utilsample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.bean.document.DocumentList;

import java.util.List;

/**
 * create date: 2018/11/3
 */
public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder> {
    private List<DocumentList> mDocumentLists;

    public void setDocumentLists(List<DocumentList> documentLists) {
        this.mDocumentLists = documentLists;
        notifyDataSetChanged();
    }

    public void addDocumentLists(List<DocumentList> documentLists) {
        if (documentLists != null) {
            mDocumentLists.addAll(documentLists);
        }
        notifyDataSetChanged();
    }

    @Override
    public DocumentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_document_item, null);
        return new DocumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DocumentViewHolder holder, int position) {
        holder.tvDocument.setText(mDocumentLists.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mDocumentLists != null ? mDocumentLists.size() : 0;
    }

    class DocumentViewHolder extends RecyclerView.ViewHolder {

        TextView tvDocument;

        public DocumentViewHolder(View itemView) {
            super(itemView);
            tvDocument = itemView.findViewById(R.id.tv_document);
        }
    }
}
