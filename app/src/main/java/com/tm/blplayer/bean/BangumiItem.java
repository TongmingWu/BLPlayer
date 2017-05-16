package com.tm.blplayer.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * @author wutongming
 * @description 单个番剧简单信息
 * @since 2017/4/17
 */

public class BangumiItem implements Parcelable {

    /**
     * area : 日本
     * arealimit : 0
     * attention : 191574
     * bangumi_id : 0
     * bgmcount : 3
     * cover : http://i0.hdslb.com/bfs/bangumi/4482809518f3d0bcee7a4110b2345628f79190ac.jpg
     * danmaku_count : 11425
     * ep_id : 103411
     * favorites : 191574
     * is_finish : 0
     * lastupdate : 1492369503
     * lastupdate_at : 2017-04-17 03:05:03
     * new : true
     * play_count : 997424
     * pub_time :
     * season_id : 6011
     * season_status : 2
     * spid : 0
     * square_cover : http://i0.hdslb.com/bfs/bangumi/d799033370c6003f6e712b0c485ad6e9ca13867b.jpg
     * title : 世界黑暗图鉴
     * viewRank : 0
     * weekday : 1
     */

    private String area;
    private int arealimit;
    private int attention;
    private String badge;   //付费观看
    private int bangumi_id;
    private String bgmcount;
    private String cover;
    private int danmaku_count;
    private int ep_id;
    private int favorites;
    private int is_finish;
    private int lastupdate;
    private String lastupdate_at;
    @SerializedName("new")
    private boolean newest;
    private int play_count;
    private String pub_time;
    private int season_id;
    private int season_status;
    private int spid;
    private String square_cover;
    private String title;
    private int viewRank;
    private int weekday;    // -1 ~ 5   从星期天开始

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getArealimit() {
        return arealimit;
    }

    public void setArealimit(int arealimit) {
        this.arealimit = arealimit;
    }

    public int getAttention() {
        return attention;
    }

    public void setAttention(int attention) {
        this.attention = attention;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public int getBangumi_id() {
        return bangumi_id;
    }

    public void setBangumi_id(int bangumi_id) {
        this.bangumi_id = bangumi_id;
    }

    public String getBgmcount() {
        return bgmcount;
    }

    public void setBgmcount(String bgmcount) {
        this.bgmcount = bgmcount;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getDanmaku_count() {
        return danmaku_count;
    }

    public void setDanmaku_count(int danmaku_count) {
        this.danmaku_count = danmaku_count;
    }

    public int getEp_id() {
        return ep_id;
    }

    public void setEp_id(int ep_id) {
        this.ep_id = ep_id;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public int getIs_finish() {
        return is_finish;
    }

    public void setIs_finish(int is_finish) {
        this.is_finish = is_finish;
    }

    public int getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(int lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getLastupdate_at() {
        return lastupdate_at;
    }

    public void setLastupdate_at(String lastupdate_at) {
        this.lastupdate_at = lastupdate_at;
    }

    public boolean isNewest() {
        return newest;
    }

    public void setNewest(boolean newest) {
        this.newest = newest;
    }

    public int getPlay_count() {
        return play_count;
    }

    public void setPlay_count(int play_count) {
        this.play_count = play_count;
    }

    public String getPub_time() {
        return pub_time;
    }

    public void setPub_time(String pub_time) {
        this.pub_time = pub_time;
    }

    public int getSeason_id() {
        return season_id;
    }

    public void setSeason_id(int season_id) {
        this.season_id = season_id;
    }

    public int getSeason_status() {
        return season_status;
    }

    public void setSeason_status(int season_status) {
        this.season_status = season_status;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public String getSquare_cover() {
        return square_cover;
    }

    public void setSquare_cover(String square_cover) {
        this.square_cover = square_cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViewRank() {
        return viewRank;
    }

    public void setViewRank(int viewRank) {
        this.viewRank = viewRank;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    @Override
    public String toString() {
        return "BangumiItem{" +
                "area='" + area + '\'' +
                ", arealimit=" + arealimit +
                ", attention=" + attention +
                ", badge='" + badge + '\'' +
                ", bangumi_id=" + bangumi_id +
                ", bgmcount='" + bgmcount + '\'' +
                ", cover='" + cover + '\'' +
                ", danmaku_count=" + danmaku_count +
                ", ep_id=" + ep_id +
                ", favorites=" + favorites +
                ", is_finish=" + is_finish +
                ", lastupdate=" + lastupdate +
                ", lastupdate_at='" + lastupdate_at + '\'' +
                ", newest=" + newest +
                ", play_count=" + play_count +
                ", pub_time='" + pub_time + '\'' +
                ", season_id=" + season_id +
                ", season_status=" + season_status +
                ", spid=" + spid +
                ", square_cover='" + square_cover + '\'' +
                ", title='" + title + '\'' +
                ", viewRank=" + viewRank +
                ", weekday=" + weekday +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.area);
        dest.writeInt(this.arealimit);
        dest.writeInt(this.attention);
        dest.writeString(this.badge);
        dest.writeInt(this.bangumi_id);
        dest.writeString(this.bgmcount);
        dest.writeString(this.cover);
        dest.writeInt(this.danmaku_count);
        dest.writeInt(this.ep_id);
        dest.writeInt(this.favorites);
        dest.writeInt(this.is_finish);
        dest.writeInt(this.lastupdate);
        dest.writeString(this.lastupdate_at);
        dest.writeByte(this.newest ? (byte) 1 : (byte) 0);
        dest.writeInt(this.play_count);
        dest.writeString(this.pub_time);
        dest.writeInt(this.season_id);
        dest.writeInt(this.season_status);
        dest.writeInt(this.spid);
        dest.writeString(this.square_cover);
        dest.writeString(this.title);
        dest.writeInt(this.viewRank);
        dest.writeInt(this.weekday);
    }

    public BangumiItem() {
    }

    protected BangumiItem(Parcel in) {
        this.area = in.readString();
        this.arealimit = in.readInt();
        this.attention = in.readInt();
        this.badge = in.readString();
        this.bangumi_id = in.readInt();
        this.bgmcount = in.readString();
        this.cover = in.readString();
        this.danmaku_count = in.readInt();
        this.ep_id = in.readInt();
        this.favorites = in.readInt();
        this.is_finish = in.readInt();
        this.lastupdate = in.readInt();
        this.lastupdate_at = in.readString();
        this.newest = in.readByte() != 0;
        this.play_count = in.readInt();
        this.pub_time = in.readString();
        this.season_id = in.readInt();
        this.season_status = in.readInt();
        this.spid = in.readInt();
        this.square_cover = in.readString();
        this.title = in.readString();
        this.viewRank = in.readInt();
        this.weekday = in.readInt();
    }

    public static final Parcelable.Creator<BangumiItem> CREATOR = new Parcelable.Creator<BangumiItem>() {
        @Override
        public BangumiItem createFromParcel(Parcel source) {
            return new BangumiItem(source);
        }

        @Override
        public BangumiItem[] newArray(int size) {
            return new BangumiItem[size];
        }
    };
}
