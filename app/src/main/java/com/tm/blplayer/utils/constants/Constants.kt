package com.tm.blplayer.utils.constants

import okhttp3.MediaType

/**
 * @author wutongming
 * *
 * @description 常量
 * *
 * @since 2017/4/17
 */

object Constants {
    /**
     * http短缓存时间
     */
    val HTTP_CACHE_STALE_SHORT = 5

    /**
     * http长缓存时间
     */
    val HTTP_CACHE_STALE_LONG = 60 * 60 * 24

    /**
     * http缓存大小
     */
    val HTTP_CACHE_SIZE = 1024 * 1024 * 100

    /**
     * 声明JSON格式
     */
    val MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8")

    /**
     * 视频卡片间距
     */
    val CARD_MARGIN = 30

    /**
     * 视频aid
     */
    val VIDEO_AID = "video_aid"

    /**成功的请求码*/
    val REQUEST_SUCCEED = 0
}
