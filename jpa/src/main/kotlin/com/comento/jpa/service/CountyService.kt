package com.comento.jpa.service

import com.comento.jpa.domain.country.CountryRepository
import org.springframework.stereotype.Service

@Service
class CountyService(
    private val countryRepository: CountryRepository
) {

}
