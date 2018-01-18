package com.siberiadante.utilsample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.fragment.base.BaseFragment;


/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/12/22
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */

public class PracticeFragment extends BaseFragment {

    public static PracticeFragment getInstance() {
        return new PracticeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_practice;
    }

    @Override
    protected void initViews(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }
}
