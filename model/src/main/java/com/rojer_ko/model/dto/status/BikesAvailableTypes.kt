package com.rojer_ko.model.dto.status

import kotlinx.serialization.Serializable

@Serializable
data class BikesAvailableTypes (

	val mechanical : Int,
	val ebike : Int
)