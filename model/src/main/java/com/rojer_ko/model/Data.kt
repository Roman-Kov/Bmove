package com.rojer_ko.model

import kotlinx.serialization.Serializable

@Serializable
data class Data (

	val stations : List<Stations>
)