package com.rojer_ko.model.info

import kotlinx.serialization.Serializable

@Serializable
data class StationsInfo (

	val station_id : Int,
	val name : String,
	val physical_configuration : String,
	val lat : Float,
	val lon : Float,
	val altitude : Float,
	val address : String,
	val post_code : Int,
	val capacity : Int,
	val is_charging_station : Boolean,
	val nearby_distance : Float
)