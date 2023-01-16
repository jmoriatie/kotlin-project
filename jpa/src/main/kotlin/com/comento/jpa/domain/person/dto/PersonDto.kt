package com.comento.jpa.domain.person.dto

import com.comento.jpa.domain.company.Company
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class PersonDto(
    val personId: Long,
    val name: String,
    val country: String,
    val age: Int?,
    val height: Int?,
    val weight: Int?,
    val gender: Gender?,
    val isMarried: Boolean?,
    val company: MutableList<Company>?
) {
    constructor(dto: PersonDto) : this(
        personId = dto.personId,
        name = dto.name,
        country = dto.country,
        age = dto.age,
        height = dto.height,
        weight = dto.weight,
        gender = dto.gender,
        isMarried = dto.isMarried,
        company = dto.company
    )
}
