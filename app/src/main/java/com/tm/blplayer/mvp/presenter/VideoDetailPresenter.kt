package com.tm.blplayer.mvp.presenter

import com.tm.blplayer.listener.OnNetworkCallBackListener
import com.tm.blplayer.mvp.model.BaseModel
import com.tm.blplayer.mvp.model.VideoDetailModel
import com.tm.blplayer.mvp.view.BaseView

/**
 * @author wutongming
 * *
 * @description 视频详情页
 * *
 * @since 2017/5/18
 */

class VideoDetailPresenter : BasePresenter<BaseView>(), OnNetworkCallBackListener {

    private val mModel: BaseModel

    init {
        mModel = VideoDetailModel()
    }

    override fun requestData() {

    }

    override fun requestData(params: Map<String, String>) {
        mModel.requestData(params, this)?.let { addDisposable(it) }
    }
}
