package com.tm.blplayer.bean;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class BangumiDetailBean extends BaseBean {

    private static final long serialVersionUID = -4031661121999749140L;

    private BangumiDetailData result;

    public BangumiDetailData getResult() {
        return result;
    }

    public void setResult(BangumiDetailData result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BangumiDetailBean{" +
                "result=" + result +
                '}';
    }
}
