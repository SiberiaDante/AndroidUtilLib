package com.sample.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.R;
import com.sample.constants.Constants;
import com.sample.util.JumpUtils;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/15
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class LeftDrawFragment extends LazyFragment implements View.OnClickListener {
    public static LeftDrawFragment getInstance() {
        return new LeftDrawFragment();
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_left_draw);
        initView();
    }


    protected void initView() {
        findViewById(R.id.ll_github).setOnClickListener(this);
        findViewById(R.id.ll_blog).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_github:
                startBrowser(Constants.GIT_HUB);
                break;
            case R.id.ll_blog:
                startBrowser(Constants.B_LOG);
                break;
        }
    }

    public void startBrowser(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }
}
