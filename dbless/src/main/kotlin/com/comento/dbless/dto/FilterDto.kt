package com.comento.dbless.dto

class FilterDto {
    lateinit var persons : MutableList<PersonDto>
    var ageCutoff : Int? = null
    var heightCutoff : Int? = null
    var except : MutableList<String>? = null
}
