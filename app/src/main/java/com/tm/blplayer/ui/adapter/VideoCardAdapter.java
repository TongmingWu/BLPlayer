package com.tm.blplayer.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tm.blplayer.R;
import com.tm.blplayer.bean.VideoItem;
import com.tm.blplayer.listener.OnItemClickListener;
import com.tm.blplayer.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author: Tongming
 * description: 视频卡片适配器
 * Date: 2017/5/17
 */

public class VideoCardAdapter extends RecyclerView.Adapter<VideoCardAdapter.VideoCardViewHolder> implements View.OnClickListener {

    private List<VideoItem> mData = new ArrayList<>();
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public VideoCardAdapter(Context mContext, List<VideoItem> mData) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public VideoCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(mContext, R.layout.adapter_video_card, null);
        inflate.setOnClickListener(this);
        VideoCardViewHolder holder = new VideoCardViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoCardViewHolder holder, int position) {
        VideoItem videoItem = mData.get(position);
        holder.itemView.setTag(R.id.ll_video_card, videoItem);
        holder.itemView.setTag(R.id.card_view, position);
        String play = videoItem.getPlay();
        try {
            float temp = Float.parseFloat(play);
            if (temp > 10000.0f) {         //如果大于一万的话则以0.0的计数方式
                play = mContext.getResources().getString(R.string.home_video_count, StringUtils.DecimalFormat(temp / 10000.0f));
            }
        } catch (NumberFormatException e) {
            play = "0";
        }
        String review = videoItem.getVideo_review();
        try {
            float temp = Float.parseFloat(play);
            if (temp > 10000.0f) {         //如果大于一万的话则以0.0的计数方式
                review = mContext.getResources().getString(R.string.home_video_count, StringUtils.DecimalFormat(temp / 10000.0f));
            }
        } catch (NumberFormatException e) {
            review = "0";
        }

        Glide.with(mContext)
                .load(videoItem.getPic())
                .placeholder(R.drawable.ic_default_image)
                .dontAnimate()
                .into(holder.ivCover);

        holder.tvPlayCount.setText(play);
        holder.tvDanmakuCount.setText(String.valueOf(review));
        holder.tvDuration.setText(videoItem.getDuration());
        holder.tvTitle.setText(videoItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v.getTag(R.id.ll_video_card), (Integer) v.getTag(R.id.card_view));
        }
    }

    class VideoCardViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.tv_play_count)
        TextView tvPlayCount;
        @BindView(R.id.tv_danmaku_count)
        TextView tvDanmakuCount;
        @BindView(R.id.tv_duration)
        TextView tvDuration;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        public VideoCardViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }
    }
}
