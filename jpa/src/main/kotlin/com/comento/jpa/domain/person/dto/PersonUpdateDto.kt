package com.comento.jpa.domain.person.dto

data class PersonUpdateDto(
    val personId: Int,
    val age: Int? = null,
    val height: Int? = null,
    val weight: Int? = null,
    val gender: Gender? = Gender.UNKNOWN,
    val isMarried: Boolean? = null,
    val company: String? = null,
    val country: String
) {

    constructor(personUpdateDto: PersonUpdateDto) : this(
        personId = personUpdateDto.personId,
        age = personUpdateDto.age,
        height = personUpdateDto.height,
        weight = personUpdateDto.weight,
        gender = personUpdateDto.gender,
        isMarried = personUpdateDto.isMarried,
        company = personUpdateDto.company,
        country = personUpdateDto.country.uppercase().trim()
    )
}
