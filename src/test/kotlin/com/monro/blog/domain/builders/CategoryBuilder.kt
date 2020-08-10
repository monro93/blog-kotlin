package com.monro.blog.domain.builders

import com.monro.blog.domain.Category
import com.monro.shared.src.domain.generateAggregateRootId

class CategoryBuilder {
    private var id: String = generateAggregateRootId()
    private var name: String = "A category"
    private var slug: String = "a-category"

    fun withId(id: String) = apply { this.id = id }
    fun withName(name: String) = apply { this.name = name }
    fun withSlug(slug: String) = apply { this.slug = slug }

    fun build(clearEvents: Boolean = true): Category {
        val category = Category(
            id,
            name,
            slug
        )

        if(clearEvents) {
            category.pullDomainEvents()
        }

        return category
    }
}