package com.tm.blplayer.bean;

import java.io.Serializable;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class BaseBean implements Serializable {

    private static final long serialVersionUID = -298585903516636539L;

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
