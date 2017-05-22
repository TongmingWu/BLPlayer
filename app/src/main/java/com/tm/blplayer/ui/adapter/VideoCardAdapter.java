package com.tm.blplayer.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.tm.blplayer.R;
import com.tm.blplayer.bean.VideoItem;
import com.tm.blplayer.listener.OnItemClickListener;
import com.tm.blplayer.ui.holder.VideoCardViewHolder;
import com.tm.blplayer.utils.CommonUtil;
import com.tm.blplayer.utils.StringUtils;
import com.tm.blplayer.utils.TimeUtils;
import com.tm.blplayer.utils.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Tongming
 * description: 视频卡片适配器
 * Date: 2017/5/17
 */

public class VideoCardAdapter extends RecyclerView.Adapter<VideoCardViewHolder> implements View.OnClickListener {

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
        holder.itemView.setTag(R.id.tag_data, videoItem);
        holder.itemView.setTag(R.id.tag_position, position);
        int play = videoItem.getStat().getView();
        int review = videoItem.getStat().getDanmaku();

        Glide.with(mContext)
                .load(videoItem.getPic())
                .placeholder(R.drawable.ic_default_image)
                .centerCrop()
                .dontAnimate()
                .into(holder.ivCover);

        holder.tvPlayCount.setText(play > 10000 ? mContext.getResources().getString(R.string.home_video_count, StringUtils.DecimalFormat(play)) : String.valueOf(play));
        holder.tvDanmakuCount.setText(review > 10000 ? String.valueOf(mContext.getResources().getString(R.string.home_video_count, StringUtils.DecimalFormat(review))) : String.valueOf(review));
        holder.tvDuration.setText(TimeUtils.formatDuration(videoItem.getDuration()));
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
            mOnItemClickListener.onItemClick(v, v.getTag(R.id.tag_data), (Integer) v.getTag(R.id.tag_position));
        }
    }

}
