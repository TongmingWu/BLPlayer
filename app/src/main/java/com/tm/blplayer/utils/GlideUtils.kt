package com.tm.blplayer.utils

import android.content.Context
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tm.blplayer.R
import com.tm.blplayer.widget.GlideCircleTransform

/**
 * @author wutongming
 * *
 * @description
 * *
 * @since 2017/5/26
 */

object GlideUtils {

    /**
     * 加载网络图片
     */
    fun loadNetImage(context: Context, url: String, view: ImageView) {
        val options = RequestOptions().centerCrop()
                .dontAnimate()
                .placeholder(R.drawable.ic_default_image)
        Glide.with(context)
                .load(StringUtils.filterUrl(url))
                .apply(options)
                .into(view)
    }

    fun loadCircleImage(context: Context, url: String, view: ImageView) {
        val options = RequestOptions().centerCrop()
                .dontAnimate()
                .transform(GlideCircleTransform(context))
        Glide.with(context)
                .load(StringUtils.filterUrl(url))
                .apply(options)
                .into(view)
    }


}
