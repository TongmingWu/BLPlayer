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
    public static final int HTTP_CACHE_STALE_SHORT = 10;

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

    /**
     * 视频卡片间距
     */
    public static final int CARD_MARGIN = 30;

    /**
     * 视频aid
     */
    public static final String VIDEO_AID = "video_aid";
}
