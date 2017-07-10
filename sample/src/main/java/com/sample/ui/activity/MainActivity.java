package com.sample.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sample.R;
import com.sample.adapter.MainActivityAdapter;
import com.sample.ui.fragment.UtilFragment;
import com.sample.ui.fragment.ViewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    private ViewPager mViewPager;
    private RadioButton mRBOne, mRBTwo;

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
        mViewPager = (ViewPager) findViewById(R.id.vp_home);

        mRGHome.setOnCheckedChangeListener(this);
    }

    public void initData() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ViewFragment());
        fragments.add(new UtilFragment());
        mViewPager.setAdapter(new MainActivityAdapter(getSupportFragmentManager(), fragments));
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(this);
        mRBOne.setChecked(true);
        mRBOne.setTextColor(getResources().getColor(R.color.Red));
    }

    @Override
    public void onClick(View view) {
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_home_one:
                mViewPager.setCurrentItem(0,false);
                mRBOne.setTextColor(getResources().getColor(R.color.Red));
                mRBTwo.setTextColor(getResources().getColor(R.color.gray));
                break;
            case R.id.rb_home_two:
                mViewPager.setCurrentItem(1,false);
                mRBTwo.setTextColor(getResources().getColor(R.color.Red));
                mRBOne.setTextColor(getResources().getColor(R.color.gray));
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
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
