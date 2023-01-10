package com.comento.jpa.domain.person.dto

class PersonResponse(
    val resultTypes: MutableList<Int> = mutableListOf(),
    val personIds: MutableList<Int> = mutableListOf()
){
    fun addResultTypes(result: Int) = this.resultTypes.add(result)
    fun addPersonIds(result: Int) = this.personIds.add(result)
}
