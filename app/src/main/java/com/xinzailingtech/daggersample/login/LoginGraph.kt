package com.xinzailingtech.daggersample.login

import com.xinzailingtech.daggersample.ActivityScope
import dagger.Subcomponent

/**
 * Created by caoj on 2022/10/13.
 */
@ActivityScope
@Subcomponent
interface LoginGraph {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginGraph
    }

    fun inject(activity: LoginActivity)
    fun inject(fragment: LoginUsernameFragment)
    fun inject(fragment: LoginPasswordFragment)
}