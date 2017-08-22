package com.sample.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sample.R;
import com.sample.ui.BaseFragment;
import com.sample.ui.activity.util.ActivityUtilActivity;
import com.sample.ui.activity.util.AppActivity;
import com.sample.ui.activity.util.ClearActivity;
import com.sample.ui.activity.util.NetworkActivity;
import com.sample.ui.activity.util.NumberActivity;
import com.sample.ui.activity.util.ScreenActivity;
import com.sample.ui.activity.util.ToastActivity;
import com.siberiadante.lib.view.TitleBar;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/6/30
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class UtilFragment extends BaseFragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_util, container, false);
        return layout;

    }

    @Override
    protected void initView() {
        Button mBtnActivityUtil = (Button) layout.findViewById(R.id.start_activity_activity_util);
        Button mBtnScreenUtil = (Button) layout.findViewById(R.id.start_activity_screen_util);
        Button mBtnNetworkUtil = (Button) layout.findViewById(R.id.start_activity_network_util);
        Button mBtnToastUtil = (Button) layout.findViewById(R.id.start_activity_toast_util);
        Button mBtnAppUtil = (Button) layout.findViewById(R.id.start_activity_app_util);
        layout.findViewById(R.id.start_activity_clear_util).setOnClickListener(this);
        layout.findViewById(R.id.start_activity_number_util).setOnClickListener(this);
        final TitleBar mTitleBar = (TitleBar) layout.findViewById(R.id.titleBar_fragment_util);
        initTitleBar(mTitleBar);
        mBtnActivityUtil.setOnClickListener(this);
        mBtnScreenUtil.setOnClickListener(this);
        mBtnNetworkUtil.setOnClickListener(this);
        mBtnToastUtil.setOnClickListener(this);
        mBtnAppUtil.setOnClickListener(this);
    }

    @Override
    protected void initIntent() {

    }

    @Override
    protected void initData() {

    }


    private void initTitleBar(TitleBar mTitleBar) {
        mTitleBar.setImmersive(true);
        mTitleBar.setTitle("SiberiaDante");
        mTitleBar.setRightImage(R.mipmap.search);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.start_activity_screen_util:
                intent = new Intent(getActivity(), ScreenActivity.class);
                break;
            case R.id.start_activity_activity_util:
                intent = new Intent(getActivity(), ActivityUtilActivity.class);
                break;
            case R.id.start_activity_network_util:
                intent = new Intent(getActivity(), NetworkActivity.class);
                break;
            case R.id.start_activity_toast_util:
                intent = new Intent(getActivity(), ToastActivity.class);
                break;
            case R.id.start_activity_app_util:
                intent = new Intent(getActivity(), AppActivity.class);
                break;
            case R.id.start_activity_clear_util:
                intent = new Intent(getActivity(), ClearActivity.class);
                break;
            case R.id.start_activity_number_util:
                intent = new Intent(getActivity(), NumberActivity.class);
                break;
        }
        startActivity(intent);
    }
}
