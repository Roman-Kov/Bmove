package com.rojer_ko.stationsscreen.di

import androidx.lifecycle.ViewModel
import com.rojer_ko.core.di.ViewModelFactory
import javax.inject.Inject
import javax.inject.Provider

class StationsViewModelFactory @Inject constructor(viewModels: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelFactory(viewModels)