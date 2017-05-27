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

public class BlVideoView extends FrameLayout {
    public BlVideoView(@NonNull Context context) {
        super(context);
    }

    public BlVideoView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BlVideoView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
