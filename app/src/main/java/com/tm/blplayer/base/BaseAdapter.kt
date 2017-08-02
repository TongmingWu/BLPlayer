package com.tm.blplayer.base

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.tm.blplayer.R
import com.tm.blplayer.listener.OnItemClickListener
import java.util.*

/**
 * @author wutongming
 * *
 * @description 适配器基类
 * *
 * @since 2017/5/22
 */

abstract class BaseAdapter<T>(protected var mContext: Context, mData: List<T>) : RecyclerView.Adapter<BaseViewHolder>(), View.OnClickListener {

    /**
     * 数据集
     */
    protected var mData: List<T> = ArrayList()

    protected var mOnItemClickListener: OnItemClickListener<T>? = null

    private val mHeaderLayout: ViewGroup? = null
    private val mFooterlayout: ViewGroup? = null

    object VIEW_TYPE {
        val HEADER = 0x6633
        val FOOTER = 0x3366
        val NORMAL = 0x6363
    }

    init {
        this.mData = mData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflate = View.inflate(mContext, layoutId, null)
        inflate.setOnClickListener(this)
        val holder = BaseViewHolder(inflate, mContext)
        afterCreatedHolder(holder)
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = mData[position]
        holder.getItemView().setTag(R.id.tag_data, item)
        holder.getItemView().setTag(R.id.tag_position, position)
        bind(holder, item, position)
    }

    override fun getItemViewType(position: Int): Int {

        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    protected abstract fun bind(holder: BaseViewHolder, item: T, position: Int)

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected abstract fun afterCreatedHolder(holder: BaseViewHolder)

    override fun onClick(v: View) {
        mOnItemClickListener?.onItemClick(v, v.getTag(R.id.tag_data) as T, v.getTag(R.id.tag_position) as Int)
    }

    /**
     * 设置item点击监听
     */
    fun setOnItemClickListener(listener: OnItemClickListener<T>) {
        this.mOnItemClickListener = listener
    }
}
