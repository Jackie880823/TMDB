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

package com.jackie.tmdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.jackie.tmdb.config.ApiService
import com.jackie.tmdb.model.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Set up the login form.
        password.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                return@OnEditorActionListener true
            }
            false
        })

        sign_in_button.setOnClickListener {
            LoginResponse().login(username.text.toString(), password.toString())
        }
    }
}
