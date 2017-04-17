package com.tm.blplayer.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class BangumiListData implements Serializable {

    private static final long serialVersionUID = -4546346189045798327L;

    private int count;

    private int page;

    private List<BangumiItem> data;

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

    public List<BangumiItem> getData() {
        return data;
    }

    public void setData(List<BangumiItem> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BangumiListData{" +
                "count=" + count +
                ", page=" + page +
                ", data=" + data +
                '}';
    }
}
