package com.tm.blplayer.bean;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class BangumiListBean extends BaseBean {

    private static final long serialVersionUID = -1929229050489249220L;

    private BangumiListData result;

    public BangumiListData getResult() {
        return result;
    }

    public void setResult(BangumiListData result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BangumiListBean{" +
                "result=" + result +
                '}';
    }
}
