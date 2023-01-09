package com.comento.jpa.presentation

import com.comento.jpa.domain.country.Country
import com.comento.jpa.domain.country.CountryRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/countries")
class CountryController(val repo: CountryRepository) {

    @GetMapping("/all")
    fun findAll(): ResponseEntity<MutableIterable<Country>> = ResponseEntity.ok().body( repo.findAll() )

    // TODO: Valid 붙이기
    @GetMapping("/{countryName}/capital-city")
    fun findByCountryName(@PathVariable countryName: String): ResponseEntity<Country>{
        return ResponseEntity.ok().body(repo.findByName(countryName.uppercase().trim()))
    }
}
