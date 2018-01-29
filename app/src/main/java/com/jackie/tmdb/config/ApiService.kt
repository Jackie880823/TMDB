package com.jackie.tmdb.config

import com.jackie.tmdb.entities.Token
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

/**
 * Created on 1/28/2018.
 * @author  Jackie
 * @version 1.0
 */
interface ApiService {

    @GET("authentication/token/new")
    fun getToken(@Query(PARAM_API_KEY) key: String): Observable<Token>

    @GET("authentication/token/validate_with_login")
    fun login(@QueryMap queryMap: Map<String, String>): Observable<Token>

    companion object {
        const val PARAM_API_KEY: String = "api_key"
        const val PARAM_REQUEST_TOKEN: String = "request_token"

        const val PARAM_USERNAME: String = "username"
        const val PARAM_PASSWORD: String = "password"
    }
}