package com.comento.jpa.domain.company

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository: CrudRepository<Company, Long>{

    fun findByCountry(countryName: String): List<Company>
}
