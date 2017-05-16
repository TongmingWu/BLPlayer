package com.tm.blplayer.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class BangumiDetailData implements Parcelable {

    private String alias;
    private String allow_bp;
    private String allow_download;
    private String area;
    private int arealimit;
    private int ban_area_show;
    private String bangumi_id;
    private String bangumi_title;
    private String brief;
    private String coins;
    private String copyright;
    private String cover;
    private String danmaku_count;
    private int ed_jump;
    private String evaluate;
    private String favorites;
    private String is_finish;
    private int is_started;
    private String jp_title;
    private int limitGroupId;
    private String newest_ep_id;
    private String newest_ep_index;
    private PaymentBean payment;
    private String play_count;
    private String pub_time;
    private String season_id;
    private int season_status;
    private String season_title;
    private String share_url;
    private String squareCover;
    private String staff;
    private String title;
    private String total_count;
    private UserSeasonBean user_season;
    private String version;
    private int viewRank;
    private int vip_quality;
    private String watchingCount;
    private String weekday;
    private List<ActorBean> actor;
    private List<EpisodesBean> episodes;
    private List<RecommendBangumiBean> recommend_bangumi;
    private List<?> related_seasons;
    private List<?> seasons;
    private List<?> tag2s;
    private List<TagsBeanX> tags;

    protected BangumiDetailData(Parcel in) {
        alias = in.readString();
        allow_bp = in.readString();
        allow_download = in.readString();
        area = in.readString();
        arealimit = in.readInt();
        ban_area_show = in.readInt();
        bangumi_id = in.readString();
        bangumi_title = in.readString();
        brief = in.readString();
        coins = in.readString();
        copyright = in.readString();
        cover = in.readString();
        danmaku_count = in.readString();
        ed_jump = in.readInt();
        evaluate = in.readString();
        favorites = in.readString();
        is_finish = in.readString();
        is_started = in.readInt();
        jp_title = in.readString();
        limitGroupId = in.readInt();
        newest_ep_id = in.readString();
        newest_ep_index = in.readString();
        payment = in.readParcelable(PaymentBean.class.getClassLoader());
        play_count = in.readString();
        pub_time = in.readString();
        season_id = in.readString();
        season_status = in.readInt();
        season_title = in.readString();
        share_url = in.readString();
        squareCover = in.readString();
        staff = in.readString();
        title = in.readString();
        total_count = in.readString();
        user_season = in.readParcelable(UserSeasonBean.class.getClassLoader());
        version = in.readString();
        viewRank = in.readInt();
        vip_quality = in.readInt();
        watchingCount = in.readString();
        weekday = in.readString();
        actor = in.createTypedArrayList(ActorBean.CREATOR);
        episodes = in.createTypedArrayList(EpisodesBean.CREATOR);
        recommend_bangumi = in.createTypedArrayList(RecommendBangumiBean.CREATOR);
        tags = in.createTypedArrayList(TagsBeanX.CREATOR);
    }

    public static final Creator<BangumiDetailData> CREATOR = new Creator<BangumiDetailData>() {
        @Override
        public BangumiDetailData createFromParcel(Parcel in) {
            return new BangumiDetailData(in);
        }

        @Override
        public BangumiDetailData[] newArray(int size) {
            return new BangumiDetailData[size];
        }
    };

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAllow_bp() {
        return allow_bp;
    }

    public void setAllow_bp(String allow_bp) {
        this.allow_bp = allow_bp;
    }

    public String getAllow_download() {
        return allow_download;
    }

    public void setAllow_download(String allow_download) {
        this.allow_download = allow_download;
    }

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

    public int getBan_area_show() {
        return ban_area_show;
    }

    public void setBan_area_show(int ban_area_show) {
        this.ban_area_show = ban_area_show;
    }

    public String getBangumi_id() {
        return bangumi_id;
    }

    public void setBangumi_id(String bangumi_id) {
        this.bangumi_id = bangumi_id;
    }

    public String getBangumi_title() {
        return bangumi_title;
    }

    public void setBangumi_title(String bangumi_title) {
        this.bangumi_title = bangumi_title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDanmaku_count() {
        return danmaku_count;
    }

    public void setDanmaku_count(String danmaku_count) {
        this.danmaku_count = danmaku_count;
    }

    public int getEd_jump() {
        return ed_jump;
    }

    public void setEd_jump(int ed_jump) {
        this.ed_jump = ed_jump;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getIs_finish() {
        return is_finish;
    }

    public void setIs_finish(String is_finish) {
        this.is_finish = is_finish;
    }

    public int getIs_started() {
        return is_started;
    }

    public void setIs_started(int is_started) {
        this.is_started = is_started;
    }

    public String getJp_title() {
        return jp_title;
    }

    public void setJp_title(String jp_title) {
        this.jp_title = jp_title;
    }

    public int getLimitGroupId() {
        return limitGroupId;
    }

    public void setLimitGroupId(int limitGroupId) {
        this.limitGroupId = limitGroupId;
    }

    public String getNewest_ep_id() {
        return newest_ep_id;
    }

    public void setNewest_ep_id(String newest_ep_id) {
        this.newest_ep_id = newest_ep_id;
    }

    public String getNewest_ep_index() {
        return newest_ep_index;
    }

    public void setNewest_ep_index(String newest_ep_index) {
        this.newest_ep_index = newest_ep_index;
    }

    public PaymentBean getPayment() {
        return payment;
    }

    public void setPayment(PaymentBean payment) {
        this.payment = payment;
    }

    public String getPlay_count() {
        return play_count;
    }

    public void setPlay_count(String play_count) {
        this.play_count = play_count;
    }

    public String getPub_time() {
        return pub_time;
    }

    public void setPub_time(String pub_time) {
        this.pub_time = pub_time;
    }

    public String getSeason_id() {
        return season_id;
    }

    public void setSeason_id(String season_id) {
        this.season_id = season_id;
    }

    public int getSeason_status() {
        return season_status;
    }

    public void setSeason_status(int season_status) {
        this.season_status = season_status;
    }

    public String getSeason_title() {
        return season_title;
    }

    public void setSeason_title(String season_title) {
        this.season_title = season_title;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getSquareCover() {
        return squareCover;
    }

    public void setSquareCover(String squareCover) {
        this.squareCover = squareCover;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public UserSeasonBean getUser_season() {
        return user_season;
    }

    public void setUser_season(UserSeasonBean user_season) {
        this.user_season = user_season;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getViewRank() {
        return viewRank;
    }

    public void setViewRank(int viewRank) {
        this.viewRank = viewRank;
    }

    public int getVip_quality() {
        return vip_quality;
    }

    public void setVip_quality(int vip_quality) {
        this.vip_quality = vip_quality;
    }

    public String getWatchingCount() {
        return watchingCount;
    }

    public void setWatchingCount(String watchingCount) {
        this.watchingCount = watchingCount;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public List<ActorBean> getActor() {
        return actor;
    }

    public void setActor(List<ActorBean> actor) {
        this.actor = actor;
    }

    public List<EpisodesBean> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<EpisodesBean> episodes) {
        this.episodes = episodes;
    }

    public List<RecommendBangumiBean> getRecommend_bangumi() {
        return recommend_bangumi;
    }

    public void setRecommend_bangumi(List<RecommendBangumiBean> recommend_bangumi) {
        this.recommend_bangumi = recommend_bangumi;
    }

    public List<?> getRelated_seasons() {
        return related_seasons;
    }

    public void setRelated_seasons(List<?> related_seasons) {
        this.related_seasons = related_seasons;
    }

    public List<?> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<?> seasons) {
        this.seasons = seasons;
    }

    public List<?> getTag2s() {
        return tag2s;
    }

    public void setTag2s(List<?> tag2s) {
        this.tag2s = tag2s;
    }

    public List<TagsBeanX> getTags() {
        return tags;
    }

    public void setTags(List<TagsBeanX> tags) {
        this.tags = tags;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(alias);
        dest.writeString(allow_bp);
        dest.writeString(allow_download);
        dest.writeString(area);
        dest.writeInt(arealimit);
        dest.writeInt(ban_area_show);
        dest.writeString(bangumi_id);
        dest.writeString(bangumi_title);
        dest.writeString(brief);
        dest.writeString(coins);
        dest.writeString(copyright);
        dest.writeString(cover);
        dest.writeString(danmaku_count);
        dest.writeInt(ed_jump);
        dest.writeString(evaluate);
        dest.writeString(favorites);
        dest.writeString(is_finish);
        dest.writeInt(is_started);
        dest.writeString(jp_title);
        dest.writeInt(limitGroupId);
        dest.writeString(newest_ep_id);
        dest.writeString(newest_ep_index);
        dest.writeParcelable(payment, flags);
        dest.writeString(play_count);
        dest.writeString(pub_time);
        dest.writeString(season_id);
        dest.writeInt(season_status);
        dest.writeString(season_title);
        dest.writeString(share_url);
        dest.writeString(squareCover);
        dest.writeString(staff);
        dest.writeString(title);
        dest.writeString(total_count);
        dest.writeParcelable(user_season, flags);
        dest.writeString(version);
        dest.writeInt(viewRank);
        dest.writeInt(vip_quality);
        dest.writeString(watchingCount);
        dest.writeString(weekday);
        dest.writeTypedList(actor);
        dest.writeTypedList(episodes);
        dest.writeTypedList(recommend_bangumi);
        dest.writeTypedList(tags);
    }

    public static class PaymentBean implements Parcelable {
        /**
         * price : 0
         */

        private String price;

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.price);
        }

        public PaymentBean() {
        }

        protected PaymentBean(Parcel in) {
            this.price = in.readString();
        }

        public static final Parcelable.Creator<PaymentBean> CREATOR = new Parcelable.Creator<PaymentBean>() {
            @Override
            public PaymentBean createFromParcel(Parcel source) {
                return new PaymentBean(source);
            }

            @Override
            public PaymentBean[] newArray(int size) {
                return new PaymentBean[size];
            }
        };
    }

    public static class UserSeasonBean implements Parcelable {
        /**
         * attention : 0
         * bp : 0
         * last_ep_index :
         * last_time : 0
         * report_ts : 0
         */

        private String attention;
        private int bp;
        private String last_ep_index;
        private String last_time;
        private int report_ts;

        public String getAttention() {
            return attention;
        }

        public void setAttention(String attention) {
            this.attention = attention;
        }

        public int getBp() {
            return bp;
        }

        public void setBp(int bp) {
            this.bp = bp;
        }

        public String getLast_ep_index() {
            return last_ep_index;
        }

        public void setLast_ep_index(String last_ep_index) {
            this.last_ep_index = last_ep_index;
        }

        public String getLast_time() {
            return last_time;
        }

        public void setLast_time(String last_time) {
            this.last_time = last_time;
        }

        public int getReport_ts() {
            return report_ts;
        }

        public void setReport_ts(int report_ts) {
            this.report_ts = report_ts;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.attention);
            dest.writeInt(this.bp);
            dest.writeString(this.last_ep_index);
            dest.writeString(this.last_time);
            dest.writeInt(this.report_ts);
        }

        public UserSeasonBean() {
        }

        protected UserSeasonBean(Parcel in) {
            this.attention = in.readString();
            this.bp = in.readInt();
            this.last_ep_index = in.readString();
            this.last_time = in.readString();
            this.report_ts = in.readInt();
        }

        public static final Parcelable.Creator<UserSeasonBean> CREATOR = new Parcelable.Creator<UserSeasonBean>() {
            @Override
            public UserSeasonBean createFromParcel(Parcel source) {
                return new UserSeasonBean(source);
            }

            @Override
            public UserSeasonBean[] newArray(int size) {
                return new UserSeasonBean[size];
            }
        };
    }

    public static class ActorBean implements Parcelable {
        /**
         * actor : 松岡禎丞
         * actor_id : 0
         * role : 和泉正宗
         */

        private String actor;
        private int actor_id;
        private String role;

        public String getActor() {
            return actor;
        }

        public void setActor(String actor) {
            this.actor = actor;
        }

        public int getActor_id() {
            return actor_id;
        }

        public void setActor_id(int actor_id) {
            this.actor_id = actor_id;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.actor);
            dest.writeInt(this.actor_id);
            dest.writeString(this.role);
        }

        public ActorBean() {
        }

        protected ActorBean(Parcel in) {
            this.actor = in.readString();
            this.actor_id = in.readInt();
            this.role = in.readString();
        }

        public static final Parcelable.Creator<ActorBean> CREATOR = new Parcelable.Creator<ActorBean>() {
            @Override
            public ActorBean createFromParcel(Parcel source) {
                return new ActorBean(source);
            }

            @Override
            public ActorBean[] newArray(int size) {
                return new ActorBean[size];
            }
        };
    }

    public static class EpisodesBean implements Parcelable {
        /**
         * av_id : 9854952
         * coins : 12313
         * cover : http://i0.hdslb.com/bfs/archive/54d702893bc8e64c47c97b530a09375b625bf461.jpg
         * episode_id : 103918
         * episode_status : 2
         * index : 2
         * index_title : 现充班长与无畏妖精
         * is_new : 1
         * is_webplay : 0
         * mid : 928123
         * page : 1
         * up : {}
         * update_time : 2017-04-16 01:00:00.0
         * webplay_url : http://bangumi.bilibili.com/anime/5997/play#103918
         */

        private String av_id;
        private String coins;
        private String cover;
        private String episode_id;
        private int episode_status;
        private String index;
        private String index_title;
        private String is_new;
        private String is_webplay;
        private String mid;
        private String page;
        private String update_time;
        private String webplay_url;

        public String getAv_id() {
            return av_id;
        }

        public void setAv_id(String av_id) {
            this.av_id = av_id;
        }

        public String getCoins() {
            return coins;
        }

        public void setCoins(String coins) {
            this.coins = coins;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getEpisode_id() {
            return episode_id;
        }

        public void setEpisode_id(String episode_id) {
            this.episode_id = episode_id;
        }

        public int getEpisode_status() {
            return episode_status;
        }

        public void setEpisode_status(int episode_status) {
            this.episode_status = episode_status;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getIndex_title() {
            return index_title;
        }

        public void setIndex_title(String index_title) {
            this.index_title = index_title;
        }

        public String getIs_new() {
            return is_new;
        }

        public void setIs_new(String is_new) {
            this.is_new = is_new;
        }

        public String getIs_webplay() {
            return is_webplay;
        }

        public void setIs_webplay(String is_webplay) {
            this.is_webplay = is_webplay;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getWebplay_url() {
            return webplay_url;
        }

        public void setWebplay_url(String webplay_url) {
            this.webplay_url = webplay_url;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.av_id);
            dest.writeString(this.coins);
            dest.writeString(this.cover);
            dest.writeString(this.episode_id);
            dest.writeInt(this.episode_status);
            dest.writeString(this.index);
            dest.writeString(this.index_title);
            dest.writeString(this.is_new);
            dest.writeString(this.is_webplay);
            dest.writeString(this.mid);
            dest.writeString(this.page);
            dest.writeString(this.update_time);
            dest.writeString(this.webplay_url);
        }

        public EpisodesBean() {
        }

        protected EpisodesBean(Parcel in) {
            this.av_id = in.readString();
            this.coins = in.readString();
            this.cover = in.readString();
            this.episode_id = in.readString();
            this.episode_status = in.readInt();
            this.index = in.readString();
            this.index_title = in.readString();
            this.is_new = in.readString();
            this.is_webplay = in.readString();
            this.mid = in.readString();
            this.page = in.readString();
            this.update_time = in.readString();
            this.webplay_url = in.readString();
        }

        public static final Parcelable.Creator<EpisodesBean> CREATOR = new Parcelable.Creator<EpisodesBean>() {
            @Override
            public EpisodesBean createFromParcel(Parcel source) {
                return new EpisodesBean(source);
            }

            @Override
            public EpisodesBean[] newArray(int size) {
                return new EpisodesBean[size];
            }
        };
    }

    public static class RecommendBangumiBean implements Parcelable {
        /**
         * bangumi_id : 606
         * cover : http://i0.hdslb.com/bfs/bangumi/ece1d427f23c4167d397a77dc6e96913bf68c547.jpg
         * follow : 1067
         * isfinish : 1
         * pub_time :
         * season_id : 945
         * season_status : 2
         * tags : [{"cover":"http://i0.hdslb.com/bfs/bangumi/596fc0d465852dbda114dffc931d74c8342af3f6.jpg","tag_id":"16","tag_name":"日常"},{"cover":"http://i0.hdslb.com/bfs/bangumi/3515223f10dc3f3501a226a51d37766f77023515.jpg","tag_id":"21","tag_name":"治愈"},{"cover":"http://i0.hdslb.com/bfs/bangumi/5290ad4291feb5b9cf5f72bacb0c7d2df9569041.jpg","tag_id":"24","tag_name":"少儿"}]
         * title : 苏希的动物园
         * total_count : 10
         */

        private String bangumi_id;
        private String cover;
        private String follow;
        private String isfinish;
        private String pub_time;
        private String season_id;
        private int season_status;
        private String title;
        private String total_count;
        private List<TagsBean> tags;

        public String getBangumi_id() {
            return bangumi_id;
        }

        public void setBangumi_id(String bangumi_id) {
            this.bangumi_id = bangumi_id;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getFollow() {
            return follow;
        }

        public void setFollow(String follow) {
            this.follow = follow;
        }

        public String getIsfinish() {
            return isfinish;
        }

        public void setIsfinish(String isfinish) {
            this.isfinish = isfinish;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public String getSeason_id() {
            return season_id;
        }

        public void setSeason_id(String season_id) {
            this.season_id = season_id;
        }

        public int getSeason_status() {
            return season_status;
        }

        public void setSeason_status(int season_status) {
            this.season_status = season_status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTotal_count() {
            return total_count;
        }

        public void setTotal_count(String total_count) {
            this.total_count = total_count;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class TagsBean implements Parcelable {
            /**
             * cover : http://i0.hdslb.com/bfs/bangumi/596fc0d465852dbda114dffc931d74c8342af3f6.jpg
             * tag_id : 16
             * tag_name : 日常
             */

            private String cover;
            private String tag_id;
            private String tag_name;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getTag_id() {
                return tag_id;
            }

            public void setTag_id(String tag_id) {
                this.tag_id = tag_id;
            }

            public String getTag_name() {
                return tag_name;
            }

            public void setTag_name(String tag_name) {
                this.tag_name = tag_name;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.cover);
                dest.writeString(this.tag_id);
                dest.writeString(this.tag_name);
            }

            public TagsBean() {
            }

            protected TagsBean(Parcel in) {
                this.cover = in.readString();
                this.tag_id = in.readString();
                this.tag_name = in.readString();
            }

            public static final Parcelable.Creator<TagsBean> CREATOR = new Parcelable.Creator<TagsBean>() {
                @Override
                public TagsBean createFromParcel(Parcel source) {
                    return new TagsBean(source);
                }

                @Override
                public TagsBean[] newArray(int size) {
                    return new TagsBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.bangumi_id);
            dest.writeString(this.cover);
            dest.writeString(this.follow);
            dest.writeString(this.isfinish);
            dest.writeString(this.pub_time);
            dest.writeString(this.season_id);
            dest.writeInt(this.season_status);
            dest.writeString(this.title);
            dest.writeString(this.total_count);
            dest.writeTypedList(this.tags);
        }

        public RecommendBangumiBean() {
        }

        protected RecommendBangumiBean(Parcel in) {
            this.bangumi_id = in.readString();
            this.cover = in.readString();
            this.follow = in.readString();
            this.isfinish = in.readString();
            this.pub_time = in.readString();
            this.season_id = in.readString();
            this.season_status = in.readInt();
            this.title = in.readString();
            this.total_count = in.readString();
            this.tags = in.createTypedArrayList(TagsBean.CREATOR);
        }

        public static final Parcelable.Creator<RecommendBangumiBean> CREATOR = new Parcelable.Creator<RecommendBangumiBean>() {
            @Override
            public RecommendBangumiBean createFromParcel(Parcel source) {
                return new RecommendBangumiBean(source);
            }

            @Override
            public RecommendBangumiBean[] newArray(int size) {
                return new RecommendBangumiBean[size];
            }
        };
    }

    public static class TagsBeanX implements Parcelable {
        /**
         * cover : http://i0.hdslb.com/bfs/bangumi/0d8dc795344805ed772a9e6d7395bfea78aa9d94.png
         * tag_id : 70
         * tag_name : 搞笑
         */

        private String cover;
        private String tag_id;
        private String tag_name;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getTag_id() {
            return tag_id;
        }

        public void setTag_id(String tag_id) {
            this.tag_id = tag_id;
        }

        public String getTag_name() {
            return tag_name;
        }

        public void setTag_name(String tag_name) {
            this.tag_name = tag_name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.cover);
            dest.writeString(this.tag_id);
            dest.writeString(this.tag_name);
        }

        public TagsBeanX() {
        }

        protected TagsBeanX(Parcel in) {
            this.cover = in.readString();
            this.tag_id = in.readString();
            this.tag_name = in.readString();
        }

        public static final Creator<TagsBeanX> CREATOR = new Creator<TagsBeanX>() {
            @Override
            public TagsBeanX createFromParcel(Parcel source) {
                return new TagsBeanX(source);
            }

            @Override
            public TagsBeanX[] newArray(int size) {
                return new TagsBeanX[size];
            }
        };
    }
}
