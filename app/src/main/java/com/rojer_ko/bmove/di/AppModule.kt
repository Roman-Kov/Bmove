package com.rojer_ko.bmove.di

import com.rojer_ko.core.repo.StationsRepository
import com.rojer_ko.repository.StationsRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @AppScope
    @Provides
    fun provideStationsRepo(): StationsRepository = StationsRepositoryImpl()
}