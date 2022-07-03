package com.rojer_ko.model

import kotlinx.serialization.Serializable

@Serializable
data class Stations (

	val station_id : Int,
	val name : String,
	val physical_configuration : String,
	val lat : Double,
	val lon : Double,
	val altitude : Int,
	val address : String,
	val post_code : Int,
	val capacity : Int,
	val is_charging_station : Boolean,
	val nearby_distance : Int
)