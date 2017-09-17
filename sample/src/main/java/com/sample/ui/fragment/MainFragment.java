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
import com.sample.ui.BaseFragmentN;
import com.sample.ui.activity.WebViewActivity;
import com.siberiadante.lib.util.ScreenUtil;
import com.squareup.haha.perflib.Main;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/7/19
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class MainFragment extends LazyFragment implements View.OnClickListener {
    private Button mBtnLib, mBtnTitleLayout, mBtnRXJava;

    public static MainFragment getInstance() {
        return new MainFragment();
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_main);
        initView();
    }
    //    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        layout = inflater.inflate(R.layout.fragment_main, container, false);
//        ScreenUtil.setStatusTranslucent(getActivity());
//        return layout;
//    }

    protected void initView() {
        mBtnLib = (Button) findViewById(R.id.btn_siberia_dante_lib);
        mBtnTitleLayout = (Button) findViewById(R.id.btn_custom_title_layout);
        mBtnRXJava = (Button) findViewById(R.id.btn_rx_java);

        mBtnLib.setOnClickListener(this);
        mBtnTitleLayout.setOnClickListener(this);
        mBtnRXJava.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent intent;
        intent = new Intent(getActivity(), WebViewActivity.class);
        switch (view.getId()) {
            case R.id.btn_siberia_dante_lib:
                intent.putExtra("url", Constants.URL_SIBERIADANTE_LIB);
                intent.putExtra("title", mBtnLib.getText().toString());
                break;
            case R.id.btn_custom_title_layout:
                intent.putExtra("url", Constants.URL_TITLE_LAYOUT);
                intent.putExtra("title", mBtnTitleLayout.getText().toString());
                break;
//            case R.id.btn_rx_java:
//                intent.putExtra("url", Constants.URL_RX_JAVA);
//                intent.putExtra("title", mBtnRXJava.getText().toString());
//                break;
        }
        startActivity(intent);

    }
}