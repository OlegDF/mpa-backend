package com.itmo.mpa.controller

import com.itmo.mpa.dto.response.AdrResponse
import com.itmo.mpa.service.AdrService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@Api("/adrs")
@RequestMapping("adrs")
class AdrController(private val adrService: AdrService) {

    @GetMapping
    @ApiOperation("Get all ADRs")
    fun getAllAdrs(): List<AdrResponse> = adrService.findAll()

    @GetMapping("{id}")
    @ApiOperation("Get ADR by id")
    fun getAdrById(
            @PathVariable id: Long
    ): AdrResponse = adrService.findById(id)

    @GetMapping("adrs_by_medicine/{id}")
    @ApiOperation("Find ADRs that match with a medicine id")
    fun getAdrsByMedicineId(
            @PathVariable id: Long
    ): List<AdrResponse> = adrService.findByMedicineId(id)
}
