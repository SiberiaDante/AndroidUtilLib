package com.sample.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sample.R;
import com.sample.constants.Constants;
import com.sample.ui.BaseFragment;
import com.sample.ui.activity.WebViewActivity;
import com.siberiadante.lib.util.ScreenUtil;
import com.siberiadante.lib.view.TitleBar;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/7/19
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class MainFragment extends BaseFragment implements View.OnClickListener {
    private Button mBtnRecyclerView, mBtnCustomView, mBtnRXJava;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_main, container, false);
        ScreenUtil.setStatusTranslucent(getActivity());
        return layout;
    }

    @Override
    protected void initView() {
        final TitleBar mTitleBar = (TitleBar) layout.findViewById(R.id.title_bar_main);
        mTitleBar.setImmersive(true);
        mTitleBar.setTitle("SiberiaDante");
        mBtnRecyclerView = (Button) layout.findViewById(R.id.btn_recycler_view_details);
        mBtnCustomView = (Button) layout.findViewById(R.id.btn_custom_view_details);
        mBtnRXJava = (Button) layout.findViewById(R.id.btn_rx_java);

        mBtnRecyclerView.setOnClickListener(this);
        mBtnCustomView.setOnClickListener(this);
        mBtnRXJava.setOnClickListener(this);

    }

    @Override
    protected void initIntent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        intent = new Intent(getActivity(), WebViewActivity.class);
        switch (view.getId()) {
            case R.id.btn_recycler_view_details:
                intent.putExtra("url", Constants.URL_RECYCLER_VIEW);
                intent.putExtra("title", mBtnRecyclerView.getText().toString());
                break;
            case R.id.btn_custom_view_details:
                intent.putExtra("url", Constants.URL_CUSTOM_VIEW);
                intent.putExtra("title", mBtnCustomView.getText().toString());
                break;
            case R.id.btn_rx_java:
                intent.putExtra("url", Constants.URL_RX_JAVA);
                intent.putExtra("title", mBtnRXJava.getText().toString());
                break;
        }
        startActivity(intent);

    }
}
