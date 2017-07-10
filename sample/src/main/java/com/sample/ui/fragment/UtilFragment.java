package com.sample.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sample.R;
import com.sample.ui.activity.ActivityUtilActivity;
import com.sample.ui.activity.AppActivity;
import com.sample.ui.activity.ClearActivity;
import com.sample.ui.activity.DialogActivity;
import com.sample.ui.activity.NetworkActivity;
import com.sample.ui.activity.NumberActivity;
import com.sample.ui.activity.ScreenActivity;
import com.sample.ui.activity.ToastActivity;
import com.siberiadante.util.ScreenUtil;
import com.siberiadante.widget.TitleBar;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/6/30
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class UtilFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_util, container, false);

        initView(view);
        return view;

    }

    private void initView(View view) {
        Button mBtnActivityUtil = (Button) view.findViewById(R.id.start_activity_activity_util);
        Button mBtnScreenUtil = (Button) view.findViewById(R.id.start_activity_screen_util);
        Button mBtnNetworkUtil = (Button) view.findViewById(R.id.start_activity_network_util);
        Button mBtnToastUtil = (Button) view.findViewById(R.id.start_activity_toast_util);
        Button mBtnAppUtil = (Button) view.findViewById(R.id.start_activity_app_util);
        view.findViewById(R.id.start_activity_clear_util).setOnClickListener(this);
        view.findViewById(R.id.start_activity_number_util).setOnClickListener(this);
        final TitleBar mTitleBar = (TitleBar) view.findViewById(R.id.titleBar_fragment_util);
        initTitleBar(mTitleBar);


        mBtnActivityUtil.setOnClickListener(this);
        mBtnScreenUtil.setOnClickListener(this);
        mBtnNetworkUtil.setOnClickListener(this);
        mBtnToastUtil.setOnClickListener(this);
        mBtnAppUtil.setOnClickListener(this);
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
