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

public class ThreeFragment extends LazyFragment {
    public static final String TAG = ThreeFragment.class.getSimpleName();

    public static ThreeFragment getInstance(int type) {

        return new ThreeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_three);
        ToastUtil.toast("第三个页面");

        Log.d(TAG, "onCreateViewLazy: FragmentThree");
    }
}
