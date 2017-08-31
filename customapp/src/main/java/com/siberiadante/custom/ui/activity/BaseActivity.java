package com.siberiadante.custom.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/7
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public abstract class BaseActivity extends AppCompatActivity {
    public static final String TAG = BaseActivity.class.getSimpleName();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContentView();
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        initView(savedInstanceState);
        initData();
    }

    protected abstract void beforeSetContentView();

    protected abstract int setLayoutId();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initData();

    protected void addCompositeDisposable(Disposable disposable) {
        if (null != disposable) {
            mCompositeDisposable.add(disposable);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
}
