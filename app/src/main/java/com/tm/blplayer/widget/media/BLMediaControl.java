package com.tm.blplayer.widget.media;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;

import com.tm.blplayer.R;

/**
 * @author wutongming
 * @description 控制面板
 * @since 2017/6/3
 */

public class BLMediaControl extends FrameLayout implements IMediaController {

    private FrameLayout mController;
    private View mAnchor;
    private MediaController.MediaPlayerControl mPlayer;

    public BLMediaControl(@NonNull Context context) {
        this(context, null);
    }

    public BLMediaControl(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BLMediaControl(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mController = (FrameLayout) inflate(getContext(), R.layout.include_media_control, null);
        addView(mController);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public void hide() {
        mController.setVisibility(GONE);
    }

    @Override
    public boolean isShowing() {
        return mController.getVisibility() == VISIBLE;
    }

    @Override
    public void setAnchorView(View view) {
        //绑定VideoView

    }

    @Override
    public void setMediaPlayer(MediaController.MediaPlayerControl player) {
        mPlayer = player;
    }

    @Override
    public void show(int timeout) {
        postDelayed(() -> mController.setVisibility(VISIBLE), timeout);
    }

    @Override
    public void show() {
        mController.setVisibility(VISIBLE);
    }

    @Override
    public void showOnce(View view) {

    }
}
