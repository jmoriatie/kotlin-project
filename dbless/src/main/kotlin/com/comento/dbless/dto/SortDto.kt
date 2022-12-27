package com.comento.dbless.dto

class SortDto {
    lateinit var persons : MutableList<PersonDto>
    lateinit var sortBy : String
    lateinit var sortOrder : String
}
