package com.comento.jpa.repository

import com.comento.jpa.domain.item.Album
import com.comento.jpa.domain.item.Etc
import com.comento.jpa.domain.item.ItemRepository
import com.comento.jpa.domain.item.Movie
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    lateinit var itemRepository: ItemRepository

    @Test
    @DisplayName("ItemRepository save test")
    fun save(){
        //given
        val testMovie: Movie = Movie("Test Movice", "TestActor", "Test Director")
        val testAlbum: Album = Album("TEST ONE", "Test artist")
        val testEtcItem: Etc = Etc("TEST Etc")

        //when
        val savedMovie = itemRepository.save(testMovie)
        val savedAlbum = itemRepository.save(testAlbum)
        val savedEtcItem = itemRepository.save(testEtcItem)

        savedEtcItem.description = "TEST ETC Item 입니다" // set test

        //then
        savedMovie.actor shouldBe "TestActor"
        savedAlbum.artist shouldBe "Test artist"
        savedEtcItem.name shouldBe "TEST Etc"
        savedEtcItem.description shouldBe "TEST ETC Item 입니다"
    }

    @Test
    fun findById(){
        val findItem = itemRepository.findById(1).get()
        println( "findItem: id=${findItem.id} / name=${findItem.name} / description=${findItem.description} ")
        findItem.id shouldBe 1
    }
}
