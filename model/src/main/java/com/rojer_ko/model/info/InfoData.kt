package com.rojer_ko.model.info

import kotlinx.serialization.Serializable

@Serializable
data class InfoData (

	val stations : List<StationsInfo>
)