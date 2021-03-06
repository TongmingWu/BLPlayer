package com.tm.blplayer.mvp.model

import com.tm.blplayer.listener.OnNetworkCallBackListener

import io.reactivex.disposables.Disposable

/**
 * @author wutongming
 * *
 * @description
 * *
 * @since 2017/5/16
 */

interface BaseModel {

    /**
     * 获取数据

     * @param params   携带参数
     * *
     * @param listener presenter回调监听
     */
    fun requestData(params: Map<String, String>, listener: OnNetworkCallBackListener): Disposable?

    /**
     * 获取数据     无参

     * @param listener presenter回调监听
     */
    fun requestData(listener: OnNetworkCallBackListener): Disposable?

}
