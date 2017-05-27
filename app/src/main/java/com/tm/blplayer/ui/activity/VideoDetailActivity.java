package com.tm.blplayer.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.orhanobut.logger.Logger;
import com.tm.blplayer.R;
import com.tm.blplayer.bean.VideoDetailData;
import com.tm.blplayer.mvp.presenter.VideoDetailPresenter;
import com.tm.blplayer.mvp.view.BaseView;
import com.tm.blplayer.ui.fragment.BaseFragment;
import com.tm.blplayer.ui.fragment.VideoCommentFragment;
import com.tm.blplayer.ui.fragment.VideoDescriptionFragment;
import com.tm.blplayer.utils.CommonUtil;
import com.tm.blplayer.utils.StringUtils;
import com.tm.blplayer.utils.ToastUtils;
import com.tm.blplayer.utils.constants.Constants;
import com.tm.blplayer.widget.media.AndroidMediaController;
import com.tm.blplayer.widget.media.IjkVideoView;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * @author wutongming
 * @description 视频详情页
 * @since 2017/5/18
 */

public class VideoDetailActivity extends BaseActivity implements BaseView {
    @BindView(R.id.cl_root)
    CoordinatorLayout clRoot;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.ll_play)
    LinearLayout llPlay;
    @BindView(R.id.tv_back_title)
    TextView tvBackTitle;
    @BindView(R.id.app_bar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.video_view)
    IjkVideoView videoView;
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
    private AndroidMediaController mediaController;
    private String playUrl;
    private boolean mBackPressed;
    private int deviceWidth;
    private int mCurrentUrlIndex;
    private int mCurrentPlayPosition;

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
        mAppBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            float totalScrollRange = mAppBarLayout.getTotalScrollRange();
            float offset = Math.abs(verticalOffset);
            float scale = 1 - offset / totalScrollRange;
            ViewGroup.LayoutParams params = fabPlay.getLayoutParams();
            params.width = (int) (fabSize * scale);
            params.height = (int) (fabSize * scale);
            fabPlay.setLayoutParams(params);
            if (!videoView.isPlaying()) {
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
        RxView.clicks(fabPlay)
                .throttleFirst(1000, TimeUnit.MILLISECONDS)
                .subscribe(aVoid -> playVideo());
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
        deviceWidth = CommonUtil.getDeviceWidth(this);
        initVideoView();
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
                playVideo();
                break;
        }
    }

    /**
     * 播放视频
     */
    private void playVideo() {
        if (!StringUtils.isTrimEmpty(playUrl)) {
            videoView.start();
            hidePlayFab();
        }
    }

    /**
     * 执行播放按钮播放动画
     */
    private void hidePlayFab() {
        fabPlay.setVisibility(View.GONE);
    }

    private void initVideoView() {
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        ViewGroup.LayoutParams params = videoView.getLayoutParams();
        params.height = (int) (deviceWidth * (9.0f / 16.0f));

        mediaController = new AndroidMediaController(this, false);

        videoView.setOnPreparedListener(iMediaPlayer -> {
            if (fabPlay.getVisibility() == View.VISIBLE) {
                fabPlay.setVisibility(View.GONE);
            }
        });

        videoView.setOnCompletionListener(iMediaPlayer -> {

        });

        videoView.setOnErrorListener((iMediaPlayer, i, i1) -> {
            //播放失败时重试下一个链接,知道没有链接为止
            //失败的原因有403
            if (mCurrentUrlIndex < mData.getVideo_info().getUrl_list().size()) {
                videoView.setVideoPath(mData.getVideo_info().getUrl_list().get(mCurrentUrlIndex++));
            } else {
                ToastUtils.showShortToast(VideoDetailActivity.this, getString(R.string.video_detail_parse_failed));
            }
            return false;
        });

        videoView.setMediaController(null);
    }

    @Override
    public void onNetworkSuccess(Object result) {
        mData = (VideoDetailData) result;
        ((VideoDescriptionFragment) fragments[0]).initData(mData);

        VideoDetailData.VideoInfoBean videoInfo = mData.getVideo_info();
        if (videoInfo != null) {
            playUrl = videoInfo.getUrl_list().get(mCurrentUrlIndex);
            videoView.setVideoPath(playUrl);
        }

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
    protected void onResume() {
        super.onResume();

        if (mCurrentPlayPosition > 0) {
            //继续之前的播放
            Logger.d("继续播放,之前播放记录 ==> " + mCurrentPlayPosition);
            videoView.start();
            videoView.seekTo(mCurrentPlayPosition);
        }
    }

    @Override
    public void onBackPressed() {
        mBackPressed = true;
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();

        //暂停时记录播放值
        mCurrentPlayPosition = videoView.getCurrentPosition();

        if (mBackPressed || !videoView.isBackgroundPlayEnabled()) {
            videoView.stopPlayback();
            videoView.release(true);
            videoView.stopBackgroundPlay();
        } else {
            videoView.enterBackground();

        }
        IjkMediaPlayer.native_profileEnd();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mVideoDetailPresenter != null) {
            mVideoDetailPresenter.onDetach();
        }
    }
}
