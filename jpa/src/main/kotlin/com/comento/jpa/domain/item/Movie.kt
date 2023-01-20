package com.comento.jpa.domain.item

import javax.persistence.Entity

@Entity
class Movie(
    actor: String,
    director: String
) : Item() {

    val actor: String = actor
    val director: String = director
}
