package com.tm.blplayer.listener

import com.tm.blplayer.bean.BaseBean

/**
 * @author wutongming
 * *
 * @description
 * *
 * @since 2017/5/16
 */

interface OnNetworkCallBackListener {

    /**
     * 网络请求成功

     * @param response 返回数据结果
     */
    fun onNetworkRequestSuccess(response: BaseBean<*>)

    /**
     * 网络请求服务器失败

     * @param errorCode 请求失败返回的错误码
     * *
     * @param errorMsg  错误信息
     */
    fun onNetworkRequestFailed(errorCode: Int, errorMsg: String)

    /**
     * 网络请求本地错误

     * @param error 请求错误信息
     */
    fun onNetworkRequestError(error: String)

}
