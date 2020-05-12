package com.itmo.mpa.service.mapping

import com.itmo.mpa.dto.response.ScaleTypeResponse
import com.itmo.mpa.entity.ScaleType

fun ScaleType.toResponse() = ScaleTypeResponse (
        id = this.id,
        name = this.name,
        namesFromScale = this.names_from_scale.asList()
)
