package com.tm.blplayer.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class BangumiListData implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.count);
        dest.writeInt(this.page);
        dest.writeTypedList(this.data);
    }

    public BangumiListData() {
    }

    protected BangumiListData(Parcel in) {
        this.count = in.readInt();
        this.page = in.readInt();
        this.data = in.createTypedArrayList(BangumiItem.CREATOR);
    }

    public static final Parcelable.Creator<BangumiListData> CREATOR = new Parcelable.Creator<BangumiListData>() {
        @Override
        public BangumiListData createFromParcel(Parcel source) {
            return new BangumiListData(source);
        }

        @Override
        public BangumiListData[] newArray(int size) {
            return new BangumiListData[size];
        }
    };
}
