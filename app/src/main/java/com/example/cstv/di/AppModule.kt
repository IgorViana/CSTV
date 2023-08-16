package com.example.cstv.di

import com.example.cstv.networking.MatchService
import com.example.cstv.networking.PlayerService
import com.example.cstv.repository.match.IMatchRepository
import com.example.cstv.repository.match.IPlayerRepository
import com.example.cstv.repository.match.MatchRepositoryImpl
import com.example.cstv.repository.match.PlayerRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideMatchRepositoryInstance(network: MatchService): IMatchRepository =
        MatchRepositoryImpl(network)

    @Provides
    fun providePlayerRepositoryInstance(network: PlayerService): IPlayerRepository =
        PlayerRepositoryImpl(network)

    @Provides
    fun provideMatchServiceInstance(retrofit: Retrofit): MatchService =
        retrofit.create(MatchService::class.java)

    @Provides
    fun providePlayerServiceInstance(retrofit: Retrofit): PlayerService =
        retrofit.create(PlayerService::class.java)

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {

        val loggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .readTimeout(TIMEOUT, TimeUnit.MINUTES)
            .connectTimeout(TIMEOUT, TimeUnit.MINUTES)
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
        private const val TIMEOUT = 1L
    }

}