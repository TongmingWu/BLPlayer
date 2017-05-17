package com.tm.blplayer.mvp.presenter;

import com.tm.blplayer.mvp.model.BaseModel;
import com.tm.blplayer.mvp.model.RecommendModel;
import com.tm.blplayer.mvp.view.BaseView;

import java.util.Map;

/**
 * @author wutongming
 * @description
 * @since 2017/5/17
 */

public class RecommendPresenter extends BasePresenter<BaseView> {

    private BaseModel mModel;

    public RecommendPresenter() {
        mModel = new RecommendModel();
    }

    @Override
    public void requestData(Map<String, String> params) {
        addDisposable(mModel.requestData(this));
    }
}
