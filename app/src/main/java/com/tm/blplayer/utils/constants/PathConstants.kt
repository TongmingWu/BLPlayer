package com.tm.blplayer.utils.constants

import android.os.Environment
import com.tm.blplayer.BLApplication

/**
 * @author wutongming
 * *
 * @description 路径常量
 * *
 * @since 2017/4/17
 */

object PathConstants {
    /**
     * SDCard路径
     */
    val SDCARD = Environment.getExternalStorageDirectory().absolutePath ?: "/"

    /**
     * 缓存文件路径
     */
    val CACHE = BLApplication.instance?.cacheDir?.absolutePath ?: "/"

    /**
     * HTTP缓存文件存储路径
     */
    val CACHE_HTTP = CACHE + "/http/"

    /**
     * Glide缓存文件路径
     */
    val CACHE_GLIDE = CACHE + "/glide/"

    /**
     * SDCard文件存储路径
     */
    val SDCARD_BL = SDCARD + "/BLPlayer/"
}
