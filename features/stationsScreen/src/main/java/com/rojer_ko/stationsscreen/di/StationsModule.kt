package com.rojer_ko.stationsscreen.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rojer_ko.core.di.ViewModelFactory
import com.rojer_ko.core.di.ViewModelKey
import com.rojer_ko.stationsscreen.ui.StationsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class StationsModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(StationsViewModel::class)
    abstract fun stationsViewModel(viewModel: StationsViewModel): ViewModel
}