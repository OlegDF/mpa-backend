package com.itmo.mpa.service.impl;

import com.itmo.mpa.dto.response.AdrResponse
import com.itmo.mpa.dto.response.ScaleTypeResponse
import com.itmo.mpa.entity.Adr
import com.itmo.mpa.entity.medicine.ActiveSubstance
import com.itmo.mpa.repository.AdrRepository
import com.itmo.mpa.repository.MedicineRepository
import com.itmo.mpa.repository.ScaleTypeRepository
import com.itmo.mpa.service.AdrService
import com.itmo.mpa.service.exception.AdrNotFoundException
import com.itmo.mpa.service.exception.MedicineNotFoundException
import com.itmo.mpa.service.mapping.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AdrServiceImpl(
        private val adrRepository: AdrRepository,
        private val medicineRepository: MedicineRepository
) : AdrService {

    override fun findAll(): List<AdrResponse> {
        val responses = mutableListOf<AdrResponse>()
        for(adr in adrRepository.findAll()) {
            responses.add(adr.toResponse())
        }
        return responses.toList()
    }

    override fun findById(id: Long): AdrResponse {
        return (adrRepository.findByIdOrNull(id) ?: throw AdrNotFoundException(id)).toResponse()
    }

    override fun findByMedicineId(id: Long): List<AdrResponse> {
        val responses = mutableListOf<AdrResponse>()
        val medicine = medicineRepository.findByIdOrNull(id) ?: throw MedicineNotFoundException(id)
        val medicineSubstances = medicine.activeSubstance
        for(adr in adrRepository.findAll()) {
            val intersectSub = medicineSubstances.intersect(adr.activeSubstances)
            if(intersectSub.isNotEmpty()) {
                responses.add(adr.toResponse(intersectSub.map { it.name }))
            }
        }
        return responses.toList()
    }

}
