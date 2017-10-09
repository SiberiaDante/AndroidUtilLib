package com.sample.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.github.clans.fab.FloatingActionButton;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.sample.R;
import com.sample.adapter.MainActivityAdapter;
import com.sample.ui.fragment.LeftDrawFragment;
import com.sample.ui.fragment.MainFragment;
import com.sample.ui.fragment.UtilFragment;
import com.sample.ui.fragment.OtherFragment;
import com.sample.ui.fragment.ViewFragment;
import com.siberiadante.lib.manager.PermissionManager;
import com.siberiadante.lib.model.TimerCountModel;
import com.siberiadante.lib.presenter.TimerCountPresenter;
import com.siberiadante.lib.presenter.impl.ITimerCountPresenter;
import com.siberiadante.lib.util.SDLogUtil;
import com.siberiadante.lib.util.SDToastUtil;
import com.siberiadante.lib.view.impl.ITimerCountView;
import com.siberiadante.lib.view.titlebar.SDTitleLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    private ViewPager mViewPager;
    private RadioButton mRBOne, mRBTwo, mRBThree, mRBFour;
    private FrameLayout mFLDraw;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout drawerLayout;
    public SDTitleLayout mMianTitle;
    private FloatingActionButton mFloatBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SwipeBackHelper.getCurrentPage(this)
                .setSwipeBackEnable(false);
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeRelateEnable(true)
                .setDisallowInterceptTouchEvent(true);

        initView();
        initData();
    }

    public void initView() {
        mMianTitle = (SDTitleLayout) findViewById(R.id.title_layout_main);
        final RadioGroup mRGHome = (RadioGroup) findViewById(R.id.rg_home);
        mRBOne = (RadioButton) findViewById(R.id.rb_home_one);
        mRBTwo = (RadioButton) findViewById(R.id.rb_home_two);
        mRBThree = (RadioButton) findViewById(R.id.rb_home_three);
        mRBFour = (RadioButton) findViewById(R.id.rb_home_four);
        mViewPager = (ViewPager) findViewById(R.id.vp_home);
        mRGHome.setOnCheckedChangeListener(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mFLDraw = (FrameLayout) findViewById(R.id.left_drawer);
        mFloatBar = (FloatingActionButton) findViewById(R.id.top_main);

        final android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.left_drawer, LeftDrawFragment.getInstance());
        transaction.commit();

        mToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.about_me, R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                SDLogUtil.d("--------close---------------");
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                SDLogUtil.d("--------open---------------");
            }
        }
        ;
        drawerLayout.addDrawerListener(mToggle);
        mMianTitle.setTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        mMianTitle.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SDToastUtil.toast("back");
            }
        });
    }

    public void initData() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(MainFragment.getInstance(mFloatBar));
        fragments.add(ViewFragment.getInstance(mFloatBar));
        fragments.add(UtilFragment.getInstance(mFloatBar));
        fragments.add(OtherFragment.getInstance(mFloatBar));
        mViewPager.setAdapter(new MainActivityAdapter(getSupportFragmentManager(), fragments));
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.addOnPageChangeListener(this);
        mRBOne.setChecked(true);
        testPermission();
        // TODO: 2017/9/30 计时器的测试 还需完善？
        testTimer();
    }

    private void testTimer() {

        final TimerCountModel timerCountModel = new TimerCountModel(10000, 1000, new ITimerCountPresenter() {
            @Override
            public void onTimerCount(long time) {
                SDLogUtil.d("-------------------" + time);
            }

            @Override
            public void onFinish() {
                SDLogUtil.d("-------------------finish");
            }
        });
        timerCountModel.start();
    }

    private void testPermission() {
        //同时申请多个权限
//        PermissionManager.getInstance(getApplicationContext()).execute(this, Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        //请求单个，显示对话框的方式
        PermissionManager.getInstance(getApplicationContext()).executeDialog(this, Manifest.permission.RECORD_AUDIO,
                PermissionManager.getInstance(getApplicationContext()).new Builder(this)
                        .setMessage("应用需要获取您的录音权限，是否授权？")
                        .setTitle(getString(R.string.app_name))
                        .setIcon(R.mipmap.ic_launcher)
                        .setOk("OK")
                        .setCancel("CANCEL"));
    }

    @Override
    public void onClick(View view) {
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_home_one:
                mViewPager.setCurrentItem(0, false);
                mMianTitle.setTitle("SiberiaDante——点我");
                break;
            case R.id.rb_home_two:
                mViewPager.setCurrentItem(1, false);
                mMianTitle.setTitle("封装组件等相关测试");
                break;
            case R.id.rb_home_three:
                mViewPager.setCurrentItem(2, false);
                mMianTitle.setTitle("封装工具类等相关测试");
                break;
            case R.id.rb_home_four:
                mViewPager.setCurrentItem(3, false);
                mMianTitle.setTitle("其他");
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mRBOne.setChecked(true);
                break;
            case 1:

                mRBTwo.setChecked(true);
                break;
            case 2:
                mRBThree.setChecked(true);
                break;
            case 3:
                mRBFour.setChecked(true);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click();      //调用双击退出函数
        }
        return false;
    }

    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (!isExit) {
            isExit = true; // 准备退出
            SDToastUtil.toastCenterShort("再按一次退出程序");
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();
            System.exit(0);

        }
    }
}
