package com.siberiadante.custom.ui.fragment;

import android.os.Bundle;
import android.util.Log;

import com.siberiadante.custom.R;
import com.siberiadante.util.ToastUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/8
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class OneFragment extends LazyFragment {
    public static final String TAG = OneFragment.class.getSimpleName();

    public static OneFragment getInstance() {

        return new OneFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_one);
        ToastUtil.toast("第一个页面");
        Log.d(TAG, "onCreateViewLazy: FragmentOne");
    }
}
