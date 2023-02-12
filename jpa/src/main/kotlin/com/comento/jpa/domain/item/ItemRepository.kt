package com.comento.jpa.domain.item

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository: CrudRepository<Item, Int> {
}
