package com.tm.blplayer.widget

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory
import com.bumptech.glide.module.AppGlideModule
import java.io.File

/**
 * @author wutongming
 * *
 * @Glide缓存设置
 * *
 * @since 2017/3/2
 */

class GlideCacheModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val file = File(context.externalCacheDir!!.toString() + "/image_disk_cache")
        file.mkdir()
        builder.setDiskCache(ExternalCacheDiskCacheFactory(context, file.name, DEFAULT_CACHE_CEILING))
    }

    companion object {

        val DEFAULT_CACHE_CEILING = 1024 * 1024 * 200
    }
}
