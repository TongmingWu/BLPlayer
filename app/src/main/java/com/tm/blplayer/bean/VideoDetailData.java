package com.tm.blplayer.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class VideoDetailData implements Serializable {

    private static final long serialVersionUID = 3071341449411812551L;

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

    public static class AuthorInfoBean {
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

        public static class CardBean {
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

            public static class LevelInfoBean {
                /**
                 * current_exp : 8181
                 * current_level : 4
                 * current_min : 4500
                 * next_exp : 10800
                 */

                private int current_exp;
                private int current_level;
                private int current_min;
                private int next_exp;

                public int getCurrent_exp() {
                    return current_exp;
                }

                public void setCurrent_exp(int current_exp) {
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

                public int getNext_exp() {
                    return next_exp;
                }

                public void setNext_exp(int next_exp) {
                    this.next_exp = next_exp;
                }
            }

            public static class NameplateBean {
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
            }

            public static class OfficialVerifyBean {
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
            }

            public static class PendantBean {
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
            }

            public static class VipBean {
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
                private int vipDueDate;
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

                public int getVipDueDate() {
                    return vipDueDate;
                }

                public void setVipDueDate(int vipDueDate) {
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
            }
        }

        public static class SpaceBean {
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
        }
    }

    public static class PlayInfoBean {
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
    }

    public static class VideoInfoBean {
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
    }
}
