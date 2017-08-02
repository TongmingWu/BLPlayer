package com.tm.blplayer.ui.activity

import android.os.Bundle
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.View
import com.jakewharton.rxbinding.view.RxView
import com.orhanobut.logger.Logger
import com.tm.blplayer.R
import com.tm.blplayer.base.BaseActivity
import com.tm.blplayer.base.BaseFragment
import com.tm.blplayer.bean.VideoDetailData
import com.tm.blplayer.mvp.presenter.VideoDetailPresenter
import com.tm.blplayer.mvp.view.BaseView
import com.tm.blplayer.ui.fragment.VideoCommentFragment
import com.tm.blplayer.ui.fragment.VideoDescriptionFragment
import com.tm.blplayer.utils.CommonUtil
import com.tm.blplayer.utils.StringUtils
import com.tm.blplayer.utils.ToastUtils
import com.tm.blplayer.utils.constants.Constants
import com.tm.blplayer.widget.media.AndroidMediaController
import kotlinx.android.synthetic.main.activity_video_detail.*
import kotlinx.android.synthetic.main.include_common_toolbar.*
import kotlinx.android.synthetic.main.include_video_detail_top.*
import tv.danmaku.ijk.media.player.IjkMediaPlayer
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * @author wutongming
 * @description
 * @since 2017/6/14
 */
class VideoDetailActivity : BaseActivity(), BaseView {

    private var aid: String? = null
    private var mVideoDetailPresenter: VideoDetailPresenter? = null
    private var mData: VideoDetailData? = null
    private val fragments = arrayOfNulls<BaseFragment>(2)
    private var fabSize: Int = 0
    private var mediaController: AndroidMediaController? = null
    private var playUrl: String? = null
    private var mBackPressed: Boolean = false
    private var deviceWidth: Int = 0
    private var mCurrentUrlIndex: Int = 0
    private var mCurrentPlayPosition: Int = 0

