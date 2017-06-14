package com.tm.blplayer.bean

/**
 * @author wutongming
 * @description 数据类基类
 * @since 2017/6/14
 */
data class BaseBean<out T>(val code: Int, val message: String, val result: T)