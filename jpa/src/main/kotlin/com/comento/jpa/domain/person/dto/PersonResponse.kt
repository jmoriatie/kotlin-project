package com.comento.jpa.domain.person.dto

class PersonResponse(
    val resultTypes: MutableList<Long> = mutableListOf(),
    val personIds: MutableList<Long> = mutableListOf()
){
    fun addResultTypes(result: Long) = this.resultTypes.add(result)
    fun addPersonIds(result: Long) = this.personIds.add(result)
}
