package com.tm.blplayer.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.tm.blplayer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author wutongming
 * @description 视频卡片holder
 * @since 2017/5/22
 */

public class VideoCardViewHolder extends RecyclerView.ViewHolder {
    public View itemView;
    @BindView(R.id.rl_cover)
    public RelativeLayout rlCover;
    @BindView(R.id.iv_cover)
    public ImageView ivCover;
    @BindView(R.id.tv_play_count)
    public TextView tvPlayCount;
    @BindView(R.id.tv_danmaku_count)
    public TextView tvDanmakuCount;
    @BindView(R.id.tv_duration)
    public TextView tvDuration;
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    @BindView(R.id.tv_type_name)
    public TextView tvType;
    @BindView(R.id.iv_card_more)
    public ImageView ivMore;

    public VideoCardViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }

    @OnClick({R.id.iv_card_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_card_more:
                Logger.d("点击更多");
                break;
        }
    }
}
