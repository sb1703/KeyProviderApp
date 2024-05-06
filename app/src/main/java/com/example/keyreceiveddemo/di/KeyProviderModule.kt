package com.example.keyreceiveddemo.di

import com.example.keyreceiveddemo.domain.KeyProviderService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

//private const val BASE_URL = "http://10.0.2.2:8080"
//private const val BASE_URL = "http://192.168.29.79:8080"
private const val BASE_URL = "https://keyproviderserver.onrender.com"

@Module
@InstallIn(SingletonComponent::class)
object KeyProviderModule {

    @Provides
    @Singleton
    fun provideApiService(): KeyProviderService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
        return retrofit.create(KeyProviderService::class.java)
    }

}