package com.tm.blplayer;

import android.app.Application;
import android.content.Context;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class BLApplication extends Application {

    private static BLApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static Context getContext() {
        return instance;
    }
}
