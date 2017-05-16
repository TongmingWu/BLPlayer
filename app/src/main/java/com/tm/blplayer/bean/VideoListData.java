package com.tm.blplayer.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author wutongming
 * @description 普通视频列表数据
 * @since 2017/4/17
 */

public class VideoListData implements Parcelable {

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

    public VideoListData() {
    }

    protected VideoListData(Parcel in) {
        this.count = in.readInt();
        this.page = in.readInt();
        this.data = in.createTypedArrayList(VideoItem.CREATOR);
    }

    public static final Parcelable.Creator<VideoListData> CREATOR = new Parcelable.Creator<VideoListData>() {
        @Override
        public VideoListData createFromParcel(Parcel source) {
            return new VideoListData(source);
        }

        @Override
        public VideoListData[] newArray(int size) {
            return new VideoListData[size];
        }
    };
}
