package com.tm.blplayer.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tm.blplayer.mvp.presenter.BasePresenter;
import com.tm.blplayer.mvp.view.BaseView;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public abstract class BaseFragment extends RxFragment {

    private View mRootView;
    private Unbinder bind;
    protected BasePresenter<BaseView> presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), null);
        }
        bind = ButterKnife.bind(this, mRootView);
        initView();
        return mRootView;
    }

    /**
     * LayoutId
     */
    protected abstract int getLayoutId();

    /**
     * 初始化View
     */
    protected abstract void initView();

    @Override
    public void onDestroyView() {
        if (bind != null) {
            bind.unbind();
        }
        if (presenter != null) {
            presenter.onDetach();
        }
        super.onDestroyView();
    }
}
