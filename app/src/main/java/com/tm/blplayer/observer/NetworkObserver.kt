package com.tm.blplayer.observer

import android.support.annotation.NonNull
import com.orhanobut.logger.Logger
import com.tm.blplayer.bean.BaseBean
import com.tm.blplayer.listener.OnNetworkCallBackListener
import com.tm.blplayer.utils.constants.Constants

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author wutongming
 * *
 * @description 统一处理网络回调
 * *
 * @since 2017/5/17
 */

class NetworkObserver(@NonNull private val mOnNetworkCallBackListener: OnNetworkCallBackListener) : Observer<BaseBean<*>> {
    var disposable: Disposable? = null

    override fun onSubscribe(d: Disposable) {
        Logger.d("onSubscribe")
        this.disposable = d
    }

    override fun onNext(baseBean: BaseBean<*>?) {
        Logger.d("onNext")
        if (baseBean != null) {
            val code = baseBean.code
            if (code == Constants.REQUEST_SUCCEED) {

                mOnNetworkCallBackListener.onNetworkRequestSuccess(baseBean)
            } else {
                mOnNetworkCallBackListener.onNetworkRequestFailed(code, baseBean.message)
            }
        }
    }

    override fun onError(e: Throwable) {
        Logger.e(e.localizedMessage)
        mOnNetworkCallBackListener.onNetworkRequestError(e.message ?: "")

        if (!(disposable?.isDisposed ?: true)) {
            disposable?.dispose()
        }
    }

    override fun onComplete() {
        Logger.d("onComplete")
        if (!(disposable?.isDisposed ?: true)) {
            disposable?.dispose()
        }
    }
}
