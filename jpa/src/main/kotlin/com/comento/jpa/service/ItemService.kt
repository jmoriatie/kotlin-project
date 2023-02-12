package com.comento.jpa.service

import com.comento.jpa.domain.item.Item
import com.comento.jpa.domain.item.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val repo: ItemRepository
    ) {
    fun findAll(): MutableIterable<Item> = repo.findAll()
}
