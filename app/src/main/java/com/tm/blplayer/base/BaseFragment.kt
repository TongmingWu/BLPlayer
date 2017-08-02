package com.tm.blplayer.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tm.blplayer.mvp.presenter.BasePresenter
import com.tm.blplayer.mvp.view.BaseView
import com.trello.rxlifecycle.components.support.RxFragment
import rx.Subscription

/**
 * @author wutongming
 * *
 * @description
 * *
 * @since 2017/4/17
 */

abstract class BaseFragment : RxFragment(), View.OnClickListener {

    private var mRootView: View? = null
    protected var presenter: BasePresenter<BaseView>? = null
    protected var subscriptionList: MutableCollection<Subscription>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = mRootView ?: inflater.inflate(layoutId, null)
        return mRootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    /**
     * LayoutId
     */
    @get:LayoutRes
    protected abstract val layoutId: Int

    /**
     * 初始化View
     */
    protected abstract fun initView()

    /**
     * 添加订阅事件
     */
    protected fun addToSubscriptions(subscription: Subscription) {
        subscriptionList ?: ArrayList()
        subscriptionList?.let {
            subscriptionList?.add(subscription)
        }
    }

    /**
     * 移除订阅事件
     */
    protected fun removeSubscriptions() {
        subscriptionList?.filterNot {
            it.isUnsubscribed
        }?.forEach {
            it.unsubscribe()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter?.onDetach()
        removeSubscriptions()
    }
}
