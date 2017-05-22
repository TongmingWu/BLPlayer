package com.tm.blplayer.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;
import com.tm.blplayer.R;
import com.tm.blplayer.bean.VideoItem;
import com.tm.blplayer.listener.OnItemClickListener;
import com.tm.blplayer.utils.CommonUtil;
import com.tm.blplayer.utils.StringUtils;
import com.tm.blplayer.utils.constants.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author: Tongming
 * description: 视频卡片适配器
 * Date: 2017/5/17
 */

public class VideoCardAdapter extends RecyclerView.Adapter<VideoCardAdapter.VideoCardViewHolder> implements View.OnClickListener {

    private List<VideoItem> mData = new ArrayList<>();
    private Context mContext;
    /**
     * 单击监听
     */
    private OnItemClickListener mOnItemClickListener;
    /**
     * 屏幕宽度
     */
    private int mWidth;

    public VideoCardAdapter(Context mContext, List<VideoItem> mData) {
        this.mData = mData;
        this.mContext = mContext;
        this.mWidth = CommonUtil.getScreenWidth(mContext);
    }

    @Override
    public VideoCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(mContext, R.layout.adapter_video_card, null);
        inflate.setOnClickListener(this);
        VideoCardViewHolder holder = new VideoCardViewHolder(inflate);
        //处理屏幕适配问题
        ViewGroup.LayoutParams params = holder.ivCover.getLayoutParams();
        ViewGroup.LayoutParams rlParams = holder.rlCover.getLayoutParams();
        int width = (int) (mWidth / 2 - Constants.CARD_MARGIN * 1.5);
        int height = (int) (width / 1.6f);
        params.width = width;
        params.height = height;
        holder.ivCover.setLayoutParams(params);
        rlParams.width = width;
        rlParams.height = height;
        holder.rlCover.setLayoutParams(rlParams);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoCardViewHolder holder, int position) {
        VideoItem videoItem = mData.get(position);
        holder.itemView.setTag(R.id.ll_video_card, videoItem);
        holder.itemView.setTag(R.id.card_view, position);
        String play = videoItem.getStat().getView();
        try {
            int temp = Integer.parseInt(play);
            if (temp > 10000.0f) {         //如果大于一万的话则以0.0的计数方式
                play = mContext.getResources().getString(R.string.home_video_count, StringUtils.DecimalFormat(temp / 10000.0f));
            }
        } catch (NumberFormatException e) {
            //出现问题的值为 "--"
            Logger.e("数字转换异常,当前play = " + play);
        }
        String review = videoItem.getStat().getDanmaku();
        try {
            int temp = Integer.parseInt(review);
            if (temp > 10000.0f) {         //如果大于一万的话则以0.0的计数方式
                review = mContext.getResources().getString(R.string.home_video_count, StringUtils.DecimalFormat(temp / 10000.0f));
            }
        } catch (NumberFormatException e) {
            Logger.e("数字转换异常,当前review = " + review);
        }

        Glide.with(mContext)
                .load(videoItem.getPic())
                .placeholder(R.drawable.ic_default_image)
                .centerCrop()
                .dontAnimate()
                .into(holder.ivCover);

        holder.tvPlayCount.setText(play);
        holder.tvDanmakuCount.setText(String.valueOf(review));
        holder.tvDuration.setText(StringUtils.formatTime(videoItem.getDuration()));
        holder.tvTitle.setText(videoItem.getTitle());
        holder.tvType.setText(videoItem.getTname());
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
        @BindView(R.id.rl_cover)
        RelativeLayout rlCover;
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
        @BindView(R.id.tv_type_name)
        TextView tvType;
        @BindView(R.id.iv_card_more)
        ImageView ivMore;

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
}
