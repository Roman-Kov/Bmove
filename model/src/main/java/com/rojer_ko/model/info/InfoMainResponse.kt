package com.rojer_ko.model.info

import kotlinx.serialization.Serializable

@Serializable
data class InfoMainResponse (

	val last_updated : Int,
	val ttl : Int,
	val data : InfoData
)