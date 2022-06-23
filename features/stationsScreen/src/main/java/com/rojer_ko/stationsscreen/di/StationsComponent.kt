package com.rojer_ko.stationsscreen.di

import com.rojer_ko.stationsscreen.ui.StationsFragment
import dagger.Component
import javax.inject.Singleton

@[
Singleton
Component(dependencies = [StationsDeps::class])
]
internal interface StationsComponent {

    fun inject(fragment: StationsFragment)

    @Component.Builder
    interface Builder {

        fun deps(deps: StationsDeps): Builder
        fun build(): StationsComponent
    }
}