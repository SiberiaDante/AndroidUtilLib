package com.siberiadante.utilsample.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;

import com.siberiadante.androidutil.util.SDScreenUtil;
import com.siberiadante.androidutil.widget.radiobutton.SDNotifyRadioButton;
import com.siberiadante.androidutil.widget.radiobutton.SDDrawableRadioButton;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;
import com.siberiadante.utilsample.adapter.MainActivityAdapter;
import com.siberiadante.utilsample.fragment.SDUtilFragment;
import com.siberiadante.utilsample.fragment.SDWidgetFragment;
import com.siberiadante.utilsample.fragment.PracticeFragment;
import com.siberiadante.utilsample.fragment.SDViewFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeMainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.rb_one)
    SDDrawableRadioButton rbOne;
    @BindView(R.id.rb_two)
    SDDrawableRadioButton rbTwo;
    @BindView(R.id.rb_three)
    SDDrawableRadioButton rbThree;
    @BindView(R.id.rb_four)
    SDNotifyRadioButton rbFour;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home_main);
//        ButterKnife.bind(this);
//        initView();
//        initData();
//    }


    @Override
    public void beforeSetContentView() {
        super.beforeSetContentView();
        if (SDScreenUtil.isPortrait()) {
            SDScreenUtil.adaptScreenPortrait(this, 360);
        } else {
            SDScreenUtil.adaptScreenLandscape(this, 360);
        }
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_home_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

//    private void initData() {
//        List<Fragment> fragments = new ArrayList<>();
//        fragments.add(SDUtilFragment.getInstance());
//        fragments.add(SDViewFragment.getInstance());
//        fragments.add(SDWidgetFragment.getInstance());
//        fragments.add(PracticeFragment.getInstance());
//        viewPager.setAdapter(new MainActivityAdapter(getSupportFragmentManager(), fragments));
//        viewPager.setCurrentItem(0);
//        viewPager.setOffscreenPageLimit(4);
//        viewPager.addOnPageChangeListener(this);
//        rgMain.setOnCheckedChangeListener(this);
//        rbOne.setChecked(true);
//    }


    @Override
    public void initData() {
        super.initData();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(SDUtilFragment.getInstance());
        fragments.add(SDViewFragment.getInstance());
        fragments.add(SDWidgetFragment.getInstance());
        fragments.add(PracticeFragment.getInstance());
        viewPager.setAdapter(new MainActivityAdapter(getSupportFragmentManager(), fragments));
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(4);
        viewPager.addOnPageChangeListener(this);
        rgMain.setOnCheckedChangeListener(this);
        rbOne.setChecked(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SDScreenUtil.cancelAdaptScreen(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                rbOne.setChecked(true);
                break;
            case 1:

                rbTwo.setChecked(true);
                break;
            case 2:
                rbThree.setChecked(true);
                break;
            case 3:
                rbFour.setChecked(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_one:
                viewPager.setCurrentItem(0, false);
                break;
            case R.id.rb_two:
                viewPager.setCurrentItem(1, false);
                break;
            case R.id.rb_three:
                viewPager.setCurrentItem(2, false);
                break;
            case R.id.rb_four:
                viewPager.setCurrentItem(3, false);
                rbFour.isShowNotify(false);
                break;
        }
    }
}
