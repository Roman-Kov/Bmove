package com.rojer_ko.bmove

import android.app.Application
import android.content.Context
import com.rojer_ko.bmove.di.AppComponent
import com.rojer_ko.bmove.di.AppDeps
import com.rojer_ko.bmove.di.DaggerAppComponent
import com.rojer_ko.stationdetailscreen.di.StationDetailsDepsStore
import com.rojer_ko.stationsscreen.di.StationsDepsStore

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .application(this)
            .appDeps(AppDepsImpl())
            .build()

        StationsDepsStore.deps = appComponent
        StationDetailsDepsStore.deps = appComponent
    }

    private inner class AppDepsImpl : AppDeps {

        override val context: Context = this@App
    }

    companion object {

        lateinit var appComponent: AppComponent
            private set
    }
}