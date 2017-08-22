package com.siberiadante.custom.ui.fragment;

import android.os.Bundle;
import android.util.Log;

import com.siberiadante.custom.R;
import com.siberiadante.lib.util.ToastUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/8
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class TwoFragment extends LazyFragment {
    public static final String TAG = TwoFragment.class.getSimpleName();

    public static TwoFragment getInstance() {

        return new TwoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_two);
        ToastUtil.toast("第二个页面");

        Log.d(TAG, "onCreateViewLazy: FragmentTwo");
    }
}
