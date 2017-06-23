package com.example.android.miwok.fragments;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.miwok.R;

/**
 * Created by Samsung on 6/6/2017.
 */

public class MiwokFragmentAdapter extends FragmentPagerAdapter {
    private String[] title;
    public MiwokFragmentAdapter(FragmentManager fm, Context ct) {
        super(fm);
        title = new String[]{
                ct.getResources().getString(R.string.category_numbers),
                ct.getString(R.string.category_family),
                ct.getString(R.string.category_colors),
                ct.getString(R.string.category_phrases)
        };
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            case 3:
                return new PhrasesFragment();
            default:
                return new NumbersFragment();
        }
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
