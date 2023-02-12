package com.comento.jpa.domain.item

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity(name ="movie")
@DiscriminatorValue("1") // Item 객체 kind에 들어갈 값
class Movie(
    name: String,
    actor: String,
    director: String
) : Item(name) {

    @Column(name = "actor", nullable = false, updatable = false)
    val actor: String = actor

    @Column(name = "director", nullable = false, updatable = false)
    val director: String = director
}
