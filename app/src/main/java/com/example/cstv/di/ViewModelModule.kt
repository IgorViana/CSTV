package com.example.cstv.di

import com.example.cstv.networking.MatchService
import com.example.cstv.repository.match.IMatchRepository
import com.example.cstv.repository.match.MatchRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/*
@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideMatchRepositoryInstance(network: MatchService): IMatchRepository =
        MatchRepositoryImpl(network)
}*/
