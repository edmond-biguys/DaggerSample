package com.xinzailingtech.mylibrary

import dagger.Component
import dagger.Module
import dagger.Subcomponent

/**
 * Created by caoj on 2022/10/18.
 */
@Subcomponent
interface SettingsGraph {
    @Subcomponent.Factory
    interface Factory {
        fun create(): SettingsGraph
    }
    fun inject(activity: SettingsActivity)
}