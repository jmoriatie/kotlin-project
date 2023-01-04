package com.comento.dbless.dto

import com.comento.dbless.domain.Person
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PersonDto(
    @field:NotBlank
    val id : String,

    @field:NotBlank
    val name : String,

    @field:Min(0)
    @field:Max(100)
    val age : Int,

    @field:Min(0)
    @field:Max(300)
    val height : Int) {

    companion object{
        fun of(id : String,
               name : String,
               age : Int,
               height : Int) : PersonDto{
            val person = Person.from(id, name, age, height)
            return PersonDto.from(person)
        }

        fun from(person : Person) : PersonDto = PersonDto(person.id, person.name, person.age, person.height)
    }
}
