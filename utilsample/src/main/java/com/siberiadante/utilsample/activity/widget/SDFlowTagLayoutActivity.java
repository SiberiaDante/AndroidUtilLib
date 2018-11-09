package com.siberiadante.utilsample.activity.widget;

import android.os.Bundle;

import com.siberiadante.androidutil.widget.flowLayout.SDFlowLayout;
import com.siberiadante.androidutil.widget.flowLayout.SDFlowTagLayout;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;
import com.siberiadante.utilsample.adapter.widget.SDFlowTabLayoutAdapter;
import com.siberiadante.utilsample.adapter.widget.SDFlowTagAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SDFlowTagLayoutActivity extends BaseActivity {
    @BindView(R.id.sd_flow_tab_layout)
    SDFlowTagLayout sdFlowTagLayout;
    @BindView(R.id.sd_flow_default)
    SDFlowLayout sdFlowDefault;
    @BindView(R.id.sd_flow_single_choose)
    SDFlowLayout sdFlowSingleChoose;
    @BindView(R.id.sd_flow_mul_choose)
    SDFlowLayout sdFlowMulChoose;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdflow_tag_layout;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle(R.string.sd_flow_tab_layout);
        SDFlowTabLayoutAdapter adapter = new SDFlowTabLayoutAdapter(this);
        sdFlowTagLayout.setAdapter(adapter);
//        List<String> stringList = new ArrayList<>();
//        stringList.add("SiberiaDante");
//        stringList.add("JavaScript");
//        stringList.add("Kotlin");
//        stringList.add("Java");
//        stringList.add("PHP");
//        stringList.add("CSS");
//        stringList.add("Go");
//        stringList.add("Python");
//        stringList.add("HTML");
        String[] data = new String[]{"SiberiaDante", "JavaScript", "Kotlin", "Java", "PHP", "CSS", "Go", "Python", "HTML"};
        adapter.addAllData(Arrays.asList(data));

        sdFlowDefault.setAdapter(new SDFlowTagAdapter(data));
        SDFlowTagAdapter adapterSingle = new SDFlowTagAdapter(data);
        sdFlowSingleChoose.setAdapter(adapterSingle, 0);

        SDFlowTagAdapter adapterMul = new SDFlowTagAdapter(data);
        List<Integer> selected = new ArrayList<>();
        selected.add(1);
        selected.add(3);
        sdFlowMulChoose.setAdapter(adapterMul, selected);
    }
}
