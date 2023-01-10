package com.comento.jpa.presentation

import com.comento.jpa.domain.country.Country
import com.comento.jpa.domain.country.CountryRepository
import com.comento.jpa.service.CountryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/countries")
class CountryController(
    private val service: CountryService
    ) {

    @GetMapping("/all")
    fun findAll(): ResponseEntity<MutableIterable<Country>> = ResponseEntity.ok().body( service.findAll() )

    // TODO: Valid 붙이기
    @GetMapping("/{countryName}/capital-city")
    fun findByCountryName(@PathVariable countryName: String): ResponseEntity<Country>{
        return ResponseEntity.ok().body(service.findByName(countryName))
    }
}
