package com.tm.blplayer.network;

import android.content.Context;

import com.tm.blplayer.BLApplication;
import com.tm.blplayer.bean.BangumiDetailBean;
import com.tm.blplayer.bean.BangumiListBean;
import com.tm.blplayer.bean.HomeBean;
import com.tm.blplayer.bean.VideoDetailBean;
import com.tm.blplayer.bean.VideoListBean;
import com.tm.blplayer.url.PrefixUrl;
import com.tm.blplayer.utils.CommonUtil;
import com.tm.blplayer.utils.constants.Constants;
import com.tm.blplayer.utils.constants.PathConstants;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class ApiManager {

    private static volatile ApiManager instance;

    private OkHttpClient mOkHttpClient;
    private final ApiService apiService;

    private ApiManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PrefixUrl.BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static ApiManager getInstance() {
        if (instance == null) {
            synchronized (ApiManager.class) {
                if (instance == null) {
                    instance = new ApiManager();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化client
     */
    private OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            Cache cache = new Cache(new File(PathConstants.CACHE_HTTP), Constants.HTTP_CACHE_SIZE);
            mOkHttpClient = new OkHttpClient.Builder()
                    .cache(cache)
                    .addInterceptor(mRewriteCacheControlInterceptor)
                    .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                    .retryOnConnectionFailure(true)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build();
        }
        return mOkHttpClient;
    }

    // 云端响应头拦截器，用来配置缓存策略
    private Interceptor mRewriteCacheControlInterceptor = new Interceptor() {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Context context = BLApplication.getContext();
            if (!CommonUtil.isNet(context)) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            if (CommonUtil.isNet(context)) {
                //有网的时候读接口上的@Headers里的配置，可以在这里进行统一的设置
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=" + Constants.HTTP_CACHE_STALE_SHORT)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + Constants.HTTP_CACHE_STALE_LONG)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };


    /**
     * 获取首页推荐数据
     */
    public Observable<HomeBean> getHomeData() {
        return apiService.getHome();
    }

    /**
     * 获取视频具体信息
     */
    public Observable<VideoDetailBean> getVideoDetail(String aid) {
        return apiService.getVideoDetail(aid);
    }

    /**
     * 获取国创时间表
     */
    public Observable<BangumiListBean> getGuochuangTimeline() {
        return apiService.getGuochuangTimeline();
    }

    /**
     * 获取番剧时间表
     */
    public Observable<BangumiListBean> getBangumiTimeline() {
        return apiService.getBangumiTimeline();
    }

    /**
     * 获取番剧具体信息
     */
    public Observable<BangumiDetailBean> getBangumiDetail(String sid) {
        return apiService.getBangumiDetailData(sid);
    }

    /**
     * 搜索
     */
    public Observable<VideoListBean> doSearch(String word, int page, String order) {
        return apiService.doSearch(word, page, order);
    }


}
