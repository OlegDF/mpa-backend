package com.itmo.mpa.dto.response

data class AdrResponse(
    val id: Long,
    val name: String,
    val frequencyOfOccurence: Long,
    var theSeverityOfTheClinicalCourse: Long,
    var scaleTypeForTheSeverityOfTheClinicalCourse: ScaleTypeResponse,
    var scaleTypeForOccurenceFrequency: ScaleTypeResponse,
    var activeSubstances: List<String>
)
