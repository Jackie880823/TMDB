/*
 *              $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
 *              $                                                   $
 *              $                       _oo0oo_                     $
 *              $                      o8888888o                    $
 *              $                      88" . "88                    $
 *              $                      (| -_- |)                    $
 *              $                      0\  =  /0                    $
 *              $                    ___/`-_-'\___                  $
 *              $                  .' \\|     |$ '.                 $
 *              $                 / \\|||  :  |||$ \                $
 *              $                / _||||| -:- |||||- \              $
 *              $               |   | \\\  -  $/ |   |              $
 *              $               | \_|  ''\- -/''  |_/ |             $
 *              $               \  .-\__  '-'  ___/-. /             $
 *              $             ___'. .'  /-_._-\  `. .'___           $
 *              $          ."" '<  `.___\_<|>_/___.' >' "".         $
 *              $         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       $
 *              $         \  \ `_.   \_ __\ /__ _/   .-` /  /       $
 *              $     =====`-.____`.___ \_____/___.-`___.-'=====    $
 *              $                       `=-_-='                     $
 *              $     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   $
 *              $                                                   $
 *              $          Buddha Bless         Never Bug           $
 *              $                                                   $
 *              $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
 *
 *   Copyright (C) 2016 The Android Open Source Project By Jackie
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.jackie.tmdb.entities

import android.os.Parcel
import android.os.Parcelable

/**
 * Created on 1/28/2018.
 *
 * @author Jackie
 * @version 1.0
 */

class Token : Parcelable {
    /**
     * success : true
     * expires_at : 2018-01-28 13:41:10 UTC
     * request_token : 6ad1fcada1dc74524a7d76f1bcd58acb9b83a295
     */

    var isSuccess: Boolean = false

    var expires_at: String? = null

    var request_token: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val token = o as Token?

        return request_token == token!!.request_token
    }

    override fun hashCode(): Int {
        return request_token!!.hashCode()
    }

    constructor()

    constructor(source: Parcel) : this(
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {}

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Token> = object : Parcelable.Creator<Token> {
            override fun createFromParcel(source: Parcel): Token = Token(source)
            override fun newArray(size: Int): Array<Token?> = arrayOfNulls(size)
        }
    }
}
