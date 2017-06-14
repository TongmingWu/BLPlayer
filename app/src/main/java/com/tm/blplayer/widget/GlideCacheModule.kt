package com.tm.blplayer.widget

import android.content.Context

import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory
import com.bumptech.glide.module.GlideModule

import java.io.File

/**
 * @author wutongming
 * *
 * @Glide缓存设置
 * *
 * @since 2017/3/2
 */

class GlideCacheModule : GlideModule {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val file = File(context.externalCacheDir!!.toString() + "/image_disk_cache")
        file.mkdir()
        builder.setDiskCache(ExternalCacheDiskCacheFactory(context, file.name, DEFAULT_CACHE_CEILING))
    }

    override fun registerComponents(context: Context, glide: Glide) {

    }

    companion object {

        val DEFAULT_CACHE_CEILING = 1024 * 1024 * 200
    }
}
