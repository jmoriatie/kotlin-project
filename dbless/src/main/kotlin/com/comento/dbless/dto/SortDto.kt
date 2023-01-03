package com.comento.dbless.dto

import com.comento.dbless.domain.Person

data class SortDto(
    val persons : MutableList<PersonDto>,
    val sortBy : String,
    val sortOrder : String
)
