package com.rojer_ko.bmove.di

import android.app.Application
import com.rojer_ko.bmove.MainActivity
import com.rojer_ko.core.navigator.Navigator
import com.rojer_ko.core.repo.StationsRepository
import com.rojer_ko.stationdetailscreen.di.StationDetailsDeps
import com.rojer_ko.stationsscreen.di.StationsDeps
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@Scope
annotation class AppScope

@[
AppScope
Component(modules = [AppModule::class])
]
interface AppComponent : StationDetailsDeps, StationsDeps {

    override val stationsRepo: StationsRepository
    override val navigator: Navigator

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun appDeps(appDeps: AppDeps): Builder
        fun build(): AppComponent
    }
}