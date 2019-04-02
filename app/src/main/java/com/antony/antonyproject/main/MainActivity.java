package com.antony.antonyproject.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.antony.antonyproject.R;
import com.antony.antonyproject.fragment.one.OneFragment;

import java.util.ArrayList;
import java.util.List;

import adapter.BaseFragmentPagerAdapter;
import base.BaseMvpActivity;
import base.BaseMvpFragment;
import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {


    /**
     * https://blog.csdn.net/qq_34773981/article/details/82022647
     * FragmentPagerAdapter适用于Fragment比较少的情况，它会把每一个Fragment保存在内存中，不用每次切换的时候，去保存现场，切换回来在重新创建，所以用户体验比较好
     * 而对于Fragment比较多的情况，需要切换的时候销毁以前的Fragment以释放内存，就可以使用FragmentStatePagerAdapter。
     */
    @BindView(R.id.main_drawer_layout)
    private DrawerLayout mDrawerLayout;
    @BindView(R.id.main_tablayout)
    private TabLayout mTabLayout;
    @BindView(R.id.main_viewpager)
    private ViewPager mViewPager;
    @BindView(R.id.main_navigation_view)
    private NavigationView mNavigationView;

    //TabLayout的tab
    private int[] tabItems = new int[]{R.drawable.main_music_selector,
            R.drawable.main_discover_selector,
            R.drawable.main_friends_selector};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        List<BaseMvpFragment> fragmentList = new ArrayList<>();
        fragmentList.add(new OneFragment());
        fragmentList.add(new OneFragment());
        fragmentList.add(new OneFragment());
        BaseFragmentPagerAdapter pagerAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setOffscreenPageLimit(2);
        mTabLayout.setupWithViewPager(mViewPager);
        //设置tabItem
        for (int i=0;i<fragmentList.size();i++){
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(R.layout.main_tab_item_layout);
            ImageView tabIcon = (ImageView) tab.getCustomView().findViewById(R.id.iv_tab_icon);
            tabIcon.setImageResource(tabItems[i]);
        }
        mViewPager.setCurrentItem(1);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
