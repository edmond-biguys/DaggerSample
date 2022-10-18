package com.xinzailingtech.daggersample.login

import android.util.Log
import javax.inject.Inject

/**
 * Created by caoj on 2022/10/10.
 */
class UserRemoteDataSource @Inject constructor(
    private val loginService: LoginService
) {
    fun start() {
        Log.i("UserRemoteDataSource", "start: $loginService")
    }
}