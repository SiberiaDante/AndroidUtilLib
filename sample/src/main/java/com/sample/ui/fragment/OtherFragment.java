package com.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.R;
import com.sample.ui.BaseFragment;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/7/19
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class OtherFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_other, container, false);
        return layout;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initIntent() {

    }

    @Override
    protected void initData() {

    }
}
