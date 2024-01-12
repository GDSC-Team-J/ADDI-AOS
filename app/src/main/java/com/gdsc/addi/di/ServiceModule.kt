package com.gdsc.addi.di

import com.gdsc.addi.data.service.AddiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    fun providesService(retrofit: Retrofit): AddiService =
        retrofit.create(AddiService::class.java)
}
