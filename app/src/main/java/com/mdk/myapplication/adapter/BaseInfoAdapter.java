package com.mdk.myapplication.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class BaseInfoAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;

    public BaseInfoAdapter(FragmentManager fragmentManager, ArrayList<Fragment> fragmentArrayList) {
        super(fragmentManager);
        fragments = fragmentArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
