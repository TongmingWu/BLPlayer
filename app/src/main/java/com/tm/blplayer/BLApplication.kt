package com.tm.blplayer

import android.app.Application
import android.content.Context

/**
 * @author wutongming
 * *
 * @description
 * *
 * @since 2017/4/17
 */

class BLApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        instance = applicationContext
    }

    companion object {

        var instance: Context? = null
    }
}
