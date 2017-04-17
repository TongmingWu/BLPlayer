package com.tm.blplayer.utils.constants;

import okhttp3.MediaType;

/**
 * @author wutongming
 * @description 常量
 * @since 2017/4/17
 */

public class Constants {
    /**
     * http短缓存时间
     */
    public static final int HTTP_CACHE_STALE_SHORT = 120;

    /**
     * http长缓存时间
     */
    public static final int HTTP_CACHE_STALE_LONG = 60 * 60 * 24;

    /**
     * http缓存大小
     */
    public static final int HTTP_CACHE_SIZE = 1024 * 1024 * 100;

    /**
     * 声明JSON格式
     */
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

}
