package com.itmo.mpa.repository

import com.itmo.mpa.entity.Adr
import org.springframework.data.repository.CrudRepository

interface AdrRepository : CrudRepository<Adr, Long>