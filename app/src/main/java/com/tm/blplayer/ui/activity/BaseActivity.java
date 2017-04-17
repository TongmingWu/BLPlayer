package com.tm.blplayer.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    private Unbinder bind;

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
