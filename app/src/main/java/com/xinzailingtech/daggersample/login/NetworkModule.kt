package com.xinzailingtech.daggersample.login

import com.xinzailingtech.daggersample.ActivityScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by caoj on 2022/10/12.
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideLoginService(): LoginService {

        return Retrofit.Builder()
            .baseUrl("http://xxx-url.com")
            .build()
            .create(LoginService::class.java)
    }
}