package com.siberiadante.androidutil.widget.flowLayout.sdflowtaglistener;

import com.siberiadante.androidutil.widget.flowLayout.SDFlowTagLayout;

import java.util.List;

public interface OnTagSelectListener {
    void onItemSelect(SDFlowTagLayout parent, List<Integer> selectedList);
}
