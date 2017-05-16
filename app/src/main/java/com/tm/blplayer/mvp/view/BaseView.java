package com.tm.blplayer.mvp.view;

/**
 * @author wutongming
 * @description
 * @since 2017/5/16
 */

public interface BaseView {

    /**
     * 获取数据成功
     *
     * @param result BaseBean中的result
     */
    void onNetworkSuccess(Object result);

    /**
     * 远程网络错误
     *
     * @param code     错误代码
     * @param errorMsg 错误信息
     */
    void onNetworkFailed(int code, String errorMsg);

    /**
     * 本地网络错误
     *
     * @param error 异常信息
     */
    void onNetworkError(String error);

}
