package com.comento.jpa.domain.person.dto

data class PersonSaveDto(
    val personId: Int,
    val name: String,
    val country: String,
    val age: Int?,
    val height: Int?,
    val weight: Int?,
    val gender: Gender,
    val isMarried: Boolean?,
    val company: String?
) {

    constructor(personSaveDto: PersonSaveDto) : this(
        personId = personSaveDto.personId,
        name = personSaveDto.name,
        country = personSaveDto.country.uppercase().trim(),
        age = personSaveDto.age,
        height = personSaveDto.height,
        weight = personSaveDto.weight,
        gender = personSaveDto.gender,
        isMarried = personSaveDto.isMarried,
        company = personSaveDto.company
    )
}
