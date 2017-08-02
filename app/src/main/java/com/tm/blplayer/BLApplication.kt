package com.tm.blplayer

import android.app.Application
import android.content.Context
import com.tencent.smtt.sdk.QbSdk

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
        initSDK()
    }

    private fun initSDK() {
        QbSdk.initX5Environment(instance, null)
    }

    companion object {

        var instance: Context? = null
    }
}
