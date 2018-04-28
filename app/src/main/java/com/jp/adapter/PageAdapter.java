package com.jp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by bm on 24/02/17.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    ArrayList<Fragment> fr_list;

    public PageAdapter(FragmentManager fm, ArrayList<Fragment> fr_list) {
        super(fm);
        this.fr_list=fr_list;
    }

    @Override
    public Fragment getItem(int position) {

        return fr_list.get(position);
    }

    @Override
    public int getCount() {
        return fr_list.size();
    }
}
