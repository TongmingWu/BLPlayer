package com.tm.blplayer.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class HomeData implements Serializable {

    private static final long serialVersionUID = -390743897199718293L;

    private List<BannerItem> banner;    //banner

    private List<VideoItem> ad;         //广告

    private List<VideoItem> bangumi;    //番剧

    private List<VideoItem> dance;      //舞蹈

    private List<VideoItem> douga;      //动画

    private List<VideoItem> ent;        //娱乐

    private List<VideoItem> fashion;    //娱乐

    private List<VideoItem> game;       //游戏

    private List<VideoItem> guochuang;  //国创

    private List<VideoItem> kichiku;    //鬼畜

    private List<VideoItem> life;       //生活

    private List<VideoItem> movie;      //电影

    private List<VideoItem> music;      //音乐

    private List<VideoItem> technology; //科技

    private List<VideoItem> teleplay;   //电视剧

    public List<BannerItem> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerItem> banner) {
        this.banner = banner;
    }

    public List<VideoItem> getAd() {
        return ad;
    }

    public void setAd(List<VideoItem> ad) {
        this.ad = ad;
    }

    public List<VideoItem> getBangumi() {
        return bangumi;
    }

    public void setBangumi(List<VideoItem> bangumi) {
        this.bangumi = bangumi;
    }

    public List<VideoItem> getDance() {
        return dance;
    }

    public void setDance(List<VideoItem> dance) {
        this.dance = dance;
    }

    public List<VideoItem> getDouga() {
        return douga;
    }

    public void setDouga(List<VideoItem> douga) {
        this.douga = douga;
    }

    public List<VideoItem> getEnt() {
        return ent;
    }

    public void setEnt(List<VideoItem> ent) {
        this.ent = ent;
    }

    public List<VideoItem> getFashion() {
        return fashion;
    }

    public void setFashion(List<VideoItem> fashion) {
        this.fashion = fashion;
    }

    public List<VideoItem> getGame() {
        return game;
    }

    public void setGame(List<VideoItem> game) {
        this.game = game;
    }

    public List<VideoItem> getGuochuang() {
        return guochuang;
    }

    public void setGuochuang(List<VideoItem> guochuang) {
        this.guochuang = guochuang;
    }

    public List<VideoItem> getKichiku() {
        return kichiku;
    }

    public void setKichiku(List<VideoItem> kichiku) {
        this.kichiku = kichiku;
    }

    public List<VideoItem> getLife() {
        return life;
    }

    public void setLife(List<VideoItem> life) {
        this.life = life;
    }

    public List<VideoItem> getMovie() {
        return movie;
    }

    public void setMovie(List<VideoItem> movie) {
        this.movie = movie;
    }

    public List<VideoItem> getMusic() {
        return music;
    }

    public void setMusic(List<VideoItem> music) {
        this.music = music;
    }

    public List<VideoItem> getTechnology() {
        return technology;
    }

    public void setTechnology(List<VideoItem> technology) {
        this.technology = technology;
    }

    public List<VideoItem> getTeleplay() {
        return teleplay;
    }

    public void setTeleplay(List<VideoItem> teleplay) {
        this.teleplay = teleplay;
    }

    @Override
    public String toString() {
        return "HomeData{" +
                "banner=" + banner +
                ", ad=" + ad +
                ", bangumi=" + bangumi +
                ", dance=" + dance +
                ", douga=" + douga +
                ", ent=" + ent +
                ", fashion=" + fashion +
                ", game=" + game +
                ", guochuang=" + guochuang +
                ", kichiku=" + kichiku +
                ", life=" + life +
                ", movie=" + movie +
                ", music=" + music +
                ", technology=" + technology +
                ", teleplay=" + teleplay +
                '}';
    }
}
