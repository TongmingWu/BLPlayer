package com.tm.blplayer.utils;

import java.text.DecimalFormat;

/**
 * Author: Tongming
 * Date: 2017/5/17
 */

public class StringUtils {

    /**
     * 取小数点后一位
     */
    public static String DecimalFormat(float value) {
        return new DecimalFormat("#.0").format(value);
    }

    /**
     * 将时间转换为分钟制 ==> 00:00
     */
    public static String formatTime(long time) {
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
}
