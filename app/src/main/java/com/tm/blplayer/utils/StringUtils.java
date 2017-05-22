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
    public static String DecimalFormat(int value) {
        DecimalFormat format = new DecimalFormat("#.0");
        String result = String.valueOf(value);
        if (value > 10000) {
            result = format.format(value / 10000.0f);
        }
        return result;
    }
}
