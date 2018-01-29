package com.jackie.tmdb.config

import android.content.Context
import com.jackie.tmdb.R
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created on 1/24/2018.
 *
 * @author Jackie
 * @version 1.0
 */

object HttpConfig {

    lateinit var apiService: ApiService

    fun inti(context: Context) {
        val client = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder().baseUrl(context.getString(R.string.BASE_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
        apiService = retrofit.create(ApiService::class.java)
    }
}
