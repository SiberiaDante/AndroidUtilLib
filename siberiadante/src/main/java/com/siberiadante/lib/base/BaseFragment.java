package com.siberiadante.lib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/6/27
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();
    //传递过来的参数Bundle，供子类使用
    protected Bundle bundle;

    /**
     * 初始创建Fragment对象时调用
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initIntent();
        initData();
    }

    public abstract void initView();

    protected abstract void initIntent();

    protected abstract void initData();

    /**
     * 创建fragment的静态方法，方便传递参数
     *
     * @param bundle 传递的参数
     * @return
     * @tip Fragment mFragment = Fragment.newInstance(Fragment.class, null);
     * mFragment.bindToContentView(mTvContent);//绑定当前页面控件
     * FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
     * transaction.replace(R.id.frameLayout, mFragment);
     * //transaction.addToBackStack(null);//fragment添加至回退栈中
     * transaction.commit();
     */
    public static <T extends Fragment> T newInstance(Class clazz, Bundle bundle) {
        T mFragment = null;
        try {
            mFragment = (T) clazz.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mFragment.setArguments(bundle);
        return mFragment;
    }


}
