package com.siberiadante.custom.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.siberiadante.custom.R;
import com.siberiadante.custom.ui.activity.Main2Activity;
import com.siberiadante.custom.util.ImageLoadUtil;
import com.siberiadante.lib.util.SDLogUtil;
import com.siberiadante.lib.util.SDToast;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

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
        SDToast.toast("第一个页面");
        Log.d(TAG, "onCreateViewLazy: FragmentOne");
        initView();
    }

    private void initView() {
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.dv_image_view);
        String url = "http://www.chinichi.cn/Uploads/Avatar/1703/59a9004a6f568.jpeg";
//        ImageLoadUtil.frescoImage(url, draweeView);
        ImageLoadUtil.frescoImageRadius(url, draweeView);
        draweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Main2Activity.class));
            }
        });
        Disposable disposable = Observable.timer(13, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        SDLogUtil.d("----timer----");
                    }
                });

        addCompositeDisposable(disposable);
    }

}
