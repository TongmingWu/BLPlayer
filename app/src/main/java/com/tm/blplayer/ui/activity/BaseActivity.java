package com.tm.blplayer.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.tm.blplayer.R;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    private Unbinder bind;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.ll_cancel)
    LinearLayout llCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        initView();
        initToolbar();
    }

    /**
     * LayoutId
     */
    protected abstract int getLayoutId();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * Toolbar统一处理
     */
    protected void initToolbar() {

    }

    @OnClick({R.id.ll_back, R.id.ll_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
            case R.id.ll_cancel:
                finish();
                break;
        }
    }

    /**
     * Activity跳转
     */
    protected void jumpToActivity(Class<?> clazz) {
        jumpToActivity(clazz, false);
    }

    /**
     * Activity跳转,提供关闭当前Activity的功能
     *
     * @param closeCurrent 是否关闭当前Activity
     */
    protected void jumpToActivity(Class<?> clazz, boolean closeCurrent) {
        jumpToActivity(clazz, closeCurrent, null);
    }

    /**
     * Activity跳转
     *
     * @param bundle 携带的数据
     */
    protected void jumpToActivity(Class<?> clazz, boolean closeCurrent, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (closeCurrent) {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
    }
}
