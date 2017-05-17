package com.tm.blplayer.mvp.model;

import com.tm.blplayer.listener.OnNetworkCallBackListener;

import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * @author wutongming
 * @description
 * @since 2017/5/16
 */

public interface BaseModel {

    /**
     * 获取数据
     *
     * @param params   携带参数
     * @param listener presenter回调监听
     */
    Disposable requestData(Map<String, String> params, OnNetworkCallBackListener listener);

    /**
     * 获取数据     无参
     *
     * @param listener presenter回调监听
     */
    Disposable requestData(OnNetworkCallBackListener listener);

}
