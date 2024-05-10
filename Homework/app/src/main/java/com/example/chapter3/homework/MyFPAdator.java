package com.example.chapter3.homework;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * @author z'
 * @version 1.0
 * @description: TODO
 */
public class MyFPAdator extends FragmentStatePagerAdapter {
    public MyFPAdator(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return new PlaceholderFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // 返回对应位置 Fragment 的标题
        switch (position) {
            case 0:
                return "好友列表";
            case 1:
                return "我的好友";
            default:
                return null;
        }
    }
}
