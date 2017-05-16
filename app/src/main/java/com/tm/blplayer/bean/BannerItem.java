package com.tm.blplayer.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author wutongming
 * @description 单个banner
 * @since 2017/4/17
 */

public class BannerItem implements Parcelable {
    /**
     * area : 0
     * id : 42363
     * name : 仰望大佬=-=~
     * pic : http://i0.hdslb.com/bfs/archive/9976b2ca07bca9bf3db4213d116faa7be35ef307.jpg
     * style : 0
     * url : http://www.bilibili.com/blackboard/activity-ryjFBnQal.html
     */

    private int area;
    private int id;
    private String name;
    private String pic;
    private int style;
    private String url;

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BannerItem{" +
                "area=" + area +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", style=" + style +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.area);
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.pic);
        dest.writeInt(this.style);
        dest.writeString(this.url);
    }

    public BannerItem() {
    }

    protected BannerItem(Parcel in) {
        this.area = in.readInt();
        this.id = in.readInt();
        this.name = in.readString();
        this.pic = in.readString();
        this.style = in.readInt();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<BannerItem> CREATOR = new Parcelable.Creator<BannerItem>() {
        @Override
        public BannerItem createFromParcel(Parcel source) {
            return new BannerItem(source);
        }

        @Override
        public BannerItem[] newArray(int size) {
            return new BannerItem[size];
        }
    };
}
