package com.tm.blplayer.mvp.presenter;

import com.tm.blplayer.bean.BaseBean;
import com.tm.blplayer.listener.OnNetworkCallBackListener;
import com.tm.blplayer.mvp.view.BaseView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * @author wutongming
 * @description
 * @since 2017/5/16
 */

public abstract class BasePresenter<T extends BaseView> implements OnNetworkCallBackListener {

    private List<Disposable> disposableList;

    private T mView;

    /**
     * 视图绑定
     */
    public void onAttach(T view) {
        this.mView = view;
        disposableList = new ArrayList<>();
    }

    /**
     * 当view视图销毁时,取消绑定
     */
    public void onDetach() {
        mView = null;
        if (disposableList != null && disposableList.size() > 0) {
            //解绑
            for (Disposable disposable : disposableList) {
                if (!disposable.isDisposed()) {
                    disposable.dispose();
                }
            }
        }
    }

    /**
     * 获取数据操作
     *
     * @param params 获取数据时携带的参数
     */
    public abstract void requestData(Map<String, String> params);

    /**
     * 添加subscription
     */
    protected void addDisposable(Disposable disposable) {
        if (disposableList != null) {
            disposableList.add(disposable);
        }
    }

    @Override
    public void onNetworkRequestSuccess(BaseBean<?> response) {
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

