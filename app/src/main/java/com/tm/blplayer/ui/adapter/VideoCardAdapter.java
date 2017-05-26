package com.tm.blplayer.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.orhanobut.logger.Logger;
import com.tm.blplayer.R;
import com.tm.blplayer.bean.VideoItem;
import com.tm.blplayer.ui.holder.BaseViewHolder;
import com.tm.blplayer.utils.CommonUtil;
import com.tm.blplayer.utils.GlideUtils;
import com.tm.blplayer.utils.StringUtils;
import com.tm.blplayer.utils.TimeUtils;
import com.tm.blplayer.utils.constants.Constants;

import java.util.List;

/**
 * Author: Tongming
 * description: 视频卡片适配器
 * Date: 2017/5/17
 */

public class VideoCardAdapter extends BaseAdapter<VideoItem> {
    /**
     * 屏幕宽度
     */
    private int mWidth;
    private boolean isGrid;

    public VideoCardAdapter(Context mContext, List<VideoItem> mData, boolean isGrid) {
        super(mContext, mData);
        this.mWidth = CommonUtil.getScreenWidth(mContext);
        this.isGrid = isGrid;
    }

    @Override
    protected void bind(BaseViewHolder holder, VideoItem item, int position) {
        int play = item.getStat().getView();
        int review = item.getStat().getDanmaku();

        GlideUtils.loadNetImage(mContext, item.getPic(), holder.getView(R.id.iv_cover));

        holder.setText(R.id.tv_play_count, play > 10000 ? mContext.getResources().getString(R.string.home_video_count, StringUtils.DecimalFormat(play)) : String.valueOf(play));
        holder.setText(R.id.tv_danmaku_count, review > 10000 ? String.valueOf(mContext.getResources().getString(R.string.home_video_count, StringUtils.DecimalFormat(review))) : String.valueOf(review));
        holder.setText(R.id.tv_title, item.getTitle());
        if (isGrid) {
            holder.setText(R.id.tv_duration, TimeUtils.formatDuration(item.getDuration()));
            holder.setText(R.id.tv_type_name, item.getTname());
        } else {
            holder.setText(R.id.tv_author, item.getOwner().getName());
        }

        holder.setOnChildClickListener(R.id.iv_card_more, (View v) -> Logger.d("点击更多"));
    }

    @Override
    protected int getLayoutId() {
        if (isGrid) {
            return R.layout.adapter_video_card;
        } else {
            return R.layout.adapter_video_card_line;
        }
    }

    @Override
    protected void afterCreatedHolder(BaseViewHolder holder) {
        if (isGrid) {
            //处理屏幕适配问题
            ImageView ivCover = holder.getView(R.id.iv_cover);
            RelativeLayout rlCover = holder.getView(R.id.rl_cover);
            ViewGroup.LayoutParams params = ivCover.getLayoutParams();
            ViewGroup.LayoutParams rlParams = rlCover.getLayoutParams();
            int width = (int) (mWidth / 2 - Constants.CARD_MARGIN * 1.5);
            int height = (int) (width / 1.6f);
            params.width = width;
            params.height = height;
            ivCover.setLayoutParams(params);
            rlParams.width = width;
            rlParams.height = height;
            rlCover.setLayoutParams(rlParams);
        }
    }

}
