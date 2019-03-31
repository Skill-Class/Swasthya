package com.example.sheetalkumar.swasthya.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sheetalkumar.swasthya.Fragment.BlogPostFragment;
import com.example.sheetalkumar.swasthya.Fragment.FollowFragment;
import com.example.sheetalkumar.swasthya.Fragment.TabOne;
import com.example.sheetalkumar.swasthya.Fragment.TabTwo;

public class PagerAdapterForBlogPostActivity extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterForBlogPostActivity(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                BlogPostFragment tab1 = new BlogPostFragment();
                return tab1;
            case 1:
                TabOne tab2 = new TabOne();
                return tab2;
            case 2:
                FollowFragment followTab = new FollowFragment();
                return followTab;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}