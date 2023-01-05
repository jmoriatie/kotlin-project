package com.comento.dbless.domain

import com.comento.dbless.dto.PersonDto
import javax.validation.constraints.*

class Person private constructor(
    @field:NotBlank val id : String
) {
    @field:NotBlank
    var name : String = ""

    @field:Min(0)
    @field:Max(100)
    var age : Int = -1

    @field:Min(0)
    @field:Max(300)
    var height : Int = -1

    companion object{
        fun from(id : String,
                 name : String,
                 age : Int,
                 height : Int): Person{
            val newPerson = Person(id)
            newPerson.name = name
            newPerson.age = age
            newPerson.height = height
            return newPerson
        }

        fun of(personDto : PersonDto) : Person{
            val newPerson = Person(personDto.id)
            newPerson.name = personDto.name
            newPerson.age = personDto.age
            newPerson.height = personDto.height
            return newPerson
        }
    }
}
