package com.tm.blplayer.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.View
import com.tm.blplayer.R
import com.tm.blplayer.mvp.presenter.BasePresenter
import com.tm.blplayer.mvp.view.BaseView
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import kotlinx.android.synthetic.main.include_common_toolbar.*

/**
 * @author wutongming
 * *
 * @description
 * *
 * @since 2017/4/17
 */

abstract class BaseActivity : RxAppCompatActivity(), View.OnClickListener {

    protected var presenter: BasePresenter<BaseView>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initView()
        initToolbar()
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
     * Toolbar统一处理
     */
    protected open fun initToolbar() {
        setSupportActionBar(common_toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.ll_back, R.id.ll_cancel -> finish()
        }
    }

    /**
     * Activity跳转

     * @param bundle 携带的数据
     */
    @JvmOverloads protected fun jumpToActivity(clazz: Class<*>, closeCurrent: Boolean = false, bundle: Bundle? = null) {
        val intent = Intent(this, clazz)
        intent.putExtras(bundle)
        startActivity(intent)
        if (closeCurrent) {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDetach()
    }
}