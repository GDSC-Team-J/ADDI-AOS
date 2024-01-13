package com.gdsc.addi.di

import com.gdsc.addi.data.service.AddiService
import com.gdsc.addi.data.service.EmotionService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    fun providesAddiService(@RetrofitModule.NormalType retrofit: Retrofit): AddiService =
        retrofit.create(AddiService::class.java)

    @Provides
    fun providesEmotionService(@EmotionModule.EmotionType retrofit: Retrofit): EmotionService =
        retrofit.create(EmotionService::class.java)
}
