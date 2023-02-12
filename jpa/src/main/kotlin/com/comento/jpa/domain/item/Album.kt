package com.comento.jpa.domain.item

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity(name = "album")
@DiscriminatorValue("2")
class Album(
    name: String,
    artist: String
): Item(name){
    @Column(name="artist", nullable = false, updatable = false)
    val artist : String = artist
}
