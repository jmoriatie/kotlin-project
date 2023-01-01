package com.comento.dbless.dto

// data class 로 변경
// val로 작성
data class FilterDto(
    val persons : MutableList<PersonDto>,
    val ageCutoff : Int? = null,
    val heightCutoff : Int? = null,
    val except : MutableList<String>? = null
)
