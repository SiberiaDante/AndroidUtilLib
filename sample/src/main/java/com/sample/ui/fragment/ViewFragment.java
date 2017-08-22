package com.sample.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.R;
import com.sample.ui.BaseFragment;
import com.sample.ui.activity.view.DialogActivity;
import com.sample.ui.activity.view.ImageSpanActivity;
import com.sample.ui.activity.view.QQStepViewActivity;
import com.siberiadante.lib.util.ScreenUtil;
import com.siberiadante.lib.view.TitleBar;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/6/30
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class ViewFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = ViewFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_view, container, false);
        ScreenUtil.setStatusTranslucent(getActivity());
        return layout;
    }

    @Override
    protected void initView() {
        layout.findViewById(R.id.btn_start_general_dialog_activity).setOnClickListener(this);
        layout.findViewById(R.id.btn_start_qq_exercise__activity).setOnClickListener(this);
        layout.findViewById(R.id.btn_start_image_span__activity).setOnClickListener(this);
        TitleBar titleBar = ((TitleBar) layout.findViewById(R.id.titleBar));
        initTitleBar(titleBar);
    }

    @Override
    protected void initIntent() {

    }

    @Override
    protected void initData() {

    }

    private void initTitleBar(TitleBar titleBar) {
        titleBar.setImmersive(true);
        titleBar.setTitle("SiberiaDante");
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_start_general_dialog_activity:
                intent = new Intent(getActivity(), DialogActivity.class);
                break;
            case R.id.btn_start_qq_exercise__activity:
                intent = new Intent(getActivity(), QQStepViewActivity.class);
                break;
            case R.id.btn_start_image_span__activity:
                intent = new Intent(getActivity(), ImageSpanActivity.class);
                break;
        }
        startActivity(intent);
    }
}
