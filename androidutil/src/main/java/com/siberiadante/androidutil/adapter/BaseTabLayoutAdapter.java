package com.siberiadante.androidutil.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * CreateTime: 2018/6/28
 * UpDateTime:
 * Describe: TabLayout+ViewPager+Fragment联动Adapter
 */
public class BaseTabLayoutAdapter extends FragmentStatePagerAdapter {

    //Fragment
    private List<Fragment> mFragments;
    //TabLayout text
    private String[] mTitles;

    public BaseTabLayoutAdapter(FragmentManager fm, List<Fragment> fragments, String[] titles) {
        super(fm);
        if (fragments != null) {
            this.mFragments = fragments;
        } else {
            this.mFragments = new ArrayList<>();
        }
        if (titles != null) {
            this.mTitles = titles;
        }
        /*

         */
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    public void addRes(List<Fragment> fragments, String[] titles) {
        if (fragments != null) {
            this.mFragments.addAll(fragments);
        }
        /*
         */
        if (titles.length != 0) {
            this.mTitles = titles;
        }
        notifyDataSetChanged();
    }
}