    override val layoutId: Int
        get() = R.layout.activity_video_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        deviceWidth = CommonUtil.getDeviceWidth(this)
        initVideoView()
        createPresenter()
        getData()
    }

    override fun initToolbar() {
        super.initToolbar()
        ll_back.visibility = View.VISIBLE
        val intent = intent
        aid = intent.getStringExtra(Constants.VIDEO_AID)
        tv_back_title.text = resources.getString(R.string.video_detail_av, aid.toString())
        common_toolbar.setBackgroundColor(resources.getColor(R.color.transparent))
        fabSize = CommonUtil.dip2px(this, 60f)
        app_bar.addOnOffsetChangedListener({ appBarLayout, verticalOffset ->
            val totalScrollRange = app_bar.totalScrollRange.toFloat()
            val offset = Math.abs(verticalOffset).toFloat()
            val scale = 1 - offset / totalScrollRange
            val params = fab_play.layoutParams
            params.width = (fabSize * scale).toInt()
            params.height = (fabSize * scale).toInt()
            fab_play.layoutParams = params
            if (!video_view.isPlaying) {
                if (offset >= totalScrollRange) {
                    common_toolbar?.setBackgroundColor(resources.getColor(R.color.dominantColor))
                    tv_back_title.visibility = View.GONE
                    ll_play.visibility = View.VISIBLE
                    fab_play.visibility = View.GONE
                } else {
                    common_toolbar?.setBackgroundColor(resources.getColor(R.color.transparent))
                    tv_back_title.visibility = View.VISIBLE
                    ll_play.visibility = View.GONE
                    fab_play.visibility = View.VISIBLE
                }
            }
        })
    }

    override fun initView() {
        initTab()
        RxView.clicks(fab_play)
                .throttleFirst(1000, TimeUnit.MILLISECONDS)
                .subscribe({ playVideo() })
    }

    private fun initTab() {
        fragments[0] = VideoDescriptionFragment()
        fragments[1] = VideoCommentFragment()
        val array = resources.getStringArray(R.array.video_detail_tab)

        view_pager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): BaseFragment? {
                return fragments[position]
            }

            override fun getPageTitle(position: Int): CharSequence {
                return array[position]
            }

            override fun getCount(): Int {
                return fragments.size
            }
        }
        tab_layout.setupWithViewPager(view_pager)
    }

    override fun initData() {

    }

    /**
     * 播放视频
     */
    private fun playVideo() {
        if (!StringUtils.isTrimEmpty(playUrl) && !video_view.isPlaying) {
            Logger.d("playUrl = " + playUrl)
            hidePlayFab()
            video_view.start()
        }
    }

    /**
     * 执行播放按钮播放动画
     */
    private fun hidePlayFab() {
        fab_play.visibility = View.GONE
    }

    private fun initVideoView() {
        IjkMediaPlayer.loadLibrariesOnce(null)
        IjkMediaPlayer.native_profileBegin("libijkplayer.so")

        val params = video_view.layoutParams
        params.height = (deviceWidth * (9.0f / 16.0f)).toInt()

        mediaController = AndroidMediaController(this, false)

        video_view.setOnPreparedListener({ iMediaPlayer ->
            if (fab_play.visibility == View.VISIBLE) {
                fab_play.visibility = View.GONE
            }
            val duration = iMediaPlayer.duration.toInt()
        })

        video_view.setOnCompletionListener({ iMediaPlayer ->

        })

        //第二个参数为code,第三个参数
        video_view.setOnInfoListener({ iMediaPlayer, i, i1 ->
            val currentPosition = iMediaPlayer.currentPosition.toInt()
            false
        })

        video_view?.setOnErrorListener({ iMediaPlayer, i, i1 ->
            //播放失败时重试下一个链接,知道没有链接为止
            //失败的原因有403
            val size = mData?.video_info?.url_list?.size    //如果中间有空的话则返回Int的最小值,反正不会进入if就可以了
            if (mCurrentUrlIndex < size ?: Int.MIN_VALUE) {
                playUrl = mData?.video_info?.url_list?.get(mCurrentUrlIndex++)
                video_view.setVideoPath(playUrl)
                // TODO: 2017/6/9 视频防盗链
                Logger.d("next url = " + playUrl)
            } else {
                ToastUtils.showShortToast(this@VideoDetailActivity, getString(R.string.video_detail_parse_failed))
            }
            false
        })

        video_view.setMediaController(null)

    }

    private fun createPresenter() {
        mVideoDetailPresenter = mVideoDetailPresenter ?: VideoDetailPresenter()
        mVideoDetailPresenter?.onAttach(this)
    }

    private fun getData() {
        val map = HashMap<String, String>()
        map.put(Constants.VIDEO_AID, aid.toString())
        mVideoDetailPresenter?.requestData(map)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        when (view?.id) {

        }
    }

    override fun onNetworkSuccess(result: Any) {
        mData = result as VideoDetailData
        (fragments[0] as VideoDescriptionFragment).initData(mData)
        playUrl = mData?.video_info?.url_list?.get(mCurrentUrlIndex)
        video_view.setVideoPath(playUrl ?: "")
    }

    override fun onNetworkFailed(code: Int, errorMsg: String) {
        ToastUtils.showShortToast(this, "code = $code errorMsg = $errorMsg")
    }

    override fun onNetworkError(error: String) {
        ToastUtils.showShortToast(this, error)
    }

    override fun onResume() {
        super.onResume()

        if (mCurrentPlayPosition > 0) {
            //继续之前的播放
            Logger.d("继续播放,之前播放记录 ==> " + mCurrentPlayPosition)
            video_view.start()
            video_view.seekTo(mCurrentPlayPosition)
        }
    }

    override fun onBackPressed() {
        mBackPressed = true
        super.onBackPressed()
    }

    override fun onStop() {
        super.onStop()

        //暂停时记录播放值
        mCurrentPlayPosition = video_view.currentPosition

        if (mBackPressed || !video_view.isBackgroundPlayEnabled) {
            video_view.stopPlayback()
            video_view.release(true)
            video_view.stopBackgroundPlay()
            mBackPressed = false
        } else {
            video_view.enterBackground()

        }
        IjkMediaPlayer.native_profileEnd()
    }

    override fun onDestroy() {
        super.onDestroy()
        mVideoDetailPresenter?.onDetach()
        video_view.stopPlayback()
        video_view.release(true)
        video_view.stopBackgroundPlay()
        IjkMediaPlayer.native_profileEnd()
    }
}