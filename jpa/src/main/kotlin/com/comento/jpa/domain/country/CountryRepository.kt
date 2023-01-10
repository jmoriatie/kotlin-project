package com.comento.jpa.domain.country

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryRepository: CrudRepository<Country, Long?> {

    fun findByName(name: String): Country
}
