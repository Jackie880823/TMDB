package com.jackie.tmdb.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
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
    private var liveData: MediatorLiveData<Token> = MediatorLiveData()
    fun getToken(): LiveData<Token> {
        HttpConfig.apiService.getToken(Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t: Token? -> liveData.value = t })
        return liveData
    }
}
