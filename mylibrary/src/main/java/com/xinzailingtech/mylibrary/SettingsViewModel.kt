package com.xinzailingtech.mylibrary

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by caoj on 2022/10/18.
 */
class SettingsViewModel @Inject constructor(): ViewModel() {
    private val TAG: String = "SettingsViewModel"

    fun start() {
        Log.i(TAG, "start: $this")
    }
}