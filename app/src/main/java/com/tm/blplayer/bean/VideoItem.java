package com.tm.blplayer.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author wutongming
 * @description 视频列表中单个视频的数据
 * @since 2017/4/17
 */

public class VideoItem implements Parcelable {

    /**
     * aid : 9134548
     * attribute : 49152
     * copyright : 1
     * ctime : 1489338293
     * desc : 妖兽啦！工院教头夫夫双双走上网红主播不归路！泰语十级听力测试你能过几关？ 阿婆也走向搞事不归路。 0.5倍速食用更佳xxx
     * duration : 436
     * owner : {"face":"http://i1.hdslb.com/bfs/face/0fcd29f33e50022c25328d2c1153043b2f39e85e.jpg","mid":15061002,"name":"安怼广厦千万间"}
     * pic : http://i2.hdslb.com/bfs/archive/e39183c692479f4e02d142b9c7a8663e70cc4d37.jpg
     * pubdate : 1489350571
     * rights : {"bp":0,"download":0,"elec":0,"hd5":0,"movie":0,"no_reprint":0,"pay":0}
     * stat : {"aid":9134548,"coin":8,"danmaku":15,"favorite":18,"his_rank":0,"now_rank":0,"reply":11,"share":2,"view":722}
     * state : 0
     * tags : ["Singto","Krist","暖暖","阿日","钢炮","Arthit","Kongphop","男神为你主播","耳朵怀孕系列","搞事情"]
     * tid : 128
     * title : 【一年生】工院教头夫夫走上网红主播不归路!（结尾彩蛋）
     * tname : 电视剧相关
     */

    private String aid;
    private String attribute;
    private int copyright;
    private long ctime;
    private String desc;
    private long duration;
    private OwnerBean owner;
    private String pic;
    private long pubdate;
    private RightsBean rights;
    private StatBean stat;
    private int state;
    private int tid;
    private String title;
    private String tname;
    private List<String> tags;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public OwnerBean getOwner() {
        return owner;
    }

    public void setOwner(OwnerBean owner) {
        this.owner = owner;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public long getPubdate() {
        return pubdate;
    }

    public void setPubdate(long pubdate) {
        this.pubdate = pubdate;
    }

    public RightsBean getRights() {
        return rights;
    }

    public void setRights(RightsBean rights) {
        this.rights = rights;
    }

    public StatBean getStat() {
        return stat;
    }

    public void setStat(StatBean stat) {
        this.stat = stat;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public static class OwnerBean implements Parcelable {
        /**
         * face : http://i1.hdslb.com/bfs/face/0fcd29f33e50022c25328d2c1153043b2f39e85e.jpg
         * mid : 15061002
         * name : 安怼广厦千万间
         */

        private String face;
        private String mid;
        private String name;

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.face);
            dest.writeString(this.mid);
            dest.writeString(this.name);
        }

        public OwnerBean() {
        }

        protected OwnerBean(Parcel in) {
            this.face = in.readString();
            this.mid = in.readString();
            this.name = in.readString();
        }

        public static final Creator<OwnerBean> CREATOR = new Creator<OwnerBean>() {
            @Override
            public OwnerBean createFromParcel(Parcel source) {
                return new OwnerBean(source);
            }

            @Override
            public OwnerBean[] newArray(int size) {
                return new OwnerBean[size];
            }
        };
    }

    public static class RightsBean implements Parcelable {
        /**
         * bp : 0
         * download : 0
         * elec : 0
         * hd5 : 0
         * movie : 0
         * no_reprint : 0
         * pay : 0
         */

        private int bp;
        private int download;
        private int elec;
        private int hd5;
        private int movie;
        private int no_reprint;
        private int pay;

        public int getBp() {
            return bp;
        }

        public void setBp(int bp) {
            this.bp = bp;
        }

        public int getDownload() {
            return download;
        }

        public void setDownload(int download) {
            this.download = download;
        }

        public int getElec() {
            return elec;
        }

        public void setElec(int elec) {
            this.elec = elec;
        }

        public int getHd5() {
            return hd5;
        }

        public void setHd5(int hd5) {
            this.hd5 = hd5;
        }

        public int getMovie() {
            return movie;
        }

        public void setMovie(int movie) {
            this.movie = movie;
        }

        public int getNo_reprint() {
            return no_reprint;
        }

        public void setNo_reprint(int no_reprint) {
            this.no_reprint = no_reprint;
        }

        public int getPay() {
            return pay;
        }

        public void setPay(int pay) {
            this.pay = pay;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.bp);
            dest.writeInt(this.download);
            dest.writeInt(this.elec);
            dest.writeInt(this.hd5);
            dest.writeInt(this.movie);
            dest.writeInt(this.no_reprint);
            dest.writeInt(this.pay);
        }

        public RightsBean() {
        }

        protected RightsBean(Parcel in) {
            this.bp = in.readInt();
            this.download = in.readInt();
            this.elec = in.readInt();
            this.hd5 = in.readInt();
            this.movie = in.readInt();
            this.no_reprint = in.readInt();
            this.pay = in.readInt();
        }

        public static final Creator<RightsBean> CREATOR = new Creator<RightsBean>() {
            @Override
            public RightsBean createFromParcel(Parcel source) {
                return new RightsBean(source);
            }

            @Override
            public RightsBean[] newArray(int size) {
                return new RightsBean[size];
            }
        };
    }

    public static class StatBean implements Parcelable {
        /**
         * aid : 9134548
         * coin : 8
         * danmaku : 15
         * favorite : 18
         * his_rank : 0
         * now_rank : 0
         * reply : 11
         * share : 2
         * view : 722
         */

        private String aid;
        private String coin;
        private String danmaku;
        private String favorite;
        private int his_rank;
        private int now_rank;
        private String reply;
        private String share;
        private String view;

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

        public String getCoin() {
            return coin;
        }

        public void setCoin(String coin) {
            this.coin = coin;
        }

        public String getDanmaku() {
            return danmaku;
        }

        public void setDanmaku(String danmaku) {
            this.danmaku = danmaku;
        }

        public String getFavorite() {
            return favorite;
        }

        public void setFavorite(String favorite) {
            this.favorite = favorite;
        }

        public int getHis_rank() {
            return his_rank;
        }

        public void setHis_rank(int his_rank) {
            this.his_rank = his_rank;
        }

        public int getNow_rank() {
            return now_rank;
        }

        public void setNow_rank(int now_rank) {
            this.now_rank = now_rank;
        }

        public String getReply() {
            return reply;
        }

        public void setReply(String reply) {
            this.reply = reply;
        }

        public String getShare() {
            return share;
        }

        public void setShare(String share) {
            this.share = share;
        }

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.aid);
            dest.writeString(this.coin);
            dest.writeString(this.danmaku);
            dest.writeString(this.favorite);
            dest.writeInt(this.his_rank);
            dest.writeInt(this.now_rank);
            dest.writeString(this.reply);
            dest.writeString(this.share);
            dest.writeString(this.view);
        }

        public StatBean() {
        }

        protected StatBean(Parcel in) {
            this.aid = in.readString();
            this.coin = in.readString();
            this.danmaku = in.readString();
            this.favorite = in.readString();
            this.his_rank = in.readInt();
            this.now_rank = in.readInt();
            this.reply = in.readString();
            this.share = in.readString();
            this.view = in.readString();
        }

        public static final Creator<StatBean> CREATOR = new Creator<StatBean>() {
            @Override
            public StatBean createFromParcel(Parcel source) {
                return new StatBean(source);
            }

            @Override
            public StatBean[] newArray(int size) {
                return new StatBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.aid);
        dest.writeString(this.attribute);
        dest.writeInt(this.copyright);
        dest.writeLong(this.ctime);
        dest.writeString(this.desc);
        dest.writeLong(this.duration);
        dest.writeParcelable(this.owner, flags);
        dest.writeString(this.pic);
        dest.writeLong(this.pubdate);
        dest.writeParcelable(this.rights, flags);
        dest.writeParcelable(this.stat, flags);
        dest.writeInt(this.state);
        dest.writeInt(this.tid);
        dest.writeString(this.title);
        dest.writeString(this.tname);
        dest.writeStringList(this.tags);
    }

    public VideoItem() {
    }

    protected VideoItem(Parcel in) {
        this.aid = in.readString();
        this.attribute = in.readString();
        this.copyright = in.readInt();
        this.ctime = in.readLong();
        this.desc = in.readString();
        this.duration = in.readLong();
        this.owner = in.readParcelable(OwnerBean.class.getClassLoader());
        this.pic = in.readString();
        this.pubdate = in.readLong();
        this.rights = in.readParcelable(RightsBean.class.getClassLoader());
        this.stat = in.readParcelable(StatBean.class.getClassLoader());
        this.state = in.readInt();
        this.tid = in.readInt();
        this.title = in.readString();
        this.tname = in.readString();
        this.tags = in.createStringArrayList();
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
