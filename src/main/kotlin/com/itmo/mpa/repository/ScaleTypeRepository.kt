package com.itmo.mpa.repository

import com.itmo.mpa.entity.Adr
import com.itmo.mpa.entity.ScaleType
import org.springframework.data.repository.CrudRepository

interface ScaleTypeRepository : CrudRepository<ScaleType, Long>