package com.monro.blog.domain

import com.monro.shared.src.domain.generateAggregateRootId
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CategoryTest() {

    @Test
    fun `Can create a Category`() {
        val category = Category(
            generateAggregateRootId(),
            "Test Category"
        )
        val events = category.pullDomainEvents()
        Assertions.assertThat(events).hasSize(1)
        assert(events.first() is CategoryCreatedEvent)
    }
}