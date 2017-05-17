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
}
