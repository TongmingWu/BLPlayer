package com.tm.blplayer.bean;

import java.io.Serializable;

/**
 * @author wutongming
 * @description 单个banner
 * @since 2017/4/17
 */

public class BannerItem implements Serializable {

    private static final long serialVersionUID = 8005307762635507902L;

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
}
