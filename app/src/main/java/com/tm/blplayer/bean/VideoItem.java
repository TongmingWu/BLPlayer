package com.tm.blplayer.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author wutongming
 * @description 视频列表中单个视频的数据
 * @since 2017/4/17
 */

public class VideoItem implements Parcelable {

    /**
     * aid : 9901898
     * author : 鼠粪
     * coins : 1
     * create : 2017-04-17 11:47
     * credit : 0
     * description : ytb 幼なじみのゆりやんとイケメン竜星くん。 思わせぶりな彼の仕草の数々に、キュンキュンしちゃう女子高生ゆりやんのムービー。 果たして、ゆりやんの恋は叶うのか…！？ ゆりやんのダンスシーンも必見！ キャスト：ゆりやんレトリィバァ、竜星涼　 音楽：赤い公園「恋と嘘」
     * duration : 2:26
     * favorites : 3
     * mid : 9188063
     * pic : http://i1.hdslb.com/bfs/archive/9d8605a19acfb1927851963955679d7b0ef4ca70.jpg_320x200.jpg
     * play : 36
     * pubdate : 1492400841
     * review : 0
     * subtitle :
     * title : 心动恋爱美肌movie（full version）
     * typeid : 166
     * video_review : 1
     */

    private int aid;
    private String author;
    private int coins;
    private String create;
    private int credit;
    private String description;
    private String duration;
    private int favorites;
    private int mid;
    private String pic;
    private String play;
    private String pubdate;
    private String review;
    private String subtitle;
    private String title;
    private int typeid;
    private String video_review;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getVideo_review() {
        return video_review;
    }

    public void setVideo_review(String video_review) {
        this.video_review = video_review;
    }

    @Override
    public String toString() {
        return "VideoItem{" +
                "aid=" + aid +
                ", author='" + author + '\'' +
                ", coins=" + coins +
                ", create='" + create + '\'' +
                ", credit=" + credit +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", favorites=" + favorites +
                ", mid=" + mid +
                ", pic='" + pic + '\'' +
                ", play=" + play +
                ", pubdate='" + pubdate + '\'' +
                ", review=" + review +
                ", subtitle='" + subtitle + '\'' +
                ", title='" + title + '\'' +
                ", typeid=" + typeid +
                ", video_review=" + video_review +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.aid);
        dest.writeString(this.author);
        dest.writeInt(this.coins);
        dest.writeString(this.create);
        dest.writeInt(this.credit);
        dest.writeString(this.description);
        dest.writeString(this.duration);
        dest.writeInt(this.favorites);
        dest.writeInt(this.mid);
        dest.writeString(this.pic);
        dest.writeString(this.play);
        dest.writeString(this.pubdate);
        dest.writeString(this.review);
        dest.writeString(this.subtitle);
        dest.writeString(this.title);
        dest.writeInt(this.typeid);
        dest.writeString(this.video_review);
    }

    public VideoItem() {
    }

    protected VideoItem(Parcel in) {
        this.aid = in.readInt();
        this.author = in.readString();
        this.coins = in.readInt();
        this.create = in.readString();
        this.credit = in.readInt();
        this.description = in.readString();
        this.duration = in.readString();
        this.favorites = in.readInt();
        this.mid = in.readInt();
        this.pic = in.readString();
        this.play = in.readString();
        this.pubdate = in.readString();
        this.review = in.readString();
        this.subtitle = in.readString();
        this.title = in.readString();
        this.typeid = in.readInt();
        this.video_review = in.readString();
    }

    public static final Parcelable.Creator<VideoItem> CREATOR = new Parcelable.Creator<VideoItem>() {
        @Override
        public VideoItem createFromParcel(Parcel source) {
            return new VideoItem(source);
        }

        @Override
        public VideoItem[] newArray(int size) {
            return new VideoItem[size];
        }
    };
}
