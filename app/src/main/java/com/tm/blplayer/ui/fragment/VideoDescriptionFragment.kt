package com.tm.blplayer.ui.fragment

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tm.blplayer.R
import com.tm.blplayer.base.BaseFragment
import com.tm.blplayer.bean.VideoDetailData
import com.tm.blplayer.bean.VideoItem
import com.tm.blplayer.listener.OnItemClickListener
import com.tm.blplayer.ui.activity.VideoDetailActivity
import com.tm.blplayer.ui.adapter.VideoCardAdapter
import com.tm.blplayer.utils.StringUtils
import com.tm.blplayer.utils.TimeUtils
import com.tm.blplayer.utils.constants.Constants
import com.tm.blplayer.widget.GlideCircleTransform
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import kotlinx.android.synthetic.main.include_desc_bottom.*
import kotlinx.android.synthetic.main.include_desc_middle.*
import kotlinx.android.synthetic.main.include_desc_top.*

/**
 * @author wutongming
 * @description
 * @since 2017/6/14
 */
class VideoDescriptionFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_video_desc

    override fun initView() {

    }

    fun initData(data: VideoDetailData?) {
        tv_title.text = data?.title
        tv_desc.text = data?.desc
        val playInfo = data?.play_info
        val authorInfo = data?.author_info
        if (playInfo != null) {
            val viewCount = playInfo.view
            val danmakuCount = playInfo.danmaku
            val shareCount = playInfo.share
            val coinCount = playInfo.coin
            val favoriteCount = playInfo.favorite

            tv_play_count.text = if (viewCount > 10000) resources.getString(R.string.home_video_count, StringUtils.DecimalFormat(viewCount)) else viewCount.toString()
            tv_danmaku_count.text = if (danmakuCount > 10000) resources.getString(R.string.home_video_count, StringUtils.DecimalFormat(danmakuCount)) else danmakuCount.toString()
            tv_share.text = if (shareCount > 10000) resources.getString(R.string.home_video_count, StringUtils.DecimalFormat(shareCount)) else shareCount.toString()
            tv_coin.text = if (coinCount > 10000) resources.getString(R.string.home_video_count, StringUtils.DecimalFormat(coinCount)) else coinCount.toString()
            tv_collect.text = if (favoriteCount > 10000) resources.getString(R.string.home_video_count, StringUtils.DecimalFormat(favoriteCount)) else favoriteCount.toString()
        }
        if (authorInfo != null) {
            Glide.with(activity).load(authorInfo.card.face).transform(GlideCircleTransform(activity)).into(iv_avatar)
            tv_author.text = authorInfo.card.name
            tv_up_time.text = resources.getString(R.string.video_detail_up_time, TimeUtils.formatStringTime(data.create_time))
        }

        val adapter = object : TagAdapter<String>(data?.tag_list) {
            override fun getView(parent: FlowLayout, position: Int, s: String): View {
                val inflate = View.inflate(activity, R.layout.adapter_video_tag, null) as TextView
                inflate.text = s
                return inflate
            }
        }

        flow_layout.adapter = adapter

        initRecyclerView(data?.relative_list)

    }

    private fun initRecyclerView(videoItemList: List<VideoItem>?) {
        val manager = LinearLayoutManager(activity)
        rv_relative.layoutManager = manager
        val adapter = VideoCardAdapter(activity, videoItemList ?: ArrayList<VideoItem>(), false)
        adapter.setOnItemClickListener(object : OnItemClickListener<VideoItem> {
            override fun onItemClick(view: View, data: VideoItem, position: Int) {
                val intent = Intent(activity, VideoDetailActivity::class.java)
                intent.putExtra(Constants.VIDEO_AID, data.aid)
                startActivity(intent)
            }
        })
        rv_relative.adapter = adapter
        rv_relative.isNestedScrollingEnabled = false
    }

    override fun onClick(v: View?) {
        when (view?.id) {
            R.id.tv_share -> {
            }
            R.id.tv_coin -> {
            }
            R.id.tv_collect -> {
            }
            R.id.tv_download -> {
            }
        }
    }
}
