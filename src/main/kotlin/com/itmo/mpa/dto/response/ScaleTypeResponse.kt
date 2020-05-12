package com.itmo.mpa.dto.response

data class ScaleTypeResponse(
    val id: Long,
    val name: String,
    val namesFromScale: List<String>
)
