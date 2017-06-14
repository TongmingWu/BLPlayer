package com.tm.blplayer.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.orhanobut.logger.Logger
import com.tm.blplayer.R
import com.tm.blplayer.bean.BannerItem
import com.tm.blplayer.bean.HomeData
import com.tm.blplayer.bean.VideoItem
import com.tm.blplayer.listener.OnItemClickListener
import com.tm.blplayer.mvp.presenter.RecommendPresenter
import com.tm.blplayer.mvp.view.BaseView
import com.tm.blplayer.ui.activity.VideoDetailActivity
import com.tm.blplayer.ui.adapter.VideoCardAdapter
import com.tm.blplayer.utils.CommonUtil
import com.tm.blplayer.utils.StringUtils
import com.tm.blplayer.utils.ToastUtils
import com.tm.blplayer.utils.constants.Constants
import com.tm.blplayer.widget.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_recommend.*
import java.util.*

/**
 * @author wutongming
 * *
 * @description 推荐
 * *
 * @since 2017/4/18
 */

class RecommendFragment : BaseFragment(), BaseView {
    private val mData = ArrayList<VideoItem>()

    private var mAdapter: VideoCardAdapter? = null

    override val layoutId: Int
        get() = R.layout.fragment_recommend

    override fun initView() {
        initRefreshLayout()
        initBannerLayout()
        initRecyclerView()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createPresenter()
        getData()
    }

    /**
     * 初始化刷新控件
     */
    private fun initRefreshLayout() {
        refresh_layout.setOnRefreshListener({ this.getData() })
    }

    /**
     * 根据手机分辨率设置bannerLayout大小  -->  图片比例2:1
     */
    private fun initBannerLayout() {
        val width = CommonUtil.getScreenWidth(activity)
        val params = banner.layoutParams
        params?.height = width / 2
        banner.layoutParams = params
    }

    /**
     * 初始化RecyclerView
     */
    private fun initRecyclerView() {
        val manager = GridLayoutManager(activity, 2)
        mAdapter = VideoCardAdapter(activity, mData, true)
        mAdapter?.setOnItemClickListener(object : OnItemClickListener<VideoItem> {
            override fun onItemClick(view: View, data: VideoItem, position: Int) {
                val intent = Intent(activity, VideoDetailActivity::class.java)
                intent.putExtra(Constants.VIDEO_AID, data.aid)
                startActivity(intent)
            }
        })
        rv_recommend.layoutManager = manager
        rv_recommend.adapter = mAdapter
        rv_recommend.isNestedScrollingEnabled = false
        rv_recommend.addItemDecoration(GridSpacingItemDecoration(2, Constants.CARD_MARGIN, true))
    }

    /**
     * 刷新控件开关
     */
    private fun toggleRefresh(refresh: Boolean) {
        Handler().post { refresh_layout.isRefreshing = refresh }
    }

    /**
     * 创建presenter
     */
    private fun createPresenter() {
        presenter = presenter ?: RecommendPresenter()
        presenter?.onAttach(this)
    }

    /**
     * 获取数据
     */
    private fun getData() {
        toggleRefresh(true)
        presenter?.requestData()
    }

    override fun onNetworkSuccess(result: Any) {
        toggleRefresh(false)
        val data = result as HomeData
        if (data.video_list.size > 0) {
            banner.setViewUrls(filterBannerUrls(data.banner))
            banner.setOnBannerItemClickListener { position ->
                // TODO: 2017/5/17 banner点击跳转
            }
            initBannerLayout()

            mData.clear()
            mData.addAll(data.video_list)
            mAdapter?.notifyDataSetChanged()
        } else {
            //空处理,展示空布局
            Logger.e("获取不到数据")
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }

    /**
     * 清洗banner中的url
     */
    private fun filterBannerUrls(bannerItemList: List<BannerItem>): List<String> {
        val result = bannerItemList.map { StringUtils.filterUrl(it.pic) }
        return result
    }

    override fun onNetworkFailed(code: Int, errorMsg: String) {
        toggleRefresh(false)
        ToastUtils.showShortToast(activity, errorMsg)
    }

    override fun onNetworkError(error: String) {
        toggleRefresh(false)
        ToastUtils.showShortToast(activity, error)
    }
}
