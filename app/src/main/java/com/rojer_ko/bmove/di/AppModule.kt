package com.rojer_ko.bmove.di

import com.rojer_ko.core.repo.StationsRepository
import com.rojer_ko.repository.StationsRepositoryImpl
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
    fun provideStationsRepo(httpClient: HttpClient): StationsRepository = StationsRepositoryImpl(httpClient)

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
}