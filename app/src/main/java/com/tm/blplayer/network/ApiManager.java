package com.tm.blplayer.network;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.tm.blplayer.BLApplication;
import com.tm.blplayer.bean.BangumiDetailData;
import com.tm.blplayer.bean.BangumiListData;
import com.tm.blplayer.bean.BaseBean;
import com.tm.blplayer.bean.CategoryListData;
import com.tm.blplayer.bean.HomeData;
import com.tm.blplayer.bean.VideoDetailData;
import com.tm.blplayer.bean.VideoListData;
import com.tm.blplayer.url.PrefixUrl;
import com.tm.blplayer.utils.CommonUtil;
import com.tm.blplayer.utils.constants.Constants;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author wutongming
 * @description api管理器
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
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
            Cache cache = new Cache(new File(BLApplication.getInstance().getCacheDir(), "http"), Constants.HTTP_CACHE_SIZE);
            mOkHttpClient = new OkHttpClient.Builder()
                    .cache(cache)
                    .cookieJar(new BlCookiesJar())
                    .addInterceptor(mRewriteCacheControlInterceptor)
                    .addInterceptor(new LogInterceptor())
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
            Context context = BLApplication.getInstance();
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
     * 日志拦截器,用于联网记录日志打印
     */
    private static class LogInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Logger.d("request:" + request.toString());
            long t1 = System.nanoTime();
            okhttp3.Response response = chain.proceed(chain.request());
            long t2 = System.nanoTime();
            Logger.d(String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            Logger.d("response body:" + content);
            return response.newBuilder()
                    .body(okhttp3.ResponseBody.create(mediaType, content))
                    .build();
        }
    }

    /**
     * cookies管理器
     */
    private static class BlCookiesJar implements CookieJar {

        private Map<String, List<Cookie>> cookieStore = new HashMap<>();

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            //可以保存cookies到本地
            Logger.d("host = " + url.host());
            cookieStore.put(url.host(), cookies);
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            //可以从本地读取cookies发送
            List<Cookie> cookies = cookieStore.get(url.host());
            cookies = cookies != null ? cookies : new ArrayList<Cookie>();
            for (Cookie cookie : cookies) {
                Logger.d(cookie.name());
                Logger.d(cookie.value());
            }
            //测试数据
            Cookie cookie = new Cookie.Builder()
                    .name("test")
                    .value("123456")
                    .build();
            cookies.add(cookie);
            return cookies;
        }
    }


    /**
     * 获取首页推荐数据
     */
    public Observable<BaseBean<HomeData>> getHomeData() {
        return apiService.getHome();
    }

    /**
     * 获取视频具体信息
     *
     * @param aid 视频id
     */
    public Observable<BaseBean<VideoDetailData>> getVideoDetail(String aid) {
        return apiService.getVideoDetail(aid);
    }

    /**
     * 获取国创时间表
     */
    public Observable<BaseBean<BangumiListData>> getGuochuangTimeline() {
        return apiService.getGuochuangTimeline();
    }

    /**
     * 获取番剧时间表
     */
    public Observable<BaseBean<BangumiListData>> getBangumiTimeline() {
        return apiService.getBangumiTimeline();
    }

    /**
     * 获取番剧具体信息
     *
     * @param sid 番剧id --> season_id
     */
    public Observable<BaseBean<BangumiDetailData>> getBangumiDetail(String sid) {
        return apiService.getBangumiDetailData(sid);
    }

    /**
     * 搜索
     *
     * @param word  关键字
     * @param page  当前页数
     * @param order 排列顺序
     */
    public Observable<BaseBean<VideoListData>> doSearch(String word, int page, String order) {
        return apiService.doSearch(word, page, order);
    }

    /**
     * 获取分类表
     */
    public Observable<BaseBean<CategoryListData>> getCategoryOrder() {
        return apiService.getCategoryOrder();
    }

    /**
     * 获取一级分类信息
     *
     * @param firstTid 一级分类 如动画
     */
    public Observable<BaseBean<?>> getCategoryInfo(String firstTid) {
        return apiService.getCategoryInfo(firstTid);
    }

    /**
     * 获取一级分类信息
     *
     * @param firstTid  一级分类 如动画
     * @param secondTid 二级分类 如MAD
     */
    public Observable<BaseBean<?>> getCategoryInfo(String firstTid, String secondTid) {
        return apiService.getCategoryInfo(firstTid, secondTid);
    }
}
