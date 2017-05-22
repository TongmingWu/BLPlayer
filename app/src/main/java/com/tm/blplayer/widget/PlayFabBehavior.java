package com.tm.blplayer.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * @author wutongming
 * @description 播放按钮的自定义Behavior
 * @since 2017/5/19
 */

public class PlayFabBehavior extends CoordinatorLayout.Behavior<View> {

    private int mStartY;

    public PlayFabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Logger.d("onDependentViewChanged");
        if (mStartY == 0) {
            mStartY = (int) child.getY();
        } else {

        }
        //阈值为mStartY/2
        Logger.d("childY = " + child.getY());   //可以根据childY动态隐藏显示view

        return true;
    }

    /**
     * 控制view的显示隐藏
     */
    private void toggleView(View child) {
        if (child.getVisibility() == View.VISIBLE) {
            hide(child);
        } else {
            show(child);
        }
    }

    /**
     * 隐藏时的动画
     */
    private void hide(View child) {
        child.setVisibility(View.GONE);
    }

    /**
     * 显示时的动画
     */
    private void show(View child) {
        child.setVisibility(View.VISIBLE);
    }
}
