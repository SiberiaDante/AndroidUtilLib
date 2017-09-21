package com.siberiadante.custom.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.siberiadante.custom.R;
import com.siberiadante.custom.bean.QuestionData;
import com.siberiadante.custom.bean.base.WrapResult;
import com.siberiadante.custom.constant.Constants;
import com.siberiadante.custom.http.ApiService;
import com.siberiadante.custom.http.RetrofitManager;
import com.siberiadante.custom.ui.fragment.FourFragment;
import com.siberiadante.custom.ui.fragment.OneFragment;
import com.siberiadante.custom.ui.fragment.ThreeFragment;
import com.siberiadante.custom.ui.fragment.TwoFragment;
import com.siberiadante.lib.util.SDLogUtil;
import com.siberiadante.lib.util.SDToast;
import com.siberiadante.lib.widget.SDRadioButton;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    OneFragment oneFragment;
    TwoFragment twoFragment;
    ThreeFragment threeFragment;
    FourFragment fourFragment;
    FragmentManager fm;
    private long tempTime = 0;
    private int checkId;
    @BindViews({R.id.rb_recommend, R.id.rb_shop, R.id.rb_follow, R.id.rb_mine})
    public List<SDRadioButton> radioButtons;

    @Override
    protected void beforeSetContentView() {
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        radioGroup.setOnCheckedChangeListener(this);
        fm = getSupportFragmentManager();
    }

    @Override
    protected void initData() {
//        getNetData();
        radioButtons.get(0).setChecked(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId != R.id.rb_mine) {
            checkId = checkedId;
        }
        FragmentTransaction ts = fm.beginTransaction();
        hideAllFragments(ts);
        switch (checkedId) {
            case R.id.rb_recommend:
                if (oneFragment == null) {
                    oneFragment = new OneFragment();
                    ts.add(R.id.fragment_container, oneFragment);
                } else {
                    ts.show(oneFragment);
                }
                break;
            case R.id.rb_shop:
                if (twoFragment == null) {
//                    twoFragment = new TwoFragment();
                    twoFragment = TwoFragment.getInstance();
                    ts.add(R.id.fragment_container, twoFragment);
                } else {
                    ts.show(twoFragment);
                }
                break;
            case R.id.rb_follow:
                if (threeFragment == null) {
//                    threeFragment = ThreeFragment.getInstance(FollowAdapter.TYPE_HOME);
                    threeFragment = new ThreeFragment();
                    ts.add(R.id.fragment_container, threeFragment);
                } else {
                    ts.show(threeFragment);
                }
                break;
            case R.id.rb_mine:
                if (fourFragment == null) {
                    fourFragment = new FourFragment();
                    ts.add(R.id.fragment_container, fourFragment);
                } else {
                    ts.show(fourFragment);
                }
                break;
        }
        ts.commit();
    }

    /**
     * 隐藏所有fragment
     *
     * @param ts
     */
    private void hideAllFragments(FragmentTransaction ts) {
        if (oneFragment != null)
            ts.hide(oneFragment);
        if (twoFragment != null)
            ts.hide(twoFragment);
        if (threeFragment != null)
            ts.hide(threeFragment);
        if (fourFragment != null)
            ts.hide(fourFragment);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (oneFragment == null && fragment instanceof OneFragment)
            oneFragment = (OneFragment) fragment;
        if (twoFragment == null && fragment instanceof TwoFragment)
            twoFragment = (TwoFragment) fragment;
        if (threeFragment == null && fragment instanceof ThreeFragment)
            threeFragment = (ThreeFragment) fragment;
        if (fourFragment == null && fragment instanceof FourFragment)
            fourFragment = (FourFragment) fragment;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitDoubleClick();
        }
        return false;
    }

    private void exitDoubleClick() {
        long currentTime = System.currentTimeMillis();
        Log.d(TAG, "onBackPressed: " + currentTime);
        if (currentTime - tempTime > 2000) {
            SDToast.toast("再按一次退出应用");
            SDToast.resetToast();
            tempTime = currentTime;
        } else {
            System.exit(0);
        }
    }

    private void getNetData() {
        RetrofitManager.getInstance().createReq(ApiService.class)
                .questionApi(Constants.ACCESS_TOKEN, Constants.METHOD_GET)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WrapResult<List<QuestionData>>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        addCompositeDisposable(d);
                    }

                    @Override
                    public void onNext(@NonNull WrapResult<List<QuestionData>> listWrapResult) {
                        final List<QuestionData> data = listWrapResult.getData();
                        final String string = data.toString();
                        Log.d(TAG, "onNext: " + string);

                        SDLogUtil.d(data.get(0).getDescription());

                        SDLogUtil.d(data.get(0).getCreate_time());

                        SDLogUtil.d(data.get(0).getTitle());

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
