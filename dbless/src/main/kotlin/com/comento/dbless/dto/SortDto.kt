package com.comento.dbless.dto

import com.comento.dbless.domain.Person
import org.springframework.validation.annotation.Validated
import javax.validation.Valid
import javax.validation.constraints.NotNull

data class SortDto(
    @field:Valid
    val persons : MutableList<PersonDto>,
    val sortBy : String,
    val sortOrder : String
)
