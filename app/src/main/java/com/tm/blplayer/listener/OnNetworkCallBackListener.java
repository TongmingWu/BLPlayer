package com.tm.blplayer.listener;

import com.tm.blplayer.bean.BaseBean;

/**
 * @author wutongming
 * @description
 * @since 2017/5/16
 */

public interface OnNetworkCallBackListener {

    /**
     * 网络请求成功
     *
     * @param response 返回数据结果
     */
    void onNetworkRequestSuccess(BaseBean<?> response);

    /**
     * 网络请求服务器失败
     *
     * @param errorCode 请求失败返回的错误码
     * @param errorMsg  错误信息
     */
    void onNetworkRequestFailed(int errorCode, String errorMsg);

    /**
     * 网络请求本地错误
     *
     * @param error 请求错误信息
     */
    void onNetworkRequestError(String error);

}
