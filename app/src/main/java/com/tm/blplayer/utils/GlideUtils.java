package com.tm.blplayer.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tm.blplayer.R;

/**
 * @author wutongming
 * @description
 * @since 2017/5/26
 */

public class GlideUtils {

    /**
     * 加载网络图片
     */
    public static void loadNetImage(Context context, String url, ImageView view) {
        Glide.with(context)
                .load(filterUrl(url))
                .placeholder(R.drawable.ic_default_image)
                .centerCrop()
                .dontAnimate()
                .into(view);
    }

    /**
     * 清洗url
     */
    private static String filterUrl(String url) {
        String result = "";
        if (!StringUtils.isTrimEmpty(url)) {
            if (url.startsWith("http")) {
                result = url;
            } else if (url.startsWith("//")) {
                result = "http:" + url;
            }
        }
        return result;
    }

}