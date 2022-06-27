package com.rojer_ko.stationsscreen.di

import com.rojer_ko.stationsscreen.ui.StationsFragment
import dagger.Component
import javax.inject.Scope
import javax.inject.Singleton

@Scope
annotation class StationsScope
@[
StationsScope
Component(dependencies = [StationsDeps::class])
]
interface StationsComponent {

    fun inject(fragment: StationsFragment)

    @Component.Builder
    interface Builder {

        fun deps(deps: StationsDeps): Builder
        fun build(): StationsComponent
    }
}