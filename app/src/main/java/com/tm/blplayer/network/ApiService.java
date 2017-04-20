package com.tm.blplayer.network;

import com.tm.blplayer.bean.BangumiDetailData;
import com.tm.blplayer.bean.BangumiListData;
import com.tm.blplayer.bean.BaseBean;
import com.tm.blplayer.bean.HomeData;
import com.tm.blplayer.bean.VideoDetailData;
import com.tm.blplayer.bean.VideoListData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

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
}
