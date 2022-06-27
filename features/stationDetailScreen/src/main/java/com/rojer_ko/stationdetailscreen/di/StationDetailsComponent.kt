package com.rojer_ko.stationdetailscreen.di

import com.rojer_ko.stationdetailscreen.ui.StationDetailsFragment
import dagger.Component
import javax.inject.Scope
import javax.inject.Singleton

@Scope
annotation class StationDetailsScope
@[
StationDetailsScope
Component(dependencies = [StationDetailsDeps::class])
]
internal interface StationDetailsComponent {

    fun inject(fragment: StationDetailsFragment)

    @Component.Builder
    interface Builder {

        fun deps(deps: StationDetailsDeps): Builder
        fun build(): StationDetailsComponent
    }
}