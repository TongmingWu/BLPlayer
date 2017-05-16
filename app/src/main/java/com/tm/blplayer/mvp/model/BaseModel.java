package com.tm.blplayer.mvp.model;

import java.util.Map;

import rx.Subscription;

/**
 * @author wutongming
 * @description
 * @since 2017/5/16
 */

public interface BaseModel {

    /**
     * 获取数据
     *
     * @param params 携带参数
     */
    Subscription requestData(Map<String, String> params);

}
