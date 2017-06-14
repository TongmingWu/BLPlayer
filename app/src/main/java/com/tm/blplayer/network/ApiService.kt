package com.tm.blplayer.network

import com.tm.blplayer.bean.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author wutongming
 * *
 * @description Api接口
 * *
 * @since 2017/4/17
 */

interface ApiService {

    /**
     * 获取首页推荐数据
     */
    @get:GET("/api/v1/home/")
    val home: Observable<BaseBean<HomeData>>

    /**
     * 获取视频具体信息
     */
    @GET("/api/v1/video/av{aid}/")
    fun getVideoDetail(@Path("aid") aid: String): Observable<BaseBean<VideoDetailData>>

    /**
     * 获取国创时间表
     */
    @get:GET("/api/v1/guochuang")
    val guochuangTimeline: Observable<BaseBean<BangumiListData>>

    /**
     * 获取番剧时间表
     */
    @get:GET("/api/v1/bangumi")
    val bangumiTimeline: Observable<BaseBean<BangumiListData>>

    /**
     * 获取番剧具体信息
     */
    @GET("/api/v1/bangumi/{sid}/")
    fun getBangumiDetailData(@Path("sid") sid: String): Observable<BaseBean<BangumiDetailData>>

    /**
     * 视频搜索
     */
    @GET("/api/v1/search/")
    fun doSearch(@Query("word") word: String, @Query("page") page: Int, @Query("order") order: String): Observable<BaseBean<VideoListData>>

    /**
     * 分类列表
     */
    @get:GET("/api/v1/category")
    val categoryOrder: Observable<BaseBean<CategoryListData>>

    /**
     * 获取一级分类 如动画
     */
    @GET("/api/v1/category/{first_tid}")
    fun getCategoryInfo(@Path("first_tid") firstTid: String): Observable<BaseBean<*>>

    /**
     * 获取二级分类
     */
    @GET("/api/v1/category/{first_tid}/{second_tid}")
    fun getCategoryInfo(@Path("first_tid") firstTid: String, @Path("second_tid") secondTid: String): Observable<BaseBean<*>>
}
