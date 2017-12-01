package com.tm.blplayer.ui.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import com.orhanobut.logger.Logger
import com.tm.blplayer.R
import com.tm.blplayer.base.BaseAdapter
import com.tm.blplayer.base.BaseViewHolder
import com.tm.blplayer.bean.VideoItem
import com.tm.blplayer.utils.CommonUtil
import com.tm.blplayer.utils.GlideUtils
import com.tm.blplayer.utils.StringUtils
import com.tm.blplayer.utils.TimeUtils
import com.tm.blplayer.utils.constants.Constants

/**
 * Author: Tongming
 * description: 视频卡片适配器
 * Date: 2017/5/17
 */

class VideoCardAdapter(mContext: Context, mData: List<VideoItem>, private val isGrid: Boolean) : BaseAdapter<VideoItem>(mContext, mData) {
    /**
     * 屏幕宽度
     */
    private val mWidth: Int = CommonUtil.getScreenWidth(mContext)

    override fun bind(holder: BaseViewHolder, item: VideoItem, position: Int) {
        val play = item.stat.view
        val review = item.stat.danmaku

        GlideUtils.loadNetImage(mContext, item.pic, holder.getView<ImageView>(R.id.iv_cover))

        holder.setText(R.id.tv_play_count, if (play > 10000) mContext.resources.getString(R.string.home_video_count, StringUtils.DecimalFormat(play)) else play.toString())
        holder.setText(R.id.tv_danmaku_count, if (review > 10000) mContext.resources.getString(R.string.home_video_count, StringUtils.DecimalFormat(review)).toString() else review.toString())
        holder.setText(R.id.tv_title, item.title)
        if (isGrid) {
            holder.setText(R.id.tv_duration, TimeUtils.formatDuration(item.duration))
            holder.setText(R.id.tv_type_name, item.tname)
        } else {
            holder.setText(R.id.tv_author, item.owner.name)
        }

        holder.setOnChildClickListener(R.id.iv_card_more, { v: View -> Logger.d("点击更多") })
    }

    override val layoutId: Int
        get() {
            if (isGrid) {
                return R.layout.adapter_video_card
            } else {
                return R.layout.adapter_video_card_line
            }
        }

    override fun afterCreatedHolder(holder: BaseViewHolder) {
        if (isGrid) {
            //处理屏幕适配问题
            val ivCover = holder.getView<ImageView>(R.id.iv_cover)
            val rlCover = holder.getView<RelativeLayout>(R.id.rl_cover)
            val params = ivCover.layoutParams
            val rlParams = rlCover.layoutParams
            val width = (mWidth / 2 - Constants.CARD_MARGIN * 1.5).toInt()
            val height = (width / 1.6f).toInt()
            params.width = width
            params.height = height
            ivCover.layoutParams = params
            rlParams.width = width
            rlParams.height = height
            rlCover.layoutParams = rlParams
        }
    }

}
