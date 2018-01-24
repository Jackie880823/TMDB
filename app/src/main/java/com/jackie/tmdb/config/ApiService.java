package com.jackie.tmdb.config;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created on 1/24/2018.
 *
 * @author Jackie
 * @version 1.0
 */

public interface ApiService {

    @GET("authentication/token/new")
    Call<String> getToken(@Query("api_key") String key);
}
