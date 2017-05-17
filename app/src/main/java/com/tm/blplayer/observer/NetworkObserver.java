package com.tm.blplayer.observer;

import com.orhanobut.logger.Logger;
import com.tm.blplayer.bean.BaseBean;
import com.tm.blplayer.listener.OnNetworkCallBackListener;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author wutongming
 * @description 统一处理网络回调
 * @since 2017/5/17
 */

public class NetworkObserver implements Observer<BaseBean<?>> {

    private OnNetworkCallBackListener mOnNetworkCallBackListener;
    private Disposable mDisposable;

    public NetworkObserver(OnNetworkCallBackListener listener) {
        this.mOnNetworkCallBackListener = listener;
    }

    public Disposable getDisposable() {
        return mDisposable;
    }

    @Override
    public void onSubscribe(Disposable d) {
        Logger.d("onSubscribe");
        this.mDisposable = d;
    }

    @Override
    public void onNext(BaseBean<?> baseBean) {
        Logger.d("onNext");
        if (baseBean != null) {
            int code = baseBean.getCode();
            if (code == 200) {
                mOnNetworkCallBackListener.onNetworkRequestSuccess(baseBean);
            } else {
                mOnNetworkCallBackListener.onNetworkRequestFailed(code, baseBean.getMessage());
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        Logger.e(e.getLocalizedMessage());
        mOnNetworkCallBackListener.onNetworkRequestError(e.getMessage());
        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    @Override
    public void onComplete() {
        Logger.d("onComplete");
        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}
