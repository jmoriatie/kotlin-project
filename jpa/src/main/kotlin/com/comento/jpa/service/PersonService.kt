package com.comento.jpa.service

import com.comento.jpa.domain.person.Person
import com.comento.jpa.domain.person.PersonRepository
import com.comento.jpa.domain.person.dto.BlindDateDto
import com.comento.jpa.domain.person.dto.Gender
import com.comento.jpa.domain.person.dto.PersonDto
import com.comento.jpa.domain.person.dto.PersonResponse
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PersonService(
    private val repo: PersonRepository
) {

    @Transactional
    fun save(personDtoList: List<PersonDto>): PersonResponse {
        return makePersonResponse(personDtoList)
    }

    /**
     * 저장, 수정 시 PersonResponse 객체 반환
     */
    private fun makePersonResponse (
        personDtoList: List<PersonDto>
    ): PersonResponse {
        val response = PersonResponse()
        personDtoList.forEach {
            when (repo.existsById(it.personId)) {
                false -> response.addResultTypes(1)
                true -> response.addResultTypes(0)
            }
            response.addPersonIds(repo.save(Person.from(it)).personId ?: 0L)
        }
        return response
    }

    fun findAll(): Iterable<Person> = repo.findAll()
    fun findByPersonId(personId: Long): Person = repo.findByPersonId(personId)
    fun update(personDtoList: List<PersonDto>): PersonResponse = this.save(personDtoList)

    fun mathchCouples(ageDiff: Int, country: String): List<Pair<BlindDateDto, BlindDateDto>> {
        val (males: List<Person>, females: List<Person>) = findPersons(country)
        return filteringCouples(ageDiff, males, females)
    }

    /**
     * 남, 녀 리스트 추출
     */
    private fun findPersons(country: String): Pair<List<Person>, List<Person>> {
        val males: List<Person>
        val females: List<Person>
        when (country == "") {
            true -> {
                males = repo.findByGenderAndAgeIsNotNull(Gender.MALE)
                females = repo.findByGenderAndAgeIsNotNull(Gender.FEMALE)
            }
            false -> {
                males = repo.findByGenderAndCountryAndAgeIsNotNull(Gender.MALE, country)
                females = repo.findByGenderAndCountryAndAgeIsNotNull(Gender.FEMALE, country)
            }
        }
        return Pair(males, females)
    }

    /**
     * 커플 리스트 반환
     */
    private fun filteringCouples(ageDiff: Int, males: List<Person>, females: List<Person>): List<Pair<BlindDateDto, BlindDateDto>> {
        val coupleList: MutableList<Pair<BlindDateDto, BlindDateDto>> = mutableListOf()

        for (male in males) {
            val maleAge = male.age ?: 0
            val before = male.age?.minus(ageDiff) ?: 0
            val after = male.age?.plus(ageDiff) ?: 0
            val country = male.country

            females.filter { (before <= (it.age ?: 0) && (it.age ?: 0) <= after) && country == it.country}
                .forEach {
                    when {
                        ((it.age ?: 0) < (maleAge)) || ((it.age ?: 0) == (maleAge)) -> coupleList.add(
                            Pair(BlindDateDto.from(male), BlindDateDto.from(it))
                        )
                        else -> coupleList.add(
                            Pair(BlindDateDto.from(it), BlindDateDto.from(male))
                        )
                    }
                }
        }
        return coupleList
    }
}
