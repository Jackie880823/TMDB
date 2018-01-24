package com.jackie.tmdb.config;

import android.content.Context;

import com.jackie.tmdb.R;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created on 1/24/2018.
 *
 * @author Jackie
 * @version 1.0
 */

public class HttpConfig {

    public static ApiService apiService;

    public static void inti(Context context) {
        OkHttpClient client = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(context.getString(R.string.BASE_URL)).client(client).build();
        apiService = retrofit.create(ApiService.class);
    }
}
