package com.siberiadante.utilsample.activity.widget;

import android.os.Bundle;

import com.siberiadante.androidutil.widget.flowLayout.SDFlowTagLayout;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;
import com.siberiadante.utilsample.adapter.widget.SDFlowTabLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SDFlowTagLayoutActivity extends BaseActivity {
    @BindView(R.id.sd_flow_tab_layout)
    SDFlowTagLayout sdFlowTagLayout;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdflow_tag_layout;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle(R.string.sd_flow_tab_layout);
        SDFlowTabLayoutAdapter adapter = new SDFlowTabLayoutAdapter(this);
        sdFlowTagLayout.setAdapter(adapter);
        List<String> stringList = new ArrayList<>();
        stringList.add("SiberiaDante");
        stringList.add("JavaScript");
        stringList.add("Kotlin");
        stringList.add("Java");
        stringList.add("PHP");
        stringList.add("CSS");
        stringList.add("Go");
        stringList.add("Python");
        stringList.add("HTML");
        adapter.addAllData(stringList);
    }
}
