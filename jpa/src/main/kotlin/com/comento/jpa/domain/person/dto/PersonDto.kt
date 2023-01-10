package com.comento.jpa.domain.person.dto

data class PersonDto(
    val personId: Int,
    val name: String,
    val country: String,
    val age: Int?,
    val height: Int?,
    val weight: Int?,
    val gender: String,
    val isMarried: Boolean?,
    val company: String?
) {

    constructor(dto: PersonDto) : this(
        personId = dto.personId,
        name = dto.name,
        country = dto.country.uppercase().trim(),
        age = dto.age,
        height = dto.height,
        weight = dto.weight,
        gender = dto.gender,
        isMarried = dto.isMarried,
        company = dto.company
    )
}
