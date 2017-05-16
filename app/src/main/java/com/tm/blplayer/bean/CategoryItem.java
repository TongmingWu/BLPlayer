package com.tm.blplayer.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author wutongming
 * @description
 * @since 2017/5/16
 */

public class CategoryItem implements Parcelable {

    /**
     * child : []
     * first_name : 首页
     * first_url : http://www.bilibili.com/index.html
     */

    private String first_name;
    private String first_url;
    private List<ChildBean> child;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_url() {
        return first_url;
    }

    public void setFirst_url(String first_url) {
        this.first_url = first_url;
    }

    public List<ChildBean> getChild() {
        return child;
    }

    public void setChild(List<ChildBean> child) {
        this.child = child;
    }

    public static class ChildBean implements Parcelable {
        String second_name;
        String second_url;

        public String getSecond_name() {
            return second_name;
        }

        public void setSecond_name(String second_name) {
            this.second_name = second_name;
        }

        public String getSecond_url() {
            return second_url;
        }

        public void setSecond_url(String second_url) {
            this.second_url = second_url;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.second_name);
            dest.writeString(this.second_url);
        }

        public ChildBean() {
        }

        protected ChildBean(Parcel in) {
            this.second_name = in.readString();
            this.second_url = in.readString();
        }

        public static final Parcelable.Creator<ChildBean> CREATOR = new Parcelable.Creator<ChildBean>() {
            @Override
            public ChildBean createFromParcel(Parcel source) {
                return new ChildBean(source);
            }

            @Override
            public ChildBean[] newArray(int size) {
                return new ChildBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.first_name);
        dest.writeString(this.first_url);
        dest.writeTypedList(this.child);
    }

    public CategoryItem() {
    }

    protected CategoryItem(Parcel in) {
        this.first_name = in.readString();
        this.first_url = in.readString();
        this.child = in.createTypedArrayList(ChildBean.CREATOR);
    }

    public static final Parcelable.Creator<CategoryItem> CREATOR = new Parcelable.Creator<CategoryItem>() {
        @Override
        public CategoryItem createFromParcel(Parcel source) {
            return new CategoryItem(source);
        }

        @Override
        public CategoryItem[] newArray(int size) {
            return new CategoryItem[size];
        }
    };
}
