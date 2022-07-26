package com.rojer_ko.stationdetailscreen.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rojer_ko.core.di.ViewModelKey
import com.rojer_ko.stationdetailscreen.ui.StationDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class StationDetailsModule {

    @StationDetailsScope
    @Binds
    abstract fun bindViewModelFactory(factory: StationDetailsViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(StationDetailViewModel::class)
    abstract fun stationDetailsViewModel(viewModel: StationDetailViewModel): ViewModel
}