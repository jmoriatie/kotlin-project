package com.comento.dbless.dto

data class SortDto(
    val persons : MutableList<PersonDto>,
    val sortBy : String,
    val sortOrder : String
)
