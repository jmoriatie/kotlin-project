package com.comento.jpa.presentation

import com.comento.jpa.service.CompanyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/companies")
class CompanyController(
    private val service: CompanyService
) {

    @GetMapping("/country/{countryName}")
    fun findByCountryName(@PathVariable countryName: String)= service.findByCountryName(countryName)
}
