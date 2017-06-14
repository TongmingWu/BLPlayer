package com.tm.blplayer.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tm.blplayer.mvp.presenter.BasePresenter
import com.tm.blplayer.mvp.view.BaseView
import com.trello.rxlifecycle.components.support.RxFragment

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mRootView = inflater.inflate(layoutId, null)
        }
        return mRootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    /**
     * LayoutId
     */
    protected abstract val layoutId: Int

    /**
     * 初始化View
     */
    protected abstract fun initView()

    override fun onDestroyView() {
        presenter?.onDetach()
        super.onDestroyView()
    }
}
