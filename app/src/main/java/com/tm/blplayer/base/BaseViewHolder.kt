package com.tm.blplayer.base

import android.content.Context
import android.graphics.Color
import android.support.annotation.ColorRes
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.widget.TextView

/**
 * @author wutongming
 * *
 * @description ViewHolder基类
 * *
 * @since 2017/5/22
 */

class BaseViewHolder constructor(itemView: View, private val mContext: Context) : RecyclerView.ViewHolder(itemView) {
    private val mViews: SparseArray<View> = SparseArray()

    fun getItemView(): View {
        return itemView
    }

    fun <V : View> getView(@IdRes id: Int): V {
        var view: View? = mViews.get(id)
        if (view == null) {
            view = itemView.findViewById(id)
            mViews.put(id, view)
        }
        return view as V
    }

    fun setText(id: Int, value: CharSequence): BaseViewHolder {
        val view = getView<TextView>(id)
        view.text = value
        return this
    }

    fun setText(id: Int, @StringRes value: Int): BaseViewHolder {
        val view = getView<TextView>(id)
        view.setText(value)
        return this
    }

    fun setTextColor(id: Int, textColor: String): BaseViewHolder {
        val view = getView<TextView>(id)
        view.setTextColor(Color.parseColor(textColor))
        return this
    }

    fun setTextColor(id: Int, @ColorRes textColor: Int): BaseViewHolder {
        val view = getView<TextView>(id)
        view.setTextColor(mContext.resources.getColor(textColor))
        return this
    }

    fun setOnChildClickListener(viewId: Int, listener: (View) -> Unit): BaseViewHolder {
        val view = getView<View>(viewId)
        view.setOnClickListener(listener)
        return this
    }

    fun setOnChildLongClickListener(viewId: Int, listener: View.OnLongClickListener): BaseViewHolder {
        val view = getView<View>(viewId)
        view.setOnLongClickListener(listener)
        return this
    }
}
