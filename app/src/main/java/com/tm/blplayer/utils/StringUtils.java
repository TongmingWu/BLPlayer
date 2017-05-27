package com.tm.blplayer.utils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Tongming
 * Date: 2017/5/17
 */

public class StringUtils {

    /**
     * 判断邮箱是否合法
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
        if (null==email || "".equals(email)) return false;
        //Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 验证手机号码
     * @param phoneNumber 手机号码
     * @return boolean
     */
    public static boolean checkPhoneNumber(String phoneNumber){
        Pattern pattern=Pattern.compile("^1[0-9]{10}$");
        Matcher matcher=pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    public static boolean isTrimEmpty(String str) {
        return (str == null || str.length() == 0 || str.trim().length() == 0);
    }

    /**
     * 是否纯数字
     *
     * @param str
     * @return
     */
    public static boolean isNumberSigned(String str) {
        if (isTrimEmpty(str)) {
            return false;
        } else if (str.matches("^[0-9]*$")) {
            return true;
        } else {
            return false;
        }
    }

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

    /**
     * 清洗url
     */
    public static String filterUrl(String url) {
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
