package com.jackie.tmdb.login

import com.jackie.tmdb.config.Constants
import com.jackie.tmdb.config.HttpConfig

/**
 * Created on 1/24/2018.
 * @author  Jackie
 * @version 1.0
 */
class LoginResponse {
    fun getToken(){
        val token = HttpConfig.apiService.getToken(Constants.API_KEY)
    }
}