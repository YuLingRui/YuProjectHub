package com.antony.antonyproject.utils;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.Arrays;
import java.util.List;

public class TabViewPagerUtil {

    public static void addTab(TabLayout tabLayout, ViewPager viewPager, final List<Fragment> fragments, final List<String> strings, FragmentManager manager){
        /*预加载*/
        viewPager.setOffscreenPageLimit(fragments.size());
        /*加载适配器*/
        viewPager.setAdapter(new FragmentPagerAdapter(manager) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    public static List<String> addTitle(String ... a){
        String[] title = a;
        List<String> list = Arrays.asList(title);
        return list;
    }


    public static List<Fragment> addFragment(Fragment ... fragments){
        Fragment[] m = fragments;
        List<Fragment> fragmentList = Arrays.asList(m);
        return fragmentList;
    }

}
