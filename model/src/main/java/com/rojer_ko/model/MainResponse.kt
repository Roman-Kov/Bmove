package com.rojer_ko.model

import kotlinx.serialization.Serializable

@Serializable
data class MainResponse (

	val last_updated : Int,
	val ttl : Int,
	val data : Data
)