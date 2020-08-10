package com.monro.blog.domain

import com.monro.shared.src.domain.AggregateRoot
import com.monro.shared.src.domain.format
import com.monro.shared.src.domain.toSlug
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Article(
    @Id final var id: String,
    final var title: String,
    final var headline: String,
    final var content: String,
    @ManyToOne final var category: Category,
    final var slug: String = title.toSlug(),
    final var publishedAt: LocalDateTime? = null
) : AggregateRoot() {
    private var status = ArticleStatus.DRAFT

    init {
        if (publishedAt !== null) {
            status = ArticleStatus.PUBLISHED
        }
        registerEvent(
            ArticleCreatedEvent(
                id,
                title,
                headline,
                content,
                slug,
                category.id,
                status.toString(),
                publishedAt?.format()
            )
        )
    }

    fun publish() {
        status = ArticleStatus.PUBLISHED
        if (publishedAt === null) {
            publishedAt = LocalDateTime.now()
        }
        registerEvent(ArticlePublishedEvent(id))
    }

    fun fullSlug() = category.slug + "/" + slug;

    fun isPublished() = status == ArticleStatus.PUBLISHED
}

enum class ArticleStatus {
    DRAFT,
    PUBLISHED
}