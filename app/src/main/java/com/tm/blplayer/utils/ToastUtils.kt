package com.tm.blplayer.utils

import android.content.Context
import android.widget.Toast

/**
 * @author wutongming
 * *
 * @description
 * *
 * @since 2017/5/17
 */

object ToastUtils {


    fun showToast(context: Context, text: String) {
        showShortToast(context, text)
    }

    fun showToast(context: Context, strId: Int) {
        showShortToast(context, strId)
    }

    fun showShortToast(context: Context, text: String?) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    fun showShortToast(context: Context, strId: Int) {
        showShortToast(context, context.resources.getString(strId))
    }

    fun showLongToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    fun showLongToast(context: Context, strId: Int) {
        showShortToast(context, context.resources.getString(strId))
    }

}
