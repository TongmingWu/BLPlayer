package com.tm.blplayer.network

import com.orhanobut.logger.Logger
import com.tm.blplayer.BLApplication
import com.tm.blplayer.bean.*
import com.tm.blplayer.url.PrefixUrl
import com.tm.blplayer.utils.CommonUtil
import com.tm.blplayer.utils.constants.Constants
import io.reactivex.Observable
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * @author wutongming
 * *
 * @description api管理器
 * *
 * @since 2017/4/17
 */

class ApiManager private constructor() {

    private val apiService: ApiService

    private val mRewriteCacheControlInterceptor: RewriteCacheControlInterceptor = RewriteCacheControlInterceptor()

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(PrefixUrl.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    /**
     * 初始化client
     */
    private val okHttpClient: OkHttpClient
        get() {
            val cache = Cache(File(BLApplication.instance?.cacheDir, "http"), Constants.HTTP_CACHE_SIZE.toLong())

            return OkHttpClient.Builder()
                    .cache(cache)
                    .cookieJar(BlCookiesJar())
                    .addInterceptor(mRewriteCacheControlInterceptor)
                    .addInterceptor(LogInterceptor())
                    .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                    .retryOnConnectionFailure(true)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build()
        }

    // 云端响应头拦截器，用来配置缓存策略
    private class RewriteCacheControlInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            var requestOrigin  = chain.request()
            val headersOrigin = requestOrigin.headers()
            val headers = headersOrigin.newBuilder().set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36").build()
            val request = requestOrigin.newBuilder().headers(headers).build()
            val originalResponse = chain.proceed(request)

            val context = BLApplication.instance
//            val originalResponse = chain.proceed(request)
            val build = originalResponse.newBuilder()

            context?.let {
                if (!CommonUtil.isNet(context)) {
                    requestOrigin = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build()
                }
                if (CommonUtil.isNet(context)) {
                    //有网的时候读接口上的@Headers里的配置，可以在这里进行统一的设置
                    build.header("Cache-Control", "public, max-age=" + Constants.HTTP_CACHE_STALE_SHORT).removeHeader("Pragma")
                } else {
                    build.header("Cache-Control", "public, only-if-cached, max-stale=" + Constants.HTTP_CACHE_STALE_LONG).removeHeader("Pragma")
                }
            }
            return build.build()
        }
    }

    /**
     * 日志拦截器,用于联网记录日志打印
     */
    private class LogInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            val request = chain.request()
            Logger.d("request:" + request.toString())
            val t1 = System.nanoTime()
            val response = chain.proceed(chain.request())
            val t2 = System.nanoTime()
            Logger.d(String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6, response.headers()))
            val mediaType = response.body()?.contentType()
            val content = response.body()?.string()
            Logger.d("response body:" + content)
            return response.newBuilder()
                    .body(okhttp3.ResponseBody.create(mediaType, content))
                    .build()
        }
    }

    /**
     * cookies管理器
     */
    private class BlCookiesJar : CookieJar {

        private val cookieStore = HashMap<String, List<Cookie>>()

        override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
            //可以保存cookies到本地
            Logger.d("host = " + url.host())
            cookieStore.put(url.host(), cookies)
        }

        override fun loadForRequest(url: HttpUrl): List<Cookie> {
            //可以从本地读取cookies发送
            var cookies: List<Cookie>? = cookieStore[url.host()]
            cookies = if (cookies != null) cookies else ArrayList<Cookie>()
            return cookies
        }
    }


    /**
     * 获取首页推荐数据
     */
    val homeData: Observable<BaseBean<HomeData>>
        get() = apiService.home

    /**
     * 获取视频具体信息

     * @param aid 视频id
     */
    fun getVideoDetail(aid: String): Observable<BaseBean<VideoDetailData>> {
        return apiService.getVideoDetail(aid)
    }

    /**
     * 获取国创时间表
     */
    val guochuangTimeline: Observable<BaseBean<BangumiListData>>
        get() = apiService.guochuangTimeline

    /**
     * 获取番剧时间表
     */
    val bangumiTimeline: Observable<BaseBean<BangumiListData>>
        get() = apiService.bangumiTimeline

    /**
     * 获取番剧具体信息

     * @param sid 番剧id --> season_id
     */
    fun getBangumiDetail(sid: String): Observable<BaseBean<BangumiDetailData>> {
        return apiService.getBangumiDetailData(sid)
    }

    /**
     * 搜索

     * @param word  关键字
     * *
     * @param page  当前页数
     * *
     * @param order 排列顺序
     */
    fun doSearch(word: String, page: Int, order: String): Observable<BaseBean<VideoListData>> {
        return apiService.doSearch(word, page, order)
    }

    /**
     * 获取分类表
     */
    val categoryOrder: Observable<BaseBean<CategoryListData>>
        get() = apiService.categoryOrder

    /**
     * 获取一级分类信息

     * @param firstTid 一级分类 如动画
     */
    fun getCategoryInfo(firstTid: String): Observable<BaseBean<*>> {
        return apiService.getCategoryInfo(firstTid)
    }

    /**
     * 获取一级分类信息

     * @param firstTid  一级分类 如动画
     * *
     * @param secondTid 二级分类 如MAD
     */
    fun getCategoryInfo(firstTid: String, secondTid: String): Observable<BaseBean<*>> {
        return apiService.getCategoryInfo(firstTid, secondTid)
    }

    companion object {
        fun getInstance(): ApiManager = ApiManager()
    }
}
