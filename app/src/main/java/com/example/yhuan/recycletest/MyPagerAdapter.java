package com.example.yhuan.recycletest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by yhuan on 2016/12/17.
 */

public class MyPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> mFragments;
    Map<Integer,Fragment> fMaps;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    public MyPagerAdapter(FragmentManager fm,Map<Integer,Fragment> fragments) {
        super(fm);
        this.fMaps = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        if (mFragments == null) {
            return fMaps.get(position);
        }
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        if (mFragments == null) {
            return fMaps.size();
        }
        return mFragments.size();
    }
}
