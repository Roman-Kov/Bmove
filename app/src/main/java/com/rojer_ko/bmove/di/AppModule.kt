package com.rojer_ko.bmove.di

import android.app.Application
import android.content.Context
import com.rojer_ko.core.repo.StationsRepository
import com.rojer_ko.repository.StationsRepositoryImpl
import com.rojer_ko.repository.db.StationsDb
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json

@Module
class AppModule {

    @AppScope
    @Provides
    fun context(appInstance: Application): Context = appInstance

    @AppScope
    @Provides
    fun provideStationsRepo(
        httpClient: HttpClient,
        stationsDb: StationsDb
    ): StationsRepository = StationsRepositoryImpl(httpClient, stationsDb)

    @AppScope
    @Provides
    fun provideHttpClient(): HttpClient = HttpClient(Android) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })

            engine {
                connectTimeout = 30_000
                socketTimeout = 30_000
            }
        }
    }

    @AppScope
    @Provides
    fun provideDb(context: Context): StationsDb = StationsDb.createDb(context)
}