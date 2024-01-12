package com.gdsc.addi.di

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.gdsc.addi.BuildConfig
import com.gdsc.addi.R
import com.gdsc.addi.ui.utils.isNetworkConnected
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private val json = Json { ignoreUnknownKeys = true }
    private const val CONTENT_TYPE = "Content-Type"
    private const val APPLICATION_JSON = "application/json"
    private const val MAC_ADDRESS = "macAddress"
    private const val SERVER_ERROR = 500

    @Singleton
    @Provides
    fun providesAddiInterceptor(
        @ApplicationContext context: Context,
        //localTokenDataSource: LocalTokenDataSource
    ): Interceptor = Interceptor { chain ->
        if (!context.isNetworkConnected()) {
            Toast.makeText(context, R.string.network_error_msg, Toast.LENGTH_SHORT).show()
        }

        val request = chain.request()
        var response = chain.proceed(
            request
                .newBuilder()
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                /** TODO 로컬 mac address값 추가하기 localTokenDataSource.macAddress */
                .addHeader(MAC_ADDRESS, "1")
                .build()
        )
        when (response.code) {
            SERVER_ERROR -> {
                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(context, R.string.sever_500_error_msg, Toast.LENGTH_SHORT).show()
                }
            }
        }
        response
    }

    @Singleton
    @Provides
    fun providesAddiOkHttpClient(interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level =
                        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                }
            ).build()

    @Singleton
    @Provides
    fun providesAddiRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
}
