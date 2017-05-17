package com.tm.blplayer;

import android.app.Application;
import android.content.Context;

/**
 * @author wutongming
 * @description
 * @since 2017/4/17
 */

public class BLApplication extends Application {

    private static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = getApplicationContext();
    }

    public static Context getInstance() {
        return instance;
    }
}
