package com.tm.blplayer.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.tm.blplayer.R;
import com.tm.blplayer.bean.VideoDetailData;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author wutongming
 * @description 视频详情页简介tab
 * @since 2017/5/18
 */

public class VideoDescriptionFragment extends BaseFragment {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_play_count)
    TextView tvPlayCount;
    @BindView(R.id.tv_danmaku_count)
    TextView tvDanmakuCount;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_coin)
    TextView tvCoin;
    @BindView(R.id.tv_collect)
    TextView tvCollect;
    @BindView(R.id.tv_download)
    TextView tvDownload;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_desc;
    }

    @Override
    protected void initView() {

    }

    public void initData(VideoDetailData data) {
        tvTitle.setText(data.getTitle());
        tvDesc.setText(data.getDesc());
        VideoDetailData.PlayInfoBean playInfo = data.getPlay_info();
        if (playInfo != null) {
            tvPlayCount.setText(String.valueOf(playInfo.getView()));
            tvDanmakuCount.setText(String.valueOf(playInfo.getDanmaku()));
            tvShare.setText(String.valueOf(playInfo.getShare()));
            tvCoin.setText(String.valueOf(playInfo.getCoin()));
            tvCollect.setText(String.valueOf(playInfo.getFavorite()));
        }
    }

    @OnClick({R.id.tv_share, R.id.tv_coin, R.id.tv_collect, R.id.tv_download})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_share:
                break;
            case R.id.tv_coin:
                break;
            case R.id.tv_collect:
                break;
            case R.id.tv_download:
                break;
        }
    }
}
