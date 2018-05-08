package com.siberiadante.androidutil.widget.flowLayout.sdflowtaglistener;

import android.view.View;

import com.siberiadante.androidutil.widget.flowLayout.SDFlowTagLayout;


public interface OnTagClickListener {
    void onItemClick(SDFlowTagLayout parent, View view, int position);
}
