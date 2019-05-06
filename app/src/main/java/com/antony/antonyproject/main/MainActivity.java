package com.antony.antonyproject.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.antony.antonyproject.R;
import com.antony.antonyproject.fragment.one.OneFragment;
import com.antony.antonyproject.utils.TabViewPagerUtil;

import java.util.ArrayList;
import java.util.List;

import adapter.BaseFragmentPagerAdapter;
import base.BaseMvpActivity;
import base.BaseMvpFragment;
import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View, NavigationView.OnNavigationItemSelectedListener {


    /**
     * https://blog.csdn.net/qq_34773981/article/details/82022647
     * FragmentPagerAdapter适用于Fragment比较少的情况，它会把每一个Fragment保存在内存中，不用每次切换的时候，去保存现场，切换回来在重新创建，所以用户体验比较好
     * 而对于Fragment比较多的情况，需要切换的时候销毁以前的Fragment以释放内存，就可以使用FragmentStatePagerAdapter。
     */
    @BindView(R.id.main_drawer_layout)
    public DrawerLayout mDrawerLayout;
    @BindView(R.id.main_tablayout)
    public TabLayout mTabLayout;
    @BindView(R.id.main_viewpager)
    public ViewPager mViewPager;
    @BindView(R.id.main_navigation_view)
    public NavigationView mNavigationView;

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
        List<Fragment> fragments = TabViewPagerUtil.addFragment(new OneFragment(), new OneFragment());
        List<String> strings = TabViewPagerUtil.addTitle("推荐", "朋友", "电台");
        TabViewPagerUtil.addTab(mTabLayout,mViewPager, fragments, strings, getSupportFragmentManager());
        mNavigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
