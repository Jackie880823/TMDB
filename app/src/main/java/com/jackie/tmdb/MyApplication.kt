package com.jackie.tmdb

import android.support.multidex.MultiDexApplication
import com.jackie.tmdb.config.HttpConfig

/**
 * Created on 1/17/2018.
 * @author  Jackie
 * @version 1.0
 */
class MyApplication : MultiDexApplication() {
    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        HttpConfig.inti(instance)
    }

    companion object {
        private lateinit var instance: MyApplication

        fun getInstance(): MultiDexApplication {
            return instance
        }
    }
}