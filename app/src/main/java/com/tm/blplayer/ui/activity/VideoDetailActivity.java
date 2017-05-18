package com.tm.blplayer.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.tm.blplayer.R;
import com.tm.blplayer.bean.VideoDetailData;
import com.tm.blplayer.mvp.presenter.VideoDetailPresenter;
import com.tm.blplayer.mvp.view.BaseView;
import com.tm.blplayer.ui.fragment.BaseFragment;
import com.tm.blplayer.ui.fragment.VideoCommentFragment;
import com.tm.blplayer.ui.fragment.VideoDescriptionFragment;
import com.tm.blplayer.utils.CommonUtil;
import com.tm.blplayer.utils.ToastUtils;
import com.tm.blplayer.utils.constants.Constants;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author wutongming
 * @description 视频详情页
 * @since 2017/5/18
 */

public class VideoDetailActivity extends BaseActivity implements BaseView {
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.ll_play)
    LinearLayout llPlay;
    @BindView(R.id.tv_back_title)
    TextView tvBackTitle;
    @BindView(R.id.app_bar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.iv_cover)
    ImageView ivCover;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.fab_play)
    FloatingActionButton fabPlay;

    private String aid;
    private VideoDetailPresenter mVideoDetailPresenter;
    private VideoDetailData mData;
    private BaseFragment[] fragments = new BaseFragment[2];
    private int fabSize;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_detail;
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        llBack.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        aid = intent.getStringExtra(Constants.VIDEO_AID);
        tvBackTitle.setText(getResources().getString(R.string.video_detail_av, String.valueOf(aid)));
        toolbar.setBackgroundColor(getResources().getColor(R.color.transparent));
        fabSize = CommonUtil.dip2px(this, 60f);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float totalScrollRange = mAppBarLayout.getTotalScrollRange();
                float offset = Math.abs(verticalOffset);
                float scale = 1 - offset / totalScrollRange;
                ViewGroup.LayoutParams params = fabPlay.getLayoutParams();
                params.width = (int) (fabSize * scale);
                params.height = (int) (fabSize * scale);
                fabPlay.setLayoutParams(params);
                if (offset >= totalScrollRange) {
                    toolbar.setBackgroundColor(getResources().getColor(R.color.dominantColor));
                    tvBackTitle.setVisibility(View.GONE);
                    llPlay.setVisibility(View.VISIBLE);
                    fabPlay.setVisibility(View.GONE);
                } else {
                    toolbar.setBackgroundColor(getResources().getColor(R.color.transparent));
                    tvBackTitle.setVisibility(View.VISIBLE);
                    llPlay.setVisibility(View.GONE);
                    fabPlay.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected void initView() {
        initTab();
    }

    private void initTab() {
        fragments[0] = new VideoDescriptionFragment();
        fragments[1] = new VideoCommentFragment();
        final String[] array = getResources().getStringArray(R.array.video_detail_tab);

        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return array[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();
        getData();
    }

    private void createPresenter() {
        if (mVideoDetailPresenter == null) {
            mVideoDetailPresenter = new VideoDetailPresenter();
        }
        mVideoDetailPresenter.onAttach(this);
    }

    private void getData() {
        Map<String, String> map = new HashMap<>();
        map.put(Constants.VIDEO_AID, String.valueOf(aid));
        mVideoDetailPresenter.requestData(map);
    }

    @OnClick({R.id.ll_back, R.id.ll_play, R.id.fab_play})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.ll_play:
            case R.id.fab_play:
                playVideo();
                break;
        }
    }

    /**
     * 播放视频
     */
    private void playVideo() {
        Logger.d("playVideo");
    }

    @Override
    public void onNetworkSuccess(Object result) {
        mData = (VideoDetailData) result;
        ((VideoDescriptionFragment) fragments[0]).initData(mData);

    }

    @Override
    public void onNetworkFailed(int code, String errorMsg) {
        ToastUtils.showShortToast(this, "code = " + code + " errorMsg = " + errorMsg);
    }

    @Override
    public void onNetworkError(String error) {
        ToastUtils.showShortToast(this, error);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mVideoDetailPresenter != null) {
            mVideoDetailPresenter.onDetach();
        }
    }
}
