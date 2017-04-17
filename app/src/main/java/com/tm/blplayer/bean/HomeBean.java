package com.tm.blplayer.bean;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class HomeBean extends BaseBean {

    private static final long serialVersionUID = -1367059522413542177L;

    private HomeData result;

    public HomeData getResult() {
        return result;
    }

    public void setResult(HomeData result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "HomeBean{" +
                "result=" + result +
                '}';
    }
}
