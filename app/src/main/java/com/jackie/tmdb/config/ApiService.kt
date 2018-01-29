package com.jackie.tmdb.config

import com.jackie.tmdb.entities.Token
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created on 1/28/2018.
 * @author  Jackie
 * @version 1.0
 */
interface ApiService {

    @GET("authentication/token/new")
    fun getToken(@Query("api_key") key: String): Observable<Token>
}