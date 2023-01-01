package com.comento.dbless.dto

data class FilterDto(
    var persons : MutableList<PersonDto>,
    var ageCutoff : Int? = null,
    var heightCutoff : Int? = null,
    var except : MutableList<String>? = null
)
