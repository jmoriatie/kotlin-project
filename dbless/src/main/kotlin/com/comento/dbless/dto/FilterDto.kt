package com.comento.dbless.dto

import javax.validation.constraints.NotNull

// data class 로 변경
// val로 작성
data class FilterDto(
    @field:NotNull
    val persons : List<PersonDto>,
    val ageCutoff : Int? = null,
    val heightCutoff : Int? = null,
    val except : MutableList<String>? = null
)
