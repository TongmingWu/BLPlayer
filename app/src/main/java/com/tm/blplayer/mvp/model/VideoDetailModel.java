package com.tm.blplayer.mvp.model;

import com.tm.blplayer.listener.OnNetworkCallBackListener;
import com.tm.blplayer.network.ApiManager;
import com.tm.blplayer.observer.NetworkObserver;
import com.tm.blplayer.utils.constants.Constants;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author wutongming
 * @description 获取视频详情页数据
 * @since 2017/5/18
 */

public class VideoDetailModel implements BaseModel {
    @Override
    public Disposable requestData(Map<String, String> params, OnNetworkCallBackListener listener) {
        String aid = params.get(Constants.VIDEO_AID);
        NetworkObserver observer = new NetworkObserver(listener);
        ApiManager.getInstance()
                .getVideoDetail(aid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
        return observer.getDisposable();
    }

    @Override
    public Disposable requestData(OnNetworkCallBackListener listener) {
        return null;
    }
}
