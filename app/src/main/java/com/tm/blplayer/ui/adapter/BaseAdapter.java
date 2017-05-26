package com.tm.blplayer.ui.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.tm.blplayer.R;
import com.tm.blplayer.listener.OnItemClickListener;
import com.tm.blplayer.ui.holder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wutongming
 * @description 适配器基类
 * @since 2017/5/22
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> implements View.OnClickListener {

    /**
     * 单击监听
     */
    protected OnItemClickListener mOnItemClickListener;
    /**
     * 数据集
     */
    protected List<T> mData = new ArrayList<>();
    protected Context mContext;

    private ViewGroup mHeaderLayout;
    private ViewGroup mFooterlayout;

    public static class VIEW_TYPE {
        public static final int HEADER = 0x6633;
        public static final int FOOTER = 0x3366;
        public static final int NORMAL = 0x6363;
    }

    public BaseAdapter(@NotNull Context mContext, @NotNull List<T> mData) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(mContext, getLayoutId(), null);
        inflate.setOnClickListener(this);
        BaseViewHolder holder = new BaseViewHolder(inflate, mContext);
        afterCreatedHolder(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        T item = mData.get(position);
        holder.itemView.setTag(R.id.tag_data, item);
        holder.itemView.setTag(R.id.tag_position, position);
        bind(holder, item, position);
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    protected abstract void bind(BaseViewHolder holder, T item, int position);

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void afterCreatedHolder(BaseViewHolder holder);

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, v.getTag(R.id.tag_data), (Integer) v.getTag(R.id.tag_position));
        }
    }

    /**
     * 设置item点击监听
     */
    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        this.mOnItemClickListener = listener;
    }
}
