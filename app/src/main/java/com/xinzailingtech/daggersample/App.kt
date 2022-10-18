package com.xinzailingtech.daggersample

import android.app.Application
import com.xinzailingtech.daggersample.login.LoginGraph
import com.xinzailingtech.daggersample.login.NetworkModule
import com.xinzailingtech.mylibrary.ISettingsGraphProvider
import com.xinzailingtech.mylibrary.SettingsGraph
import dagger.Component
import javax.inject.Singleton

/**
 * Created by caoj on 2022/10/10.
 */
@Singleton
@Component(modules = [NetworkModule::class, SubcomponentsModule::class])
interface AppGraph {
    fun inject(activity: MainActivity)
    fun loginGraph(): LoginGraph.Factory
    //settings module
    fun settingGraph(): SettingsGraph.Factory
}

class App: Application(), ISettingsGraphProvider {
    val appGraph: AppGraph = DaggerAppGraph.create()

    override fun providerSettingsGraph(): SettingsGraph {
        return appGraph.settingGraph().create()
    }
}

