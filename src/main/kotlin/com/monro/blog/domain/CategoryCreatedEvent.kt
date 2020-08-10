package com.monro.blog.domain

import com.monro.shared.src.domain.DomainEvent

class CategoryCreatedEvent(
    categoryId: String,
    name: String,
    slug: String
) : DomainEvent(categoryId, hashMapOf("name" to name, "slug" to slug)) {
}