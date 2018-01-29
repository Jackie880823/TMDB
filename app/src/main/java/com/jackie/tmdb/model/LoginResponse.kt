package com.jackie.tmdb.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.jackie.tmdb.config.ApiService
import com.jackie.tmdb.config.Constants
import com.jackie.tmdb.config.HttpConfig
import com.jackie.tmdb.entities.Token
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created on 1/24/2018.
 * @author  Jackie
 * @version 1.0
 */
class LoginResponse {
    fun getToken(): LiveData<Token> {
        val liveData: MediatorLiveData<Token> = MediatorLiveData()
        HttpConfig.apiService.getToken(Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t: Token? -> liveData.postValue(t) })
        return liveData
    }

    fun login(username: String, password: String): LiveData<Token> {
        val liveData: MediatorLiveData<Token> = MediatorLiveData()
        liveData.addSource(getToken(), { t ->
            val queryMap: Map<String, String> = hashMapOf(ApiService.PARAM_API_KEY to Constants.API_KEY,
                    ApiService.PARAM_USERNAME to username,
                    ApiService.PARAM_PASSWORD to password,
                    ApiService.PARAM_REQUEST_TOKEN to (t?.request_token ?: ""))
            HttpConfig.apiService.login(queryMap)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ t: Token? -> liveData.value = t })
        })
        return liveData
    }
}
