package com.comento.jpa.service

import com.comento.jpa.domain.country.Country
import com.comento.jpa.domain.country.CountryRepository
import org.springframework.stereotype.Service

@Service
class CountryService(
    private val repo: CountryRepository
) {
    fun findAll(): MutableIterable<Country> = repo.findAll()
    fun findByName(countryName: String): Country = repo.findByName(countryName.uppercase().trim())
}
