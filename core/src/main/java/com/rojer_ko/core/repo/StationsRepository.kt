package com.rojer_ko.core.repo

interface StationsRepository {

   suspend fun getStations(): List<Any>
   suspend fun getStationDetails(id: Int): Any
}