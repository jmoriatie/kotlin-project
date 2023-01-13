package com.comento.jpa.service

import com.comento.jpa.domain.country.Country
import com.comento.jpa.domain.country.CountryRepository
import com.comento.jpa.exception.custom_exceptions.CustomEmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class CountryService(
    private val repo: CountryRepository
) {
    fun findAll(): MutableIterable<Country> = repo.findAll()

    // 값이 없을 수 있음
    fun findByName(countryName: String): Country = repo.findByName(countryName.uppercase().trim()) ?: throw CustomEmptyResultDataAccessException()
}
