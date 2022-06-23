package com.rojer_ko.bmove.di

import com.rojer_ko.core.repo.StationsRepository
import com.rojer_ko.repository.StationsRepositoryImpl
import dagger.Module
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    fun provideStationsRepo(): StationsRepository = StationsRepositoryImpl()
}