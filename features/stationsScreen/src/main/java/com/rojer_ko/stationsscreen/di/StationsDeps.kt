package com.rojer_ko.stationsscreen.di

import com.rojer_ko.core.navigator.Navigator
import com.rojer_ko.core.repo.StationsRepository

interface StationsDeps {

    val stationsRepo: StationsRepository
    val navigator: Navigator
}