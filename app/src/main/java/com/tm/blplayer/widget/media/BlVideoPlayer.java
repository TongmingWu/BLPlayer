package com.tm.blplayer.widget.media;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * @author wutongming
 * @description
 * @since 2017/5/27
 */

public class BlVideoPlayer extends FrameLayout {

    private IjkVideoView ijkVideoView;


    public BlVideoPlayer(@NonNull Context context) {
        this(context, null);
    }

    public BlVideoPlayer(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BlVideoPlayer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        ijkVideoView = new IjkVideoView(getContext());
        addView(ijkVideoView);
    }
}
