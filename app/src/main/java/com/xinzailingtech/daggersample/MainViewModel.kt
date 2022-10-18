package com.xinzailingtech.daggersample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by caoj on 2022/10/8.
 */
class MainViewModel: ViewModel() {

    val userNameLiveData:LiveData<User>
        get() = _userNameLiveData

    private val _userNameLiveData = MutableLiveData<User>()

    fun startModifyUserName() {
        var index = 0
        viewModelScope.launch {
            while (true) {
                delay(5000)
                val user = User(userName = "userName$index")
                _userNameLiveData.postValue(user)
                index++
            }
        }
    }
}

data class User(val userName: String = "userName1")