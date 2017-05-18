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

public class VideoDetailData implements Parcelable {

    /**
     * author_info : {"card":{"DisplayRank":"10000","approve":false,"article":0,"attention":3,"attentions":[12041507,2013857,67291275],"birthday":"1980-01-01","description":"","face":"http://i2.hdslb.com/bfs/face/d525403f94b8cd8fb93df6b39e7b48ee1d68ae32.jpg","fans":624,"friend":3,"level_info":{"current_exp":8181,"current_level":4,"current_min":4500,"next_exp":10800},"mid":"18690261","name":"郁小离","nameplate":{"condition":"","image":"","image_small":"","level":"","name":"","nid":0},"official_verify":{"desc":"","type":-1},"pendant":{"expire":0,"image":"","name":"","pid":0},"place":"","rank":"10000","regtime":1448694212,"sex":"保密","sign":"脑洞很多，可惜人懒","spacesta":0,"vip":{"accessStatus":1,"dueRemark":"","vipDueDate":0,"vipStatus":0,"vipStatusWarn":"","vipType":0}},"space":{"l_img":"http://i2.hdslb.com/bfs/space/cb1c3ef50e22b6096fde67febe863494caefebad.png","s_img":"http://i2.hdslb.com/bfs/space/768cc4fd97618cf589d23c2711a1d1a729f42235.png"}}
     * category : 电视剧相关
     * category_url : http://www.bilibili.com/video/tv-presentation-1.html
     * cid : 13663229
     * create_time : 2017-01-30T20:43
     * desc : 阿诚哥哥新年快乐o(*￣▽￣*)ブ
     * play_info : {"coin":1447,"danmaku":257,"favorite":1630,"his_rank":0,"now_rank":0,"reply":148,"share":207,"view":16093}
     * relative_list : []
     * tag_list : ["王凯","明诚","伪装者"]
     * title : 【伪装者】【王凯明诚】残页与赞美诗
     * video_info : {"length":"168972","size":"39546940","url_list":["http://cn-fjxm-dx-v-03.acgvideo.com/vg5/6/17/13663229-1.flv?expires=1492432800&platform=pc&ssig=8PdS0it8kM_Y51nql2TVsA&oi=992621522&nfa=JegTJDC+uC6hmp9MGMEVog==&dynamic=1","http://cn-gdjm11-dx.acgvideo.com/vg3/4/c5/13663229-1.flv?expires=1492432800&platform=pc&ssig=BBifauez5TCp3I_ntolTJA&oi=992621522&nfa=JegTJDC+uC6hmp9MGMEVog==&dynamic=1","http://cn-gdjm2-dx-v-01.acgvideo.com/vg3/9/07/13663229-1.flv?expires=1492432800&platform=pc&ssig=-_35oTMQzA6B2kxevN0TPA&oi=992621522&nfa=JegTJDC+uC6hmp9MGMEVog==&dynamic=1"]}
     */

    private AuthorInfoBean author_info;
    private String category;
    private String category_url;
    private int cid;
    private String create_time;
    private String desc;
    private PlayInfoBean play_info;
    private String title;
    private VideoInfoBean video_info;
    private List<VideoItem> relative_list;
    private List<String> tag_list;

    public AuthorInfoBean getAuthor_info() {
        return author_info;
    }

