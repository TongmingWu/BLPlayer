package com.tm.blplayer.network;

import com.tm.blplayer.bean.BangumiDetailData;
import com.tm.blplayer.bean.BangumiListData;
import com.tm.blplayer.bean.BaseBean;
import com.tm.blplayer.bean.CategoryListData;
import com.tm.blplayer.bean.HomeData;
import com.tm.blplayer.bean.VideoDetailData;
import com.tm.blplayer.bean.VideoListData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author wutongming
 * @description Api接口
 * @since 2017/4/17
 */

public interface ApiService {

    /**
     * 获取首页推荐数据
     */
    @GET("/api/v1/home/")
    Observable<BaseBean<HomeData>> getHome();

    /**
     * 获取视频具体信息
     */
    @GET("/api/v1/video/av{aid}/")
    Observable<BaseBean<VideoDetailData>> getVideoDetail(@Path("aid") String aid);

    /**
     * 获取国创时间表
     */
    @GET("/api/v1/guochuang")
    Observable<BaseBean<BangumiListData>> getGuochuangTimeline();

    /**
     * 获取番剧时间表
     */
    @GET("/api/v1/bangumi")
    Observable<BaseBean<BangumiListData>> getBangumiTimeline();

    /**
     * 获取番剧具体信息
     */
    @GET("/api/v1/bangumi/{sid}/")
    Observable<BaseBean<BangumiDetailData>> getBangumiDetailData(@Path("sid") String sid);

    /**
     * 视频搜索
     */
    @GET("/api/v1/search/")
    Observable<BaseBean<VideoListData>> doSearch(@Query("word") String word, @Query("page") int page, @Query("order") String order);

    /**
     * 分类列表
     */
    @GET("/api/v1/category")
    Observable<BaseBean<CategoryListData>> getCategoryOrder();

    /**
     * 获取一级分类 如动画
     */
    @GET("/api/v1/category/{first_tid}")
    Observable<BaseBean<?>> getCategoryInfo(@Path("first_tid") String firstTid);

    /**
     * 获取二级分类
     */
    @GET("/api/v1/category/{first_tid}/{second_tid}")
    Observable<BaseBean<?>> getCategoryInfo(@Path("first_tid") String firstTid, @Path("second_tid") String secondTid);
}
