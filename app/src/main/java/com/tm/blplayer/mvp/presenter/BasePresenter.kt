package com.tm.blplayer.mvp.presenter

import com.tm.blplayer.bean.BaseBean
import com.tm.blplayer.listener.OnNetworkCallBackListener
import com.tm.blplayer.mvp.view.BaseView
import io.reactivex.disposables.Disposable
import java.util.*

/**
 * @author wutongming
 * *
 * @description
 * *
 * @since 2017/5/16
 */

abstract class BasePresenter<in T : BaseView> : OnNetworkCallBackListener {

    private var disposableList: MutableList<Disposable>? = null

    private var mView: T? = null

    /**
     * 视图绑定
     */
    fun onAttach(view: T) {
        this.mView = view
        disposableList = ArrayList<Disposable>()
    }

    /**
     * 当view视图销毁时,取消绑定
     */
    fun onDetach() {
        mView = null

        //解绑
        disposableList?.filterNot { it.isDisposed }?.forEach { it.dispose() }
    }

    /**不带参数*/
    abstract fun requestData()

    /**
     * 获取数据操作

     * @param params 获取数据时携带的参数
     */
    abstract fun requestData(params: Map<String, String>)

    /**
     * 添加subscription
     */
    protected fun addDisposable(disposable: Disposable) {
        disposableList?.add(disposable)
    }

    override fun onNetworkRequestSuccess(response: BaseBean<*>) {
        val result = response.result
        if (result != null) {
            mView?.onNetworkSuccess(result)
        }
    }

    override fun onNetworkRequestFailed(errorCode: Int, errorMsg: String) {
        mView?.onNetworkFailed(errorCode, errorMsg)
    }

    override fun onNetworkRequestError(error: String) {
        mView?.onNetworkError(error)
    }
}

