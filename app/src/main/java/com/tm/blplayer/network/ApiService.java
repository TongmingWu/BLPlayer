package com.tm.blplayer.network;

import com.tm.blplayer.bean.BangumiDetailBean;
import com.tm.blplayer.bean.BangumiListBean;
import com.tm.blplayer.bean.HomeBean;
import com.tm.blplayer.bean.VideoDetailBean;
import com.tm.blplayer.bean.VideoListBean;

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
    Observable<HomeBean> getHome();

    /**
     * 获取视频具体信息
     */
    @GET("/api/v1/video/av{aid}/")
    Observable<VideoDetailBean> getVideoDetail(@Path("aid") String aid);

    /**
     * 获取国创时间表
     */
    @GET("/api/v1/guochuang")
    Observable<BangumiListBean> getGuochuangTimeline();

    /**
     * 获取番剧时间表
     */
    @GET("/api/v1/bangumi")
    Observable<BangumiListBean> getBangumiTimeline();

    /**
     * 获取番剧具体信息
     */
    @GET("/api/v1/bangumi/{sid}/")
    Observable<BangumiDetailBean> getBangumiDetailData(@Path("sid") String sid);

    /**
     * 视频搜索
     */
    @GET("/api/v1/search/")
    Observable<VideoListBean> doSearch(@Query("word") String word, @Query("page") int page, @Query("order") String order);
}
