package com.antony.antonyproject.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.antony.antonyproject.R;

import base.BaseMvpActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View, NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener, View.OnClickListener {
    private final String TAG = "MainActivity";
    /**
     * https://blog.csdn.net/qq_34773981/article/details/82022647
     * FragmentPagerAdapter适用于Fragment比较少的情况，它会把每一个Fragment保存在内存中，不用每次切换的时候，去保存现场，切换回来在重新创建，所以用户体验比较好
     * 而对于Fragment比较多的情况，需要切换的时候销毁以前的Fragment以释放内存，就可以使用FragmentStatePagerAdapter。
     */
    @BindView(R.id.main_drawer_layout)
    public DrawerLayout mDrawerLayout;
    @BindView(R.id.main_viewpager)
    public ViewPager mViewPager;
    @BindView(R.id.main_navigation_view)
    public NavigationView mNavigationView;
    private Toolbar mToolbar;
    private ImageView imgMusic, imgDisco, imgFriends;
    /*private ActionBarDrawerToggle drawerToggle;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mDrawerLayout = findViewById(R.id.main_drawer_layout);
        mViewPager = findViewById(R.id.main_viewpager);
        mNavigationView = findViewById(R.id.main_navigation_view);
        mToolbar = findViewById(R.id.main_toolbar);
        imgMusic = findViewById(R.id.toolbar_disco);
        imgDisco = findViewById(R.id.toolbar_music);
        imgFriends = findViewById(R.id.toolbar_friends);
        /*drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.toolbar_null_name, R.string.toolbar_null_name);
        通过下面这句实现toolbar和Drawer的联动：如果没有这行代码，箭头是不会随着侧滑菜单的开关而变换的（或者没有箭头），
         可以尝试一下，不影响正常侧滑
        drawerToggle.syncState();
        去掉侧滑的默认图标（动画箭头图标），也可以选择不去，不去的话把这一行注释掉或者改成true，然后把toolbar.setNavigationIcon注释掉就行了
        drawerToggle.setDrawerIndicatorEnabled(false);
        可在toolbar上设置图标来作为侧滑的默认图标
        mToolbar.setNavigationIcon(R.mipmap.menu);*/
        setSupportActionBar(mToolbar);
        //去掉toolbar标题
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mDrawerLayout.setDrawerListener(this);
        mNavigationView.setNavigationItemSelectedListener(this);
        imgMusic.setOnClickListener(this);
        imgDisco.setOnClickListener(this);
        imgFriends.setOnClickListener(this);
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

    /**
     * 当抽屉被滑动的时候调用此方法
     * slideOffset表示 滑动的幅度（0-1）
     */
    @Override
    public void onDrawerSlide(@NonNull View view, float v) {

    }

    @Override
    public void onDrawerOpened(@NonNull View view) {
        //完全打开时触发
    }

    @Override
    public void onDrawerClosed(@NonNull View view) {
        //完全关闭时触发
    }

    /**
     * 当抽屉滑动状态改变的时候被调用
     * 状态值是STATE_IDLE（闲置--0）, STATE_DRAGGING（拖拽的--1）, STATE_SETTLING（固定--2）中之一。
     * 具体状态可以慢慢调试
     */
    @Override
    public void onDrawerStateChanged(int i) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_title_menu:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.toolbar_music:
                break;
            case R.id.toolbar_disco:
                break;
            case R.id.toolbar_friends:
                break;
            default:
                // do nothing
                break;
        }
    }
}
