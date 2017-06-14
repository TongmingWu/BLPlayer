package com.tm.blplayer.listener

import android.view.View

/**
 * Author: Tongming
 * Date: 2017/5/17
 */

interface OnItemClickListener<T> {

    /**
     * 单击事件

     * @param view      点击的view
     * *
     * @param data     传递的数据
     * *
     * @param position 索引
     */
    fun onItemClick(view: View, data: T, position: Int)
}
