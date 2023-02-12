package com.comento.jpa.domain.person.dto

import com.comento.jpa.domain.company.Company
import com.comento.jpa.domain.person.Person
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class BlindDateDto(
    val name: String,
    val gender: Gender,
    val age: Int,
    val height: Int?,
    val weight: Int?,
    val company: MutableList<Company>?,
    val country: String
){

    companion object{
        fun from(person: Person): BlindDateDto =
            BlindDateDto(
                person.name,
                person.gender ?: Gender.UNKNOWN,
                person.age ?: 0,
                person.height,
                person.weight,
                person.company,
                person.country
            )
    }
}
