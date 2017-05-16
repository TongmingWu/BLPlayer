package com.tm.blplayer.mvp.presenter;

import android.os.Bundle;

import com.tm.blplayer.bean.BaseBean;
import com.tm.blplayer.listener.OnNetworkCallBackListener;
import com.tm.blplayer.mvp.view.BaseView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rx.Subscription;

/**
 * @author wutongming
 * @description
 * @since 2017/5/16
 */

public abstract class BasePresenter<T extends BaseView> implements OnNetworkCallBackListener {

    private List<Subscription> subscriptionList;

    private T mView;

    /**
     * 视图绑定
     */
    public void onAttach(T view) {
        this.mView = view;
        subscriptionList = new ArrayList<>();
    }

    /**
     * 当view视图销毁时,取消绑定
     */
    public void onDetach() {
        mView = null;
        if (subscriptionList != null && subscriptionList.size() > 0) {
            //解绑
            for (Subscription subscription : subscriptionList) {
                if (!subscription.isUnsubscribed()) {
                    subscription.unsubscribe();
                }
            }
        }
    }

    /**
     * 容易被回收掉时保存数据
     */
    public abstract void onSaveInstanceState(Bundle outState);

    /**
     * 获取数据操作
     *
     * @param params 获取数据时携带的参数
     */
    public abstract void requestData(Map<String, String> params);

    /**
     * 添加subscription
     */
    protected void addSubscription(Subscription subscription) {
        if (subscriptionList != null) {
            subscriptionList.add(subscription);
        }
    }

    @Override
    public void onNetworkRequestSuccess(BaseBean<Object> response) {
        if (mView != null && response != null) {
            Object result = response.getResult();
            mView.onNetworkSuccess(result);
        }
    }

    @Override
    public void onNetworkRequestFailed(int errorCode, String errorMsg) {
        if (mView != null) {
            mView.onNetworkFailed(errorCode, errorMsg);
        }
    }

    @Override
    public void onNetworkRequestError(String error) {
        if (mView != null) {
            mView.onNetworkError(error);
        }
    }
}

