package com.tm.blplayer.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author wutongming
 * @description 分类列表
 * @since 2017/5/16
 */

public class CategoryListData implements Parcelable {

    private List<CategoryItem> data;

    public List<CategoryItem> getData() {
        return data;
    }

    public void setData(List<CategoryItem> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.data);
    }

    public CategoryListData() {
    }

    protected CategoryListData(Parcel in) {
        this.data = in.createTypedArrayList(CategoryItem.CREATOR);
    }

    public static final Parcelable.Creator<CategoryListData> CREATOR = new Parcelable.Creator<CategoryListData>() {
        @Override
        public CategoryListData createFromParcel(Parcel source) {
            return new CategoryListData(source);
        }

        @Override
        public CategoryListData[] newArray(int size) {
            return new CategoryListData[size];
        }
    };
}
