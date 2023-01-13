package com.comento.jpa.presentation

import com.comento.jpa.domain.person.dto.BlindDateDto
import com.comento.jpa.domain.person.dto.PersonDto
import com.comento.jpa.domain.person.dto.PersonResponse
import com.comento.jpa.exception.custom_exceptions.CustomEmptyResultDataAccessException
import com.comento.jpa.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/persons")
class PersonController(
    private val service: PersonService
) {
    @GetMapping
    fun findAll() = service.findAll()

    @PostMapping("/{personId}")
    fun findById(@PathVariable personId: Long) = service.findByPersonId(personId)

    @PostMapping
    fun save(@RequestBody personDtoList: List<PersonDto>): PersonResponse = service.save(personDtoList)

    @PutMapping
    fun update(@RequestBody personDtoList: List<PersonDto>): PersonResponse = service.update(personDtoList)

    @GetMapping("blind-date/{ageDiff}")
    fun coupleMatching(@PathVariable ageDiff: Int,
                       @RequestParam(defaultValue = "") country: String): List<Pair<BlindDateDto, BlindDateDto>> { // TODO: country nullable 로 변경
        val mathchCouples = service.mathchCouples(ageDiff, country)
        return if(!mathchCouples.isEmpty()){
            mathchCouples
        }else {
            throw CustomEmptyResultDataAccessException()
        }
    }
}
