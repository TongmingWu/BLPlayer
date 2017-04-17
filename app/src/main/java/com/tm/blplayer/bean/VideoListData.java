package com.tm.blplayer.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author wutongming
 * @description 普通视频列表数据
 * @since 2017/4/17
 */

public class VideoListData implements Serializable {

    private static final long serialVersionUID = -5428500651338301225L;

    private int count;      //数据条数
    private int page;       //当前页
    private List<VideoItem> data;   //数据列表

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<VideoItem> getData() {
        return data;
    }

    public void setData(List<VideoItem> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "VideoListData{" +
                "count=" + count +
                ", page=" + page +
                ", data=" + data +
                '}';
    }
}
