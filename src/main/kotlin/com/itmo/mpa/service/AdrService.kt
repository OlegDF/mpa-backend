package com.itmo.mpa.service

import com.itmo.mpa.dto.response.AdrResponse

interface AdrService {

    fun findAll(): List<AdrResponse>

    fun findById(id: Long): AdrResponse

    fun findByMedicineId(id: Long): List<AdrResponse>

}
