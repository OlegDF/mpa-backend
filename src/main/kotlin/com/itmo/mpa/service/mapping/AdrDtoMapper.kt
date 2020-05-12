package com.itmo.mpa.service.mapping

import com.itmo.mpa.dto.response.AdrResponse
import com.itmo.mpa.entity.Adr

fun Adr.toResponse() = AdrResponse(
        id = this.id,
        name = this.name,
        frequencyOfOccurence = this.frequency_of_occurence,
        theSeverityOfTheClinicalCourse = this.the_severity_of_the_clinical_course,
        scaleTypeForTheSeverityOfTheClinicalCourse = this.scale_type_for_the_severity_of_the_clinical_course.toResponse(),
        scaleTypeForOccurenceFrequency = this.scale_type_for_occurence_frequency.toResponse(),
        activeSubstances = this.activeSubstances.map { it.name }
)

fun Adr.toResponse(actSub: List<String>) = AdrResponse(
        id = this.id,
        name = this.name,
        frequencyOfOccurence = this.frequency_of_occurence,
        theSeverityOfTheClinicalCourse = this.the_severity_of_the_clinical_course,
        scaleTypeForTheSeverityOfTheClinicalCourse = this.scale_type_for_the_severity_of_the_clinical_course.toResponse(),
        scaleTypeForOccurenceFrequency = this.scale_type_for_occurence_frequency.toResponse(),
        activeSubstances = actSub
)
