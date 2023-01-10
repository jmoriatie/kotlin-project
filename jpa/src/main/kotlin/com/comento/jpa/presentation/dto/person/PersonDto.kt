package com.comento.jpa.presentation.dto.person

data class PersonDto (
    val personId: Int?,
    val age: Int?,
    val height: Int?,
    val weight: Int?,
    val name: String,
    val gender: String?,
    val isMarried: Boolean?,
    val company: String?,
    val country: String
    )
