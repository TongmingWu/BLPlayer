package com.tm.blplayer.mvp.presenter;

import com.tm.blplayer.listener.OnNetworkCallBackListener;
import com.tm.blplayer.mvp.model.BaseModel;
import com.tm.blplayer.mvp.model.VideoDetailModel;
import com.tm.blplayer.mvp.view.BaseView;

import java.util.Map;

/**
 * @author wutongming
 * @description 视频详情页
 * @since 2017/5/18
 */

public class VideoDetailPresenter extends BasePresenter<BaseView> implements OnNetworkCallBackListener {

    private BaseModel mModel;

    public VideoDetailPresenter() {
        mModel = new VideoDetailModel();
    }

    @Override
    public void requestData(Map<String, String> params) {
        addDisposable(mModel.requestData(params, this));
    }
}
