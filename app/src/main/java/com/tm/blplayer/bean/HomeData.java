package com.tm.blplayer.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class HomeData implements Parcelable {

    private List<BannerItem> banner;    //banner

    private List<VideoItem> video_list = new ArrayList<>(); //视频列表

    public List<BannerItem> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerItem> banner) {
        this.banner = banner;
    }

    public List<VideoItem> getVideo_list() {
        return video_list;
    }

    public void setVideo_list(List<VideoItem> video_list) {
        this.video_list = video_list;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.banner);
        dest.writeTypedList(this.video_list);
    }

    public HomeData() {
    }

    protected HomeData(Parcel in) {
        this.banner = in.createTypedArrayList(BannerItem.CREATOR);
        this.video_list = in.createTypedArrayList(VideoItem.CREATOR);
    }

    public static final Parcelable.Creator<HomeData> CREATOR = new Parcelable.Creator<HomeData>() {
        @Override
        public HomeData createFromParcel(Parcel source) {
            return new HomeData(source);
        }

        @Override
        public HomeData[] newArray(int size) {
            return new HomeData[size];
        }
    };
}
