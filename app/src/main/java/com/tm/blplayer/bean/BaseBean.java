package com.tm.blplayer.bean;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class BaseBean<T> {

    private int code;
    private String message;
    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

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
