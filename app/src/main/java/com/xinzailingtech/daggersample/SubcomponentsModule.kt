package com.xinzailingtech.daggersample

import com.xinzailingtech.daggersample.login.LoginGraph
import com.xinzailingtech.mylibrary.SettingsGraph
import dagger.Module

/**
 * Created by caoj on 2022/10/13.
 */
@Module(subcomponents = [LoginGraph::class, SettingsGraph::class])
class SubcomponentsModule {
}