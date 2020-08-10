package com.monro.blog.domain

import com.monro.shared.src.domain.AggregateRoot
import com.monro.shared.src.domain.toSlug
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Category(
    @Id final var id: String,
    final var name: String,
    final var slug: String = name.toSlug()
) : AggregateRoot() {
    @OneToMany(mappedBy = "category")
    private var articles: MutableList<Article> = ArrayList()

    init {
        registerEvent(CategoryCreatedEvent(id, name, slug))
    }
}