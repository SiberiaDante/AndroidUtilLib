package com.sample.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.sample.R;
import com.sample.ui.activity.util.AppActivity;
import com.siberiadante.lib.util.SDLogUtil;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/7/19
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class OtherFragment extends LazyFragment {

    private static final String TAG = OtherFragment.class.getSimpleName();
    private Bundle savedInstanceState;

    public static OtherFragment getInstance(View view) {
        return new OtherFragment();
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_other);
        SDLogUtil.d("-------------OtherFragment----------------");
        initView();
    }

    protected void initView() {
        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AppActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: requestCode=" + requestCode + "---resultCode=" + resultCode);
        onCreate(savedInstanceState);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.d(TAG, "onAttachFragment: ");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        Log.d(TAG, "onCreate: ");
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: ");
    }

}
