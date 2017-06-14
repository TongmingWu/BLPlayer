package com.tm.blplayer.utils

import java.text.DecimalFormat
import java.util.regex.Pattern

/**
 * Author: Tongming
 * Date: 2017/5/17
 */

object StringUtils {

    /**
     * 判断邮箱是否合法
     * @param email
     * *
     * @return
     */
    fun isEmail(email: String?): Boolean {
        if (null == email || "" == email) return false
        //Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        val p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")//复杂匹配
        val m = p.matcher(email)
        return m.matches()
    }

    /**
     * 验证手机号码
     * @param phoneNumber 手机号码
     * *
     * @return boolean
     */
    fun checkPhoneNumber(phoneNumber: String): Boolean {
        val pattern = Pattern.compile("^1[0-9]{10}$")
        val matcher = pattern.matcher(phoneNumber)
        return matcher.matches()
    }

    fun isEmpty(str: String?): Boolean {
        return str == null || str.length == 0
    }

    fun isTrimEmpty(str: String?): Boolean {
        return str == null || str.length == 0 || str.trim { it <= ' ' }.length == 0
    }

    /**
     * 是否纯数字

     * @param str
     * *
     * @return
     */
    fun isNumberSigned(str: String): Boolean {
        if (isTrimEmpty(str)) {
            return false
        } else if (str.matches("^[0-9]*$".toRegex())) {
            return true
        } else {
            return false
        }
    }

    /**
     * 取小数点后一位
     */
    fun DecimalFormat(value: Int): String {
        val format = DecimalFormat("#.0")
        var result = value.toString()
        if (value > 10000) {
            result = format.format((value / 10000.0f).toDouble())
        }
        return result
    }

    /**
     * 清洗url
     */
    fun filterUrl(url: String): String {
        var result = ""
        if (!StringUtils.isTrimEmpty(url)) {
            if (url.startsWith("http")) {
                result = url
            } else if (url.startsWith("//")) {
                result = "http:" + url
            }
        }
        return result
    }
}
