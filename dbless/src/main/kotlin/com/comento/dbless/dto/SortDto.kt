package com.comento.dbless.dto

class SortDto(
    val persons : MutableList<PersonDto>,
    val sortBy : String,
    val sortOrder : String
)
