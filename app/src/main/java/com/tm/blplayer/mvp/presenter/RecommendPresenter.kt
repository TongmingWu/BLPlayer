package com.tm.blplayer.mvp.presenter

import com.tm.blplayer.mvp.model.BaseModel
import com.tm.blplayer.mvp.model.RecommendModel
import com.tm.blplayer.mvp.view.BaseView

/**
 * @author wutongming
 * *
 * @description
 * *
 * @since 2017/5/17
 */

class RecommendPresenter : BasePresenter<BaseView>() {

    private val mModel: BaseModel

    init {
        mModel = RecommendModel()
    }

    override fun requestData() {
        mModel.requestData(this)?.let { addDisposable(it) }
    }

    override fun requestData(params: Map<String, String>) {
    }
}
