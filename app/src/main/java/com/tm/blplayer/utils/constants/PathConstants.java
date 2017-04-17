package com.tm.blplayer.utils.constants;

import android.os.Environment;

import com.tm.blplayer.BLApplication;

/**
 * @author wutongming
 * @description 路径常量
 * @since 2017/4/17
 */

public class PathConstants {
    /**
     * SDCard路径
     */
    public final static String SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();

    /**
     * 缓存文件路径
     */
    public final static String CACHE = BLApplication.getContext().getCacheDir().getAbsolutePath();

    /**
     * HTTP缓存文件存储路径
     */
    public final static String CACHE_HTTP = CACHE + "/http/";

    /**
     * Glide缓存文件路径
     */
    public final static String CACHE_GLIDE = CACHE + "/glide/";

    /**
     * SDCard文件存储路径
     */
    public final static String SDCARD_BL = SDCARD + "/BLPlayer/";
}
