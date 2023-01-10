package com.comento.dbless.dto

<<<<<<< HEAD
class SortDto(
=======
import com.comento.dbless.domain.Person
import org.springframework.validation.annotation.Validated
import javax.validation.Valid
import javax.validation.constraints.NotNull

data class SortDto(
    @field:Valid
>>>>>>> main
    val persons : MutableList<PersonDto>,
    val sortBy : String,
    val sortOrder : String
)
