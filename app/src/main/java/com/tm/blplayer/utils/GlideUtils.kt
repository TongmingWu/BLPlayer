package com.tm.blplayer.utils

import android.content.Context
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.tm.blplayer.R

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
        Glide.with(context)
                .load(StringUtils.filterUrl(url))
                .placeholder(R.drawable.ic_default_image)
                .centerCrop()
                .dontAnimate()
                .into(view)
    }


}