    public void setAuthor_info(AuthorInfoBean author_info) {
        this.author_info = author_info;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory_url() {
        return category_url;
    }

    public void setCategory_url(String category_url) {
        this.category_url = category_url;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PlayInfoBean getPlay_info() {
        return play_info;
    }

    public void setPlay_info(PlayInfoBean play_info) {
        this.play_info = play_info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public VideoInfoBean getVideo_info() {
        return video_info;
    }

    public void setVideo_info(VideoInfoBean video_info) {
        this.video_info = video_info;
    }

    public List<VideoItem> getRelative_list() {
        return relative_list;
    }

    public void setRelative_list(List<VideoItem> relative_list) {
        this.relative_list = relative_list;
    }

    public List<String> getTag_list() {
        return tag_list;
    }

    public void setTag_list(List<String> tag_list) {
        this.tag_list = tag_list;
    }

    public static class AuthorInfoBean implements Parcelable {
        /**
         * card : {"DisplayRank":"10000","approve":false,"article":0,"attention":3,"attentions":[12041507,2013857,67291275],"birthday":"1980-01-01","description":"","face":"http://i2.hdslb.com/bfs/face/d525403f94b8cd8fb93df6b39e7b48ee1d68ae32.jpg","fans":624,"friend":3,"level_info":{"current_exp":8181,"current_level":4,"current_min":4500,"next_exp":10800},"mid":"18690261","name":"郁小离","nameplate":{"condition":"","image":"","image_small":"","level":"","name":"","nid":0},"official_verify":{"desc":"","type":-1},"pendant":{"expire":0,"image":"","name":"","pid":0},"place":"","rank":"10000","regtime":1448694212,"sex":"保密","sign":"脑洞很多，可惜人懒","spacesta":0,"vip":{"accessStatus":1,"dueRemark":"","vipDueDate":0,"vipStatus":0,"vipStatusWarn":"","vipType":0}}
         * space : {"l_img":"http://i2.hdslb.com/bfs/space/cb1c3ef50e22b6096fde67febe863494caefebad.png","s_img":"http://i2.hdslb.com/bfs/space/768cc4fd97618cf589d23c2711a1d1a729f42235.png"}
         */

        private CardBean card;
        private SpaceBean space;

        public CardBean getCard() {
            return card;
        }

        public void setCard(CardBean card) {
            this.card = card;
        }

        public SpaceBean getSpace() {
            return space;
        }

        public void setSpace(SpaceBean space) {
            this.space = space;
        }

        public static class CardBean implements Parcelable {
            /**
             * DisplayRank : 10000
             * approve : false
             * article : 0
             * attention : 3
             * attentions : [12041507,2013857,67291275]
             * birthday : 1980-01-01
             * description :
             * face : http://i2.hdslb.com/bfs/face/d525403f94b8cd8fb93df6b39e7b48ee1d68ae32.jpg
             * fans : 624
             * friend : 3
             * level_info : {"current_exp":8181,"current_level":4,"current_min":4500,"next_exp":10800}
             * mid : 18690261
             * name : 郁小离
             * nameplate : {"condition":"","image":"","image_small":"","level":"","name":"","nid":0}
             * official_verify : {"desc":"","type":-1}
             * pendant : {"expire":0,"image":"","name":"","pid":0}
             * place :
             * rank : 10000
             * regtime : 1448694212
             * sex : 保密
             * sign : 脑洞很多，可惜人懒
             * spacesta : 0
             * vip : {"accessStatus":1,"dueRemark":"","vipDueDate":0,"vipStatus":0,"vipStatusWarn":"","vipType":0}
             */

            private String DisplayRank;
            private boolean approve;
            private int article;
            private int attention;
            private String birthday;
            private String description;
            private String face;
            private int fans;
            private int friend;
            private LevelInfoBean level_info;
            private String mid;
            private String name;
            private NameplateBean nameplate;
            private OfficialVerifyBean official_verify;
            private PendantBean pendant;
            private String place;
            private String rank;
            private int regtime;
            private String sex;
            private String sign;
            private int spacesta;
            private VipBean vip;
            private List<Integer> attentions;

            public String getDisplayRank() {
                return DisplayRank;
            }

            public void setDisplayRank(String DisplayRank) {
                this.DisplayRank = DisplayRank;
            }

            public boolean isApprove() {
                return approve;
            }

            public void setApprove(boolean approve) {
                this.approve = approve;
            }

            public int getArticle() {
                return article;
            }

            public void setArticle(int article) {
                this.article = article;
            }

            public int getAttention() {
                return attention;
            }

            public void setAttention(int attention) {
                this.attention = attention;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public int getFans() {
                return fans;
            }

            public void setFans(int fans) {
                this.fans = fans;
            }

            public int getFriend() {
                return friend;
            }

            public void setFriend(int friend) {
                this.friend = friend;
            }

            public LevelInfoBean getLevel_info() {
                return level_info;
            }

            public void setLevel_info(LevelInfoBean level_info) {
                this.level_info = level_info;
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

            public NameplateBean getNameplate() {
                return nameplate;
            }

            public void setNameplate(NameplateBean nameplate) {
                this.nameplate = nameplate;
            }

            public OfficialVerifyBean getOfficial_verify() {
                return official_verify;
            }

            public void setOfficial_verify(OfficialVerifyBean official_verify) {
                this.official_verify = official_verify;
            }

            public PendantBean getPendant() {
                return pendant;
            }

            public void setPendant(PendantBean pendant) {
                this.pendant = pendant;
            }

            public String getPlace() {
                return place;
            }

            public void setPlace(String place) {
                this.place = place;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public int getRegtime() {
                return regtime;
            }

            public void setRegtime(int regtime) {
                this.regtime = regtime;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public int getSpacesta() {
                return spacesta;
            }

            public void setSpacesta(int spacesta) {
                this.spacesta = spacesta;
            }

            public VipBean getVip() {
                return vip;
            }

            public void setVip(VipBean vip) {
                this.vip = vip;
            }

            public List<Integer> getAttentions() {
                return attentions;
            }

            public void setAttentions(List<Integer> attentions) {
                this.attentions = attentions;
            }

            public static class LevelInfoBean implements Parcelable {
                /**
                 * current_exp : 8181
                 * current_level : 4
                 * current_min : 4500
                 * next_exp : 10800
                 */

                private String current_exp;
                private int current_level;
                private int current_min;
                private String next_exp;

                public String getCurrent_exp() {
                    return current_exp;
                }

                public void setCurrent_exp(String current_exp) {
                    this.current_exp = current_exp;
                }

                public int getCurrent_level() {
                    return current_level;
                }

                public void setCurrent_level(int current_level) {
                    this.current_level = current_level;
                }

                public int getCurrent_min() {
                    return current_min;
                }

                public void setCurrent_min(int current_min) {
                    this.current_min = current_min;
                }

                public String getNext_exp() {
                    return next_exp;
                }

                public void setNext_exp(String next_exp) {
                    this.next_exp = next_exp;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.current_exp);
                    dest.writeInt(this.current_level);
                    dest.writeInt(this.current_min);
                    dest.writeString(this.next_exp);
                }

                public LevelInfoBean() {
                }

                protected LevelInfoBean(Parcel in) {
                    this.current_exp = in.readString();
                    this.current_level = in.readInt();
                    this.current_min = in.readInt();
                    this.next_exp = in.readString();
                }

                public static final Parcelable.Creator<LevelInfoBean> CREATOR = new Parcelable.Creator<LevelInfoBean>() {
                    @Override
                    public LevelInfoBean createFromParcel(Parcel source) {
                        return new LevelInfoBean(source);
                    }

                    @Override
                    public LevelInfoBean[] newArray(int size) {
                        return new LevelInfoBean[size];
                    }
                };
            }

            public static class NameplateBean implements Parcelable {
                /**
                 * condition :
                 * image :
                 * image_small :
                 * level :
                 * name :
                 * nid : 0
                 */

                private String condition;
                private String image;
                private String image_small;
                private String level;
                private String name;
                private int nid;

                public String getCondition() {
                    return condition;
                }

                public void setCondition(String condition) {
                    this.condition = condition;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getImage_small() {
                    return image_small;
                }

                public void setImage_small(String image_small) {
                    this.image_small = image_small;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getNid() {
                    return nid;
                }

                public void setNid(int nid) {
                    this.nid = nid;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.condition);
                    dest.writeString(this.image);
                    dest.writeString(this.image_small);
                    dest.writeString(this.level);
                    dest.writeString(this.name);
                    dest.writeInt(this.nid);
                }

                public NameplateBean() {
                }

                protected NameplateBean(Parcel in) {
                    this.condition = in.readString();
                    this.image = in.readString();
                    this.image_small = in.readString();
                    this.level = in.readString();
                    this.name = in.readString();
                    this.nid = in.readInt();
                }

                public static final Parcelable.Creator<NameplateBean> CREATOR = new Parcelable.Creator<NameplateBean>() {
                    @Override
                    public NameplateBean createFromParcel(Parcel source) {
                        return new NameplateBean(source);
                    }

                    @Override
                    public NameplateBean[] newArray(int size) {
                        return new NameplateBean[size];
                    }
                };
            }

            public static class OfficialVerifyBean implements Parcelable {
                /**
                 * desc :
                 * type : -1
                 */

                private String desc;
                private int type;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.desc);
                    dest.writeInt(this.type);
                }

                public OfficialVerifyBean() {
                }

                protected OfficialVerifyBean(Parcel in) {
                    this.desc = in.readString();
                    this.type = in.readInt();
                }

                public static final Parcelable.Creator<OfficialVerifyBean> CREATOR = new Parcelable.Creator<OfficialVerifyBean>() {
                    @Override
                    public OfficialVerifyBean createFromParcel(Parcel source) {
                        return new OfficialVerifyBean(source);
                    }

                    @Override
                    public OfficialVerifyBean[] newArray(int size) {
                        return new OfficialVerifyBean[size];
                    }
                };
            }

            public static class PendantBean implements Parcelable {
                /**
                 * expire : 0
                 * image :
                 * name :
                 * pid : 0
                 */

                private int expire;
                private String image;
                private String name;
                private int pid;

                public int getExpire() {
                    return expire;
                }

                public void setExpire(int expire) {
                    this.expire = expire;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.expire);
                    dest.writeString(this.image);
                    dest.writeString(this.name);
                    dest.writeInt(this.pid);
                }

                public PendantBean() {
                }

                protected PendantBean(Parcel in) {
                    this.expire = in.readInt();
                    this.image = in.readString();
                    this.name = in.readString();
                    this.pid = in.readInt();
                }

                public static final Parcelable.Creator<PendantBean> CREATOR = new Parcelable.Creator<PendantBean>() {
                    @Override
                    public PendantBean createFromParcel(Parcel source) {
                        return new PendantBean(source);
                    }

                    @Override
                    public PendantBean[] newArray(int size) {
                        return new PendantBean[size];
                    }
                };
            }

            public static class VipBean implements Parcelable {
                /**
                 * accessStatus : 1
                 * dueRemark :
                 * vipDueDate : 0
                 * vipStatus : 0
                 * vipStatusWarn :
                 * vipType : 0
                 */

                private int accessStatus;
                private String dueRemark;
                private long vipDueDate;
                private int vipStatus;
                private String vipStatusWarn;
                private int vipType;

                public int getAccessStatus() {
                    return accessStatus;
                }

                public void setAccessStatus(int accessStatus) {
                    this.accessStatus = accessStatus;
                }

                public String getDueRemark() {
                    return dueRemark;
                }

                public void setDueRemark(String dueRemark) {
                    this.dueRemark = dueRemark;
                }

                public long getVipDueDate() {
                    return vipDueDate;
                }

                public void setVipDueDate(long vipDueDate) {
                    this.vipDueDate = vipDueDate;
                }

                public int getVipStatus() {
                    return vipStatus;
                }

                public void setVipStatus(int vipStatus) {
                    this.vipStatus = vipStatus;
                }

                public String getVipStatusWarn() {
                    return vipStatusWarn;
                }

                public void setVipStatusWarn(String vipStatusWarn) {
                    this.vipStatusWarn = vipStatusWarn;
                }

                public int getVipType() {
                    return vipType;
                }

                public void setVipType(int vipType) {
                    this.vipType = vipType;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.accessStatus);
                    dest.writeString(this.dueRemark);
                    dest.writeLong(this.vipDueDate);
                    dest.writeInt(this.vipStatus);
                    dest.writeString(this.vipStatusWarn);
                    dest.writeInt(this.vipType);
                }

                public VipBean() {
                }

                protected VipBean(Parcel in) {
                    this.accessStatus = in.readInt();
                    this.dueRemark = in.readString();
                    this.vipDueDate = in.readLong();
                    this.vipStatus = in.readInt();
                    this.vipStatusWarn = in.readString();
                    this.vipType = in.readInt();
                }

                public static final Parcelable.Creator<VipBean> CREATOR = new Parcelable.Creator<VipBean>() {
                    @Override
                    public VipBean createFromParcel(Parcel source) {
                        return new VipBean(source);
                    }

                    @Override
                    public VipBean[] newArray(int size) {
                        return new VipBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.DisplayRank);
                dest.writeByte(this.approve ? (byte) 1 : (byte) 0);
                dest.writeInt(this.article);
                dest.writeInt(this.attention);
                dest.writeString(this.birthday);
                dest.writeString(this.description);
                dest.writeString(this.face);
                dest.writeInt(this.fans);
                dest.writeInt(this.friend);
                dest.writeParcelable(this.level_info, flags);
                dest.writeString(this.mid);
                dest.writeString(this.name);
                dest.writeParcelable(this.nameplate, flags);
                dest.writeParcelable(this.official_verify, flags);
                dest.writeParcelable(this.pendant, flags);
                dest.writeString(this.place);
                dest.writeString(this.rank);
                dest.writeInt(this.regtime);
                dest.writeString(this.sex);
                dest.writeString(this.sign);
                dest.writeInt(this.spacesta);
                dest.writeParcelable(this.vip, flags);
                dest.writeList(this.attentions);
            }

            public CardBean() {
            }

            protected CardBean(Parcel in) {
                this.DisplayRank = in.readString();
                this.approve = in.readByte() != 0;
                this.article = in.readInt();
                this.attention = in.readInt();
                this.birthday = in.readString();
                this.description = in.readString();
                this.face = in.readString();
                this.fans = in.readInt();
                this.friend = in.readInt();
                this.level_info = in.readParcelable(LevelInfoBean.class.getClassLoader());
                this.mid = in.readString();
                this.name = in.readString();
                this.nameplate = in.readParcelable(NameplateBean.class.getClassLoader());
                this.official_verify = in.readParcelable(OfficialVerifyBean.class.getClassLoader());
                this.pendant = in.readParcelable(PendantBean.class.getClassLoader());
                this.place = in.readString();
                this.rank = in.readString();
                this.regtime = in.readInt();
                this.sex = in.readString();
                this.sign = in.readString();
                this.spacesta = in.readInt();
                this.vip = in.readParcelable(VipBean.class.getClassLoader());
                this.attentions = new ArrayList<Integer>();
                in.readList(this.attentions, Integer.class.getClassLoader());
            }

            public static final Parcelable.Creator<CardBean> CREATOR = new Parcelable.Creator<CardBean>() {
                @Override
                public CardBean createFromParcel(Parcel source) {
                    return new CardBean(source);
                }

                @Override
                public CardBean[] newArray(int size) {
                    return new CardBean[size];
                }
            };
        }

        public static class SpaceBean implements Parcelable {
            /**
             * l_img : http://i2.hdslb.com/bfs/space/cb1c3ef50e22b6096fde67febe863494caefebad.png
             * s_img : http://i2.hdslb.com/bfs/space/768cc4fd97618cf589d23c2711a1d1a729f42235.png
             */

            private String l_img;
            private String s_img;

            public String getL_img() {
                return l_img;
            }

            public void setL_img(String l_img) {
                this.l_img = l_img;
            }

            public String getS_img() {
                return s_img;
            }

            public void setS_img(String s_img) {
                this.s_img = s_img;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.l_img);
                dest.writeString(this.s_img);
            }

            public SpaceBean() {
            }

            protected SpaceBean(Parcel in) {
                this.l_img = in.readString();
                this.s_img = in.readString();
            }

            public static final Parcelable.Creator<SpaceBean> CREATOR = new Parcelable.Creator<SpaceBean>() {
                @Override
                public SpaceBean createFromParcel(Parcel source) {
                    return new SpaceBean(source);
                }

                @Override
                public SpaceBean[] newArray(int size) {
                    return new SpaceBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.card, flags);
            dest.writeParcelable(this.space, flags);
        }

        public AuthorInfoBean() {
        }

        protected AuthorInfoBean(Parcel in) {
            this.card = in.readParcelable(CardBean.class.getClassLoader());
            this.space = in.readParcelable(SpaceBean.class.getClassLoader());
        }

        public static final Parcelable.Creator<AuthorInfoBean> CREATOR = new Parcelable.Creator<AuthorInfoBean>() {
            @Override
            public AuthorInfoBean createFromParcel(Parcel source) {
                return new AuthorInfoBean(source);
            }

            @Override
            public AuthorInfoBean[] newArray(int size) {
                return new AuthorInfoBean[size];
            }
        };
    }

    public static class PlayInfoBean implements Parcelable {
        /**
         * coin : 1447
         * danmaku : 257
         * favorite : 1630
         * his_rank : 0
         * now_rank : 0
         * reply : 148
         * share : 207
         * view : 16093
         */

        private int coin;
        private int danmaku;
        private int favorite;
        private int his_rank;
        private int now_rank;
        private int reply;
        private int share;
        private int view;

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public int getDanmaku() {
            return danmaku;
        }

        public void setDanmaku(int danmaku) {
            this.danmaku = danmaku;
        }

        public int getFavorite() {
            return favorite;
        }

        public void setFavorite(int favorite) {
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

        public int getReply() {
            return reply;
        }

        public void setReply(int reply) {
            this.reply = reply;
        }

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public int getView() {
            return view;
        }

        public void setView(int view) {
            this.view = view;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.coin);
            dest.writeInt(this.danmaku);
            dest.writeInt(this.favorite);
            dest.writeInt(this.his_rank);
            dest.writeInt(this.now_rank);
            dest.writeInt(this.reply);
            dest.writeInt(this.share);
            dest.writeInt(this.view);
        }

        public PlayInfoBean() {
        }

        protected PlayInfoBean(Parcel in) {
            this.coin = in.readInt();
            this.danmaku = in.readInt();
            this.favorite = in.readInt();
            this.his_rank = in.readInt();
            this.now_rank = in.readInt();
            this.reply = in.readInt();
            this.share = in.readInt();
            this.view = in.readInt();
        }

        public static final Parcelable.Creator<PlayInfoBean> CREATOR = new Parcelable.Creator<PlayInfoBean>() {
            @Override
            public PlayInfoBean createFromParcel(Parcel source) {
                return new PlayInfoBean(source);
            }

            @Override
            public PlayInfoBean[] newArray(int size) {
                return new PlayInfoBean[size];
            }
        };
    }

    /**
     * 视频真正url和大小
     */
    public static class VideoInfoBean implements Parcelable {
        /**
         * length : 168972
         * size : 39546940
         * url_list : ["http://cn-fjxm-dx-v-03.acgvideo.com/vg5/6/17/13663229-1.flv?expires=1492432800&platform=pc&ssig=8PdS0it8kM_Y51nql2TVsA&oi=992621522&nfa=JegTJDC+uC6hmp9MGMEVog==&dynamic=1","http://cn-gdjm11-dx.acgvideo.com/vg3/4/c5/13663229-1.flv?expires=1492432800&platform=pc&ssig=BBifauez5TCp3I_ntolTJA&oi=992621522&nfa=JegTJDC+uC6hmp9MGMEVog==&dynamic=1","http://cn-gdjm2-dx-v-01.acgvideo.com/vg3/9/07/13663229-1.flv?expires=1492432800&platform=pc&ssig=-_35oTMQzA6B2kxevN0TPA&oi=992621522&nfa=JegTJDC+uC6hmp9MGMEVog==&dynamic=1"]
         */

        private String length;
        private String size;
        private List<String> url_list;

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public List<String> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<String> url_list) {
            this.url_list = url_list;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.length);
            dest.writeString(this.size);
            dest.writeStringList(this.url_list);
        }

        public VideoInfoBean() {
        }

        protected VideoInfoBean(Parcel in) {
            this.length = in.readString();
            this.size = in.readString();
            this.url_list = in.createStringArrayList();
        }

        public static final Parcelable.Creator<VideoInfoBean> CREATOR = new Parcelable.Creator<VideoInfoBean>() {
            @Override
            public VideoInfoBean createFromParcel(Parcel source) {
                return new VideoInfoBean(source);
            }

            @Override
            public VideoInfoBean[] newArray(int size) {
                return new VideoInfoBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.author_info, flags);
        dest.writeString(this.category);
        dest.writeString(this.category_url);
        dest.writeInt(this.cid);
        dest.writeString(this.create_time);
        dest.writeString(this.desc);
        dest.writeParcelable(this.play_info, flags);
        dest.writeString(this.title);
        dest.writeParcelable(this.video_info, flags);
        dest.writeList(this.relative_list);
        dest.writeStringList(this.tag_list);
    }

    public VideoDetailData() {
    }

    protected VideoDetailData(Parcel in) {
        this.author_info = in.readParcelable(AuthorInfoBean.class.getClassLoader());
        this.category = in.readString();
        this.category_url = in.readString();
        this.cid = in.readInt();
        this.create_time = in.readString();
        this.desc = in.readString();
        this.play_info = in.readParcelable(PlayInfoBean.class.getClassLoader());
        this.title = in.readString();
        this.video_info = in.readParcelable(VideoInfoBean.class.getClassLoader());
        this.relative_list = new ArrayList<VideoItem>();
        in.readList(this.relative_list, VideoItem.class.getClassLoader());
        this.tag_list = in.createStringArrayList();
    }

    public static final Parcelable.Creator<VideoDetailData> CREATOR = new Parcelable.Creator<VideoDetailData>() {
        @Override
        public VideoDetailData createFromParcel(Parcel source) {
            return new VideoDetailData(source);
        }

        @Override
        public VideoDetailData[] newArray(int size) {
            return new VideoDetailData[size];
        }
    };
}
