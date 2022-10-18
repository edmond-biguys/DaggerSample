package com.xinzailingtech.daggersample.login

import android.util.Log
import androidx.lifecycle.ViewModel
import com.xinzailingtech.daggersample.ActivityScope
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by caoj on 2022/10/10.
 */
@ActivityScope
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {
    companion object {
        const val TAG = "LoginViewModel"
    }
    fun start() {
        Log.i(TAG, "start: $this")
        Log.i(TAG, "start: userRepository $userRepository")
        userRepository.start()
    }
}