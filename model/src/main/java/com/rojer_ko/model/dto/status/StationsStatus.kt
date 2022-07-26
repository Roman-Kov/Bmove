package com.rojer_ko.model.dto.status

import kotlinx.serialization.Serializable

@Serializable
data class StationsStatus (

	val station_id : Int,
	val num_bikes_available : Int,
	val num_bikes_available_types : BikesAvailableTypes,
	val num_docks_available : Int,
	val last_reported : Long,
	val is_charging_station : Boolean,
	val status : String,
	val is_installed : Int,
	val is_renting : Int,
	val is_returning : Int,
	val traffic : String?
)