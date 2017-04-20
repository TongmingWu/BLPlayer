package com.tm.blplayer.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tm.blplayer.R;
import com.tm.blplayer.ui.fragment.BangumiFragment;
import com.tm.blplayer.ui.fragment.CategoryFragment;
import com.tm.blplayer.ui.fragment.DiscoverFragment;
import com.tm.blplayer.ui.fragment.LiveFragment;
import com.tm.blplayer.ui.fragment.RecommendFragment;
import com.tm.blplayer.ui.fragment.TrendsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.ll_menu)
    LinearLayout llMenu;
    @BindView(R.id.iv_game)
    ImageView ivGame;
    @BindView(R.id.iv_download)
    ImageView ivDownload;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.draw_layout)
    DrawerLayout drawerLayout;

    private String[] tabs = {"直播", "推荐", "番剧", "分区", "动态", "发现"};
    private List<Fragment> fragments = new ArrayList<>();

    private long mExitTime = 0L;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        initTab();
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabs[position];
            }

            @Override
            public int getCount() {
                return tabs.length;
            }
        });

        tabLayout.setupWithViewPager(viewPager);
    }

    private void initTab() {
        LiveFragment mLiveFragment = new LiveFragment();
        RecommendFragment mRecommendFragment = new RecommendFragment();
        BangumiFragment mBangumiFragment = new BangumiFragment();
        CategoryFragment mCategoryFragment = new CategoryFragment();
        TrendsFragment mTrendsFragment = new TrendsFragment();
        DiscoverFragment mDiscoverFragment = new DiscoverFragment();

        fragments.add(mLiveFragment);
        fragments.add(mRecommendFragment);
        fragments.add(mBangumiFragment);
        fragments.add(mCategoryFragment);
        fragments.add(mTrendsFragment);
        fragments.add(mDiscoverFragment);
    }

    @OnClick({R.id.ll_menu, R.id.iv_game, R.id.iv_download, R.id.iv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_menu:
                drawerLayout.openDrawer(Gravity.START);
                break;
            case R.id.iv_game:
                break;
            case R.id.iv_download:
                break;
            case R.id.iv_search:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - mExitTime <= 2000) {
            System.exit(0);
        } else {
            Toast.makeText(this, getResources().getString(R.string.home_exit_hint), Toast.LENGTH_SHORT).show();
            mExitTime = currentTimeMillis;
        }
    }
}