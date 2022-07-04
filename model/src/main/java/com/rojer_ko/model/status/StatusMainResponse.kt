package com.rojer_ko.model.status

import kotlinx.serialization.Serializable

@Serializable
data class StatusMainResponse(
    val last_updated: Int,
    val ttl: Int,
    val data: StatusData
)