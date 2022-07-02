package com.rojer_ko.bmove.di

import androidx.lifecycle.ViewModelProvider
import com.rojer_ko.core.di.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelsModule {

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}