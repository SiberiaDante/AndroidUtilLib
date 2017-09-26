package com.siberiadante.custom.ui.fragment;

import android.os.Bundle;
import android.util.Log;

import com.siberiadante.custom.R;
import com.siberiadante.lib.util.SDToastUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/8
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class FourFragment extends LazyFragment {
    public static final String TAG = FourFragment.class.getSimpleName();

    public static FourFragment getInstance() {

        return new FourFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_four);
        SDToastUtil.toast("第四个页面");

        Log.d(TAG, "onCreateViewLazy: FragmentFour");
    }
}
