package com.tm.blplayer.utils;

import java.text.SimpleDateFormat;

/**
 * @author wutongming
 * @description
 * @since 2017/5/22
 */

public class TimeUtils {

    private static final long MINUTE_TIME = 60 * 1000;
    private static final long HOUR_TIME = 60 * MINUTE_TIME;
    private static final long DAY_TIME = 24 * HOUR_TIME;
    private static final long MONTH_TIME = 30 * DAY_TIME;
    private static final long YEAR_TIME = 365 * DAY_TIME;

    /**
     * 将时间转换为分钟制 ==> 00:00
     */
    public static String formatDuration(long time) {
        StringBuilder sb = new StringBuilder();
        long minutes = time / 60;
        long second = time % 60;
        if (minutes < 1) {
            sb.append("00:").append(minutes);
        } else if (minutes < 10) {
            sb.append("0").append(minutes).append(":").append(second < 10 ? "0" + second : second);
        } else {
            sb.append(minutes).append(":").append(second < 10 ? "0" + second : second);
        }
        return sb.toString();
    }

    /**
     * 将时间与当前时间对比,得出 分钟|小时|天|月|年 的格式
     *
     * @param time 时间格式为 ==> yyyy-MM-ddTHH:mm
     */
    public static String formatStringTime(String time) {
        String result = time;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            long t = format.parse(time).getTime();
            long currentTime = System.currentTimeMillis();
            long duration = currentTime - t;
            if (duration / MINUTE_TIME < 60) {      //1小时以内
                result = duration / MINUTE_TIME + "分钟";
            } else if (duration / HOUR_TIME < 24) {  //24小时以内
                result = duration / HOUR_TIME + "小时";
            } else if (duration / DAY_TIME < 30) {    //一个月之内
                result = duration / DAY_TIME + "天";
            } else if (duration / MONTH_TIME < 12) {       //一年之内
                result = duration / MONTH_TIME + "个月";
            } else {                                 //超过一年
                result = duration / YEAR_TIME + "年";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
