package com.tm.blplayer.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.MediaController;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * @author wutongming
 * @description 视频播放器控件
 * @since 2017/5/18
 */

public class BlVideoView extends FrameLayout implements MediaController.MediaPlayerControl {

    private IjkMediaPlayer ijkMediaPlayer;

    public BlVideoView(Context context) {
        super(context);
    }

    /**
     * 初始化播放器
     *
     * @param url 视频地址
     */
    public void init(String url) {

    }

    @Override
    public void start() {

    }

    @Override
    public void pause() {

    }

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        return 0;
    }

    @Override
    public void seekTo(int pos) {

    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return false;
    }

    @Override
    public boolean canSeekBackward() {
        return false;
    }

    @Override
    public boolean canSeekForward() {
        return false;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }
}
