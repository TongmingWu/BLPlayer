package com.tm.blplayer.bean;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class VideoListBean extends BaseBean {

    private static final long serialVersionUID = -8170504520718724218L;

    private VideoListData result;

    public VideoListData getResult() {
        return result;
    }

    public void setResult(VideoListData result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "VideoListBean{" +
                "result=" + result +
                '}';
    }
}
