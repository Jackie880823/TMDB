package com.jackie.tmdb.config

import com.jackie.tmdb.MyApplication
import com.jackie.tmdb.R

/**
 * Created on 1/24/2018.
 * @author  Jackie
 * @version 1.0
 */
object Constants {
    val API_KEY: String = MyApplication.getInstance().getString(R.string.API_KEY_V3)
}