package com.rojer_ko.model.status

import kotlinx.serialization.Serializable

@Serializable
data class StatusData (

	val stations : List<StationsStatus>
)