package com.tm.blplayer.mvp.model;

import com.tm.blplayer.listener.OnNetworkCallBackListener;
import com.tm.blplayer.network.ApiManager;
import com.tm.blplayer.mvp.observer.NetworkObserver;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author wutongming
 * @description 推荐页
 * @since 2017/5/17
 */

public class RecommendModel implements BaseModel {
    @Override
    public Disposable requestData(Map<String, String> params, OnNetworkCallBackListener listener) {
        return null;
    }

    @Override
    public Disposable requestData(final OnNetworkCallBackListener listener) {
        NetworkObserver observer = new NetworkObserver(listener);
        ApiManager.getInstance()
                .getHomeData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
        return observer.getDisposable();
    }

}
