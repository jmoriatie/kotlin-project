package com.comento.jpa.service

import com.comento.jpa.domain.company.Company
import com.comento.jpa.domain.company.CompanyRepository
import com.comento.jpa.exception.custom_exceptions.CustomEmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class CompanyService(
    private val repo: CompanyRepository
) {
    fun findByCountryName(countryName: String): List<Company> {
        val countries = repo.findByCountry(countryName.uppercase().trim())
        if(countries.isEmpty()) throw CustomEmptyResultDataAccessException()
        return countries
    }
}
