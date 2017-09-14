package com.sample.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sample.R;
import com.sample.adapter.MainActivityAdapter;
import com.sample.ui.fragment.MainFragment;
import com.sample.ui.fragment.UtilFragment;
import com.sample.ui.fragment.OtherFragment;
import com.sample.ui.fragment.ViewFragment;
import com.siberiadante.lib.manager.PermissionManager;
import com.siberiadante.lib.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    private ViewPager mViewPager;
    private RadioButton mRBOne, mRBTwo, mRBThree, mRBFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    public void initView() {
        final RadioGroup mRGHome = (RadioGroup) findViewById(R.id.rg_home);
        mRBOne = (RadioButton) findViewById(R.id.rb_home_one);
        mRBTwo = (RadioButton) findViewById(R.id.rb_home_two);
        mRBThree = (RadioButton) findViewById(R.id.rb_home_three);
        mRBFour = (RadioButton) findViewById(R.id.rb_home_four);
        mViewPager = (ViewPager) findViewById(R.id.vp_home);

        mRGHome.setOnCheckedChangeListener(this);
    }

    public void initData() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new ViewFragment());
        fragments.add(new UtilFragment());
        fragments.add(new OtherFragment());
        mViewPager.setAdapter(new MainActivityAdapter(getSupportFragmentManager(), fragments));
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(this);
        mRBOne.setChecked(true);
        mRBOne.setTextColor(getResources().getColor(R.color.green));
        testPermission();
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
                mRBOne.setTextColor(getResources().getColor(R.color.green));
                mRBTwo.setTextColor(getResources().getColor(R.color.gray));
                mRBThree.setTextColor(getResources().getColor(R.color.gray));
                mRBFour.setTextColor(getResources().getColor(R.color.gray));
                break;
            case R.id.rb_home_two:
                mViewPager.setCurrentItem(1, false);
                mRBOne.setTextColor(getResources().getColor(R.color.gray));
                mRBTwo.setTextColor(getResources().getColor(R.color.red));
                mRBThree.setTextColor(getResources().getColor(R.color.gray));
                mRBFour.setTextColor(getResources().getColor(R.color.gray));
                break;
            case R.id.rb_home_three:
                mViewPager.setCurrentItem(2, false);
                mRBOne.setTextColor(getResources().getColor(R.color.gray));
                mRBTwo.setTextColor(getResources().getColor(R.color.gray));
                mRBThree.setTextColor(getResources().getColor(R.color.red));
                mRBFour.setTextColor(getResources().getColor(R.color.gray));
                break;
            case R.id.rb_home_four:
                mViewPager.setCurrentItem(3, false);
                mRBOne.setTextColor(getResources().getColor(R.color.gray));
                mRBTwo.setTextColor(getResources().getColor(R.color.gray));
                mRBThree.setTextColor(getResources().getColor(R.color.gray));
                mRBFour.setTextColor(getResources().getColor(R.color.green));
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
            ToastUtil.showSingletonText("再按一次退出程序", Toast.LENGTH_LONG, Gravity.CENTER);
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
