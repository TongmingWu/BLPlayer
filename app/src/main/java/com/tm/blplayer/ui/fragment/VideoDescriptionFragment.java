package com.tm.blplayer.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tm.blplayer.R;
import com.tm.blplayer.bean.VideoDetailData;
import com.tm.blplayer.bean.VideoItem;
import com.tm.blplayer.utils.StringUtils;
import com.tm.blplayer.utils.TimeUtils;
import com.tm.blplayer.widget.GlideCircleTransform;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

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
    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.tv_up_time)
    TextView tvUpTime;
    @BindView(R.id.flow_layout)
    TagFlowLayout flowLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

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
        VideoDetailData.AuthorInfoBean authorInfo = data.getAuthor_info();
        if (playInfo != null) {
            int viewCount = playInfo.getView();
            int danmakuCount = playInfo.getDanmaku();
            int shareCount = playInfo.getShare();
            int coinCount = playInfo.getCoin();
            int favoriteCount = playInfo.getFavorite();

            tvPlayCount.setText(viewCount > 10000 ? getResources().getString(R.string.home_video_count, StringUtils.DecimalFormat(viewCount)) : String.valueOf(viewCount));
            tvDanmakuCount.setText(danmakuCount > 10000 ? getResources().getString(R.string.home_video_count, StringUtils.DecimalFormat(danmakuCount)) : String.valueOf(danmakuCount));
            tvShare.setText(shareCount > 10000 ? getResources().getString(R.string.home_video_count, StringUtils.DecimalFormat(shareCount)) : String.valueOf(shareCount));
            tvCoin.setText(coinCount > 10000 ? getResources().getString(R.string.home_video_count, StringUtils.DecimalFormat(coinCount)) : String.valueOf(coinCount));
            tvCollect.setText(favoriteCount > 10000 ? getResources().getString(R.string.home_video_count, StringUtils.DecimalFormat(favoriteCount)) : String.valueOf(favoriteCount));
        }
        if (authorInfo != null) {
            Glide.with(getActivity()).load(authorInfo.getCard().getFace()).transform(new GlideCircleTransform(getActivity())).into(ivAvatar);
            tvAuthor.setText(authorInfo.getCard().getName());
            tvUpTime.setText(getResources().getString(R.string.video_detail_up_time, TimeUtils.formatStringTime(data.getCreate_time())));
        }

        TagAdapter<String> adapter = new TagAdapter<String>(data.getTag_list()) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView inflate = (TextView) View.inflate(getActivity(), R.layout.adapter_video_tag, null);
                inflate.setText(s);
                return inflate;
            }
        };

        flowLayout.setAdapter(adapter);

        initRecyclerView(data.getRelative_list());
    }

    private void initRecyclerView(List<VideoItem> videoItemList) {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(manager);


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
