package com.xinzailingtech.daggersample.login

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by caoj on 2022/10/10.
 */
class UserRepository @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) {
    private val TAG = "UserRepository"
    fun start() {
        Log.i(TAG, "start: userLocalDataSource $userLocalDataSource")
        Log.i(TAG, "start: userRemoteDataSource $userRemoteDataSource")
        userRemoteDataSource.start()

    }
}