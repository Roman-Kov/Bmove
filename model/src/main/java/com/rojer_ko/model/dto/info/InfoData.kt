package com.rojer_ko.model.dto.info

import kotlinx.serialization.Serializable

@Serializable
data class InfoData (

	val stations : List<StationsInfo>
)