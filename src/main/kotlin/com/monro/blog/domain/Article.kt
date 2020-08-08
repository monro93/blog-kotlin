package com.monro.blog.domain

import com.monro.shared.src.domain.AggregateRoot
import com.monro.shared.src.domain.toSlug
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Article(
    @Id var id: String,
    var title: String,
    var content: String,
    var slug: String = title.toSlug(),
    var createdAt: LocalDateTime = LocalDateTime.now()
) : AggregateRoot() {
    private var status = ArticleStatus.DRAFT
    private var publishedAt: LocalDateTime? = null

    fun publish() {
        status = ArticleStatus.PUBLISHED
        if (publishedAt === null) {
            publishedAt = LocalDateTime.now()
        }
        registerEvent(ArticlePublishedEvent(id))
    }

    fun isPublished() = status == ArticleStatus.PUBLISHED

    fun getPublishedAt(): LocalDateTime? = publishedAt

}

enum class ArticleStatus {
    DRAFT,
    PUBLISHED
}