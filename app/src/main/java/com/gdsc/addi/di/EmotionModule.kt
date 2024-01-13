package com.gdsc.addi.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EmotionModule {
    private val json = Json { ignoreUnknownKeys = true }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class EmotionType

    @Provides
    @Singleton
    @EmotionType
    fun providesEmotionInterceptor(): Interceptor =
        Interceptor { chain ->
            val request = chain.request()
            val response = chain.proceed(
                request
                    .newBuilder()
                    .build()
            )
            response
        }

    @Provides
    @Singleton
    @EmotionType
    fun providesEmotionOkHttpClient(@EmotionType interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()

    @Provides
    @Singleton
    @EmotionType
    fun providesEmotionRetrofit(@EmotionType okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api-inference.huggingface.co/models/SamLowe/")
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
}
