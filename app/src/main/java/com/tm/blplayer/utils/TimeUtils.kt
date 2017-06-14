package com.tm.blplayer.utils

import java.text.SimpleDateFormat

/**
 * @author wutongming
 * *
 * @description
 * *
 * @since 2017/5/22
 */

object TimeUtils {

    private val MINUTE_TIME = (60 * 1000).toLong()
    private val HOUR_TIME = 60 * MINUTE_TIME
    private val DAY_TIME = 24 * HOUR_TIME
    private val MONTH_TIME = 30 * DAY_TIME
    private val YEAR_TIME = 365 * DAY_TIME

    /**
     * 将时间转换为分钟制 ==> 00:00
     */
    fun formatDuration(time: Long): String {
        val sb = StringBuilder()
        val minutes = time / 60
        val second = time % 60
        if (minutes < 1) {
            sb.append("00:").append(minutes)
        } else if (minutes < 10) {
            sb.append("0").append(minutes).append(":").append(if (second < 10) "0" + second else second)
        } else {
            sb.append(minutes).append(":").append(if (second < 10) "0" + second else second)
        }
        return sb.toString()
    }

    /**
     * 将时间与当前时间对比,得出 分钟|小时|天|月|年 的格式

     * @param time 时间格式为 ==> yyyy-MM-ddTHH:mm
     */
    fun formatStringTime(time: String): String {
        var result = time
        try {
            val format = SimpleDateFormat("yyyy-MM-dd HH:mm")
            val t = format.parse(time).time
            val currentTime = System.currentTimeMillis()
            val duration = currentTime - t
            if (duration / MINUTE_TIME < 60) {      //1小时以内
                result = (duration / MINUTE_TIME).toString() + "分钟"
            } else if (duration / HOUR_TIME < 24) {  //24小时以内
                result = (duration / HOUR_TIME).toString() + "小时"
            } else if (duration / DAY_TIME < 30) {    //一个月之内
                result = (duration / DAY_TIME).toString() + "天"
            } else if (duration / MONTH_TIME < 12) {       //一年之内
                result = (duration / MONTH_TIME).toString() + "个月"
            } else {                                 //超过一年
                result = (duration / YEAR_TIME).toString() + "年"
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }

}
