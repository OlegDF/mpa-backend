package com.itmo.mpa.service.exception

class AdrNotFoundException(id: Long) : NotFoundException("ADR not found: $id")
