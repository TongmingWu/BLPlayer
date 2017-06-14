package com.tm.blplayer.mvp.model

import com.tm.blplayer.listener.OnNetworkCallBackListener
import com.tm.blplayer.network.ApiManager
import com.tm.blplayer.observer.NetworkObserver
import com.tm.blplayer.utils.constants.Constants

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @author wutongming
 * *
 * @description 获取视频详情页数据
 * *
 * @since 2017/5/18
 */

class VideoDetailModel : BaseModel {
    override fun requestData(params: Map<String, String>, listener: OnNetworkCallBackListener): Disposable? {
        val aid = params[Constants.VIDEO_AID]
        val observer = NetworkObserver(listener)
        ApiManager.getInstance()
                .getVideoDetail(aid ?: "0")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer)
        return observer.disposable
    }

    override fun requestData(listener: OnNetworkCallBackListener): Disposable? {
        return null
    }
}
