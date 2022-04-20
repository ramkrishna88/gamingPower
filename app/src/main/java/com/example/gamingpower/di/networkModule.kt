package com.example.gamingpower.di

import com.example.gamingpower.DataBase.DatabaseRepository
import com.example.gamingpower.DataBase.DatabaseRepositoryImpl
import com.example.gamingpower.Rest.GiveawaysRepository
import com.example.gamingpower.Rest.GiveawaysRepositoryImpl
import com.example.gamingpower.Rest.GiveawaysService
import com.example.gamingpower.Rest.GiveawaysService.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module

class NetworkModule {

    @Provides
    fun ProvideNetworkService(okHttpClient: OkHttpClient) = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(GiveawaysService::class.java)


    @Provides
    fun providesOkHttpClient() = OkHttpClient
        .Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY })
        .connectTimeout(30,TimeUnit.SECONDS)
        .readTimeout(30,TimeUnit.SECONDS)
        .writeTimeout(30,TimeUnit.SECONDS)

    @Provides
    fun ProvideRepository(serviceApi: GiveawaysService): GiveawaysRepository =
        GiveawaysRepositoryImpl(serviceApi)

    @Provides
    fun ProvidesRepository(serviceApi: GiveawaysService):DatabaseRepository =
        DatabaseRepositoryImpl(serviceApi)

    @Provides
    fun provideDispatcher() : CoroutineDispatcher =  Dispatchers.IO

}