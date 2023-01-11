package com.comento.dbless.dto

import javax.validation.Valid

data class SortDto(
    @field:Valid
    val persons : MutableList<PersonDto>,
    val sortBy : String,
    val sortOrder : String
)
