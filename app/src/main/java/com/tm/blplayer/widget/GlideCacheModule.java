package com.tm.blplayer.widget;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.module.GlideModule;

import java.io.File;

/**
 * @author wutongming
 * @Glide缓存设置
 * @since 2017/3/2
 */

public class GlideCacheModule implements GlideModule {

    public static final int DEFAULT_CACHE_CEILING = 1024 * 1024 * 200;

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        File file = new File(context.getExternalCacheDir() + "/image_disk_cache");
        file.mkdir();
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, file.getName(), DEFAULT_CACHE_CEILING));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
