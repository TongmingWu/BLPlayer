package com.tm.blplayer.mvp.model

import com.tm.blplayer.listener.OnNetworkCallBackListener
import com.tm.blplayer.network.ApiManager
import com.tm.blplayer.observer.NetworkObserver

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @author wutongming
 * *
 * @description 推荐页
 * *
 * @since 2017/5/17
 */

class RecommendModel : BaseModel {
    override fun requestData(params: Map<String, String>, listener: OnNetworkCallBackListener): Disposable? {
        return null
    }

    override fun requestData(listener: OnNetworkCallBackListener): Disposable? {
        val observer = NetworkObserver(listener)
        ApiManager.getInstance()
                .homeData
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer)
        return observer.disposable
    }

}
