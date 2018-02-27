package com.siberiadante.utilsample.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * Created: SiberiaDante
 * Describe：
 * CreateTime: 2017/12/5
 * UpDateTime:
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 */
/*
http://www.jianshu.com/p/092418c5fe7f
 */
public abstract class LazyFragment extends BaseFragment {
    public static final String TAG = LazyFragment.class.getSimpleName();

    /**
     * 标记已加载完成，保证懒加载只能加载一次
     */
    private boolean hasLoaded = false;
    /**
     * 标记Fragment是否已经onCreate
     */
    private boolean isCreated = false;
    /**
     * 界面对于用户是否可见
     */
    private boolean isVisibleToUser = false;
    private View view;

    @Override
    protected void initViews(View view, @Nullable Bundle savedInstanceState) {
        isCreated = true;//注：关键步骤
        this.view = view;
        lazyLoad(this.view, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.isVisibleToUser = isVisibleToUser;//注：关键步骤
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad(view, null);
    }

    /**
     * 懒加载方法，获取数据什么的放到这边来使用，在切换到这个界面时才进行网络请求
     */
    private void lazyLoad(View view, Bundle savedInstanceState) {

        //如果该界面不对用户显示、已经加载、fragment还没有创建，
        //三种情况任意一种，不获取数据
        if (!isVisibleToUser || hasLoaded || !isCreated) {
            return;
        }
        lazyInitView(view, savedInstanceState);
        hasLoaded = true;//注：关键步骤，确保数据只加载一次
    }

    /**
     * 子类必须实现的方法，这个方法里面的操作都是需要懒加载的
     */
    public abstract void lazyInitView(View view, Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isCreated = false;
        hasLoaded = false;
    }

}
