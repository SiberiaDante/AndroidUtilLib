package com.siberiadante.androidutil.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SDCustomFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] mTitles;

    public SDCustomFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public SDCustomFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        if (fragments != null) {
            this.fragments = fragments;
        } else {
            this.fragments = new ArrayList<>();
        }
    }

    public SDCustomFragmentAdapter(FragmentManager fm, List<Fragment> fragments, String[] titles) {
        super(fm);
        if (fragments != null) {
            this.fragments = fragments;
        } else {
            this.fragments = new ArrayList<>();
        }
        if (titles != null) {
            mTitles = titles;
        }
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    public void setTitles(String[] titles) {
        if (titles.length != 0) {
            this.mTitles = titles;
        }
        notifyDataSetChanged();
    }

    public void setData(List<Fragment> fragments, String[] titles) {
        if (fragments != null) {
            this.fragments.addAll(fragments);
        }
        if (titles.length != 0) {
            this.mTitles = titles;
        }
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles != null) {
            return mTitles[position];
        }
        return super.getPageTitle(position);
    }
}
