package com.example.cstv.di

import com.example.cstv.networking.MatchService
import com.example.cstv.repository.match.IMatchRepository
import com.example.cstv.repository.match.MatchRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {

    @Provides
    fun provideMatchRepositoryInstance(network: MatchService): IMatchRepository =
        MatchRepositoryImpl(network)

    @Provides
    fun provideMatchServiceInstance(retrofit: Retrofit): MatchService =
        retrofit.create(MatchService::class.java)

    @Provides
    fun provideRetrofitInstance(): Retrofit {

        val loggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.pandascore.co/csgo/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    companion object {
        private const val TIMEOUT = 20L
    }

}