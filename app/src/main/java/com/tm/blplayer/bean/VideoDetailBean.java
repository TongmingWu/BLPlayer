package com.tm.blplayer.bean;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class VideoDetailBean extends BaseBean {

    private static final long serialVersionUID = -2752222297624372747L;

    private VideoDetailData result;

    public VideoDetailData getResult() {
        return result;
    }

    public void setResult(VideoDetailData result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "VideoDetailBean{" +
                "result=" + result +
                '}';
    }
}
