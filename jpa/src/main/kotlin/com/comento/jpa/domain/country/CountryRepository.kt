package com.comento.jpa.domain.country

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryRepository: CrudRepository<Country, Long?> {

    // 값이 없을 수 있음
    fun findByName(name: String): Country?
}
