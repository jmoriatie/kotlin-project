package com.comento.dbless.domain

import com.comento.dbless.dto.PersonDto
import javax.validation.constraints.*

<<<<<<< HEAD
class Person private constructor(val id : String) {
    val name : String
        get() = this._name
    val age : Int
        get() = this.age
    val height : Int
        get() = this._height

    var _name : String = ""
    var _age : Int = -1
    var _height : Int = -1
=======
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
>>>>>>> main

    companion object{
        fun from(id : String,
                 name : String,
                 age : Int,
                 height : Int): Person{
            val newPerson = Person(id)
            newPerson._name = name
            newPerson._age = age
            newPerson._height = height
            return newPerson
        }

        fun of(personDto : PersonDto) : Person{
            val newPerson = Person(personDto.id)
            newPerson._name = personDto.name
            newPerson._age = personDto.age
            newPerson._height = personDto.height
            return newPerson
        }
    }
}
