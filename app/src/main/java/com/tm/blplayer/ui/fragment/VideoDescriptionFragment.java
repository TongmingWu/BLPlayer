package com.tm.blplayer.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tm.blplayer.R;
import com.tm.blplayer.bean.VideoDetailData;
import com.tm.blplayer.widget.GlideCircleTransform;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

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
            tvPlayCount.setText(String.valueOf(playInfo.getView()));
            tvDanmakuCount.setText(String.valueOf(playInfo.getDanmaku()));
            tvShare.setText(String.valueOf(playInfo.getShare()));
            tvCoin.setText(String.valueOf(playInfo.getCoin()));
            tvCollect.setText(String.valueOf(playInfo.getFavorite()));
        }
        if (authorInfo != null) {
            Glide.with(getActivity()).load(authorInfo.getCard().getFace()).transform(new GlideCircleTransform(getActivity())).into(ivAvatar);
            tvAuthor.setText(authorInfo.getCard().getName());
            tvUpTime.setText(getResources().getString(R.string.video_detail_up_time, data.getCreate_time()));
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
