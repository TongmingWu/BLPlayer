package com.tm.blplayer.ui.holder;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;

/**
 * @author wutongming
 * @description ViewHolder基类
 * @since 2017/5/22
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    public View itemView;
    private SparseArray<View> mViews;
    private Context mContext;

    public BaseViewHolder(View itemView, Context context) {
        super(itemView);
        this.itemView = itemView;
        this.mContext = context;
        mViews = new SparseArray<>();
        ButterKnife.bind(this, itemView);
    }

    public <V extends View> V getView(@IdRes int id) {
        View view = mViews.get(id);
        if (view == null) {
            view = ButterKnife.findById(itemView, id);
            mViews.put(id, view);
        }
        return (V) view;
    }

    public BaseViewHolder setText(int id, CharSequence value) {
        TextView view = getView(id);
        view.setText(value);
        return this;
    }

    public BaseViewHolder setText(int id, @StringRes int value) {
        TextView view = getView(id);
        view.setText(value);
        return this;
    }

    public BaseViewHolder setTextColor(int id, String textColor) {
        TextView view = getView(id);
        view.setTextColor(Color.parseColor(textColor));
        return this;
    }

    public BaseViewHolder setTextColor(int id, @ColorRes int textColor) {
        TextView view = getView(id);
        view.setTextColor(mContext.getResources().getColor(textColor));
        return this;
    }

    public BaseViewHolder setOnChildClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public BaseViewHolder setOnChildLongClickListener(int viewId, View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }
}
