package com.tm.blplayer.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.tm.blplayer.R;
import com.tm.blplayer.bean.VideoItem;
import com.tm.blplayer.listener.OnItemClickListener;
import com.tm.blplayer.ui.holder.VideoCardViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wutongming
 * @description 占一行的view
 * @since 2017/5/22
 */

public class LineVideoAdapter extends RecyclerView.Adapter<VideoCardViewHolder> implements View.OnClickListener {

    private List<VideoItem> mData = new ArrayList<>();
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public LineVideoAdapter(Context mContext, List<VideoItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public VideoCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(mContext, R.layout.adapter_video_card_line, null);
        VideoCardViewHolder holder = new VideoCardViewHolder(inflate);
        holder.itemView.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoCardViewHolder holder, int position) {
        VideoItem videoItem = mData.get(position);
        holder.itemView.setTag(R.id.ll_video_card, videoItem);
        holder.itemView.setTag(R.id.card_view, position);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View v) {

    }
}
