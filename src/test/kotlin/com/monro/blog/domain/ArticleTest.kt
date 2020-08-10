package com.monro.blog.domain

import com.monro.blog.domain.builders.CategoryBuilder
import org.assertj.core.api.Assertions.assertThat
import com.monro.shared.src.domain.generateAggregateRootId
import org.junit.jupiter.api.Test

class ArticleTest() {

    @Test
    fun `Can create an Article`() {
        val article = Article(
            generateAggregateRootId(),
            "Test Article",
            "Test headline",
            "Test Article Content",
            CategoryBuilder().build()
        )
        val events = article.pullDomainEvents()
        assertThat(events).hasSize(1)
        assert(events.first() is ArticleCreatedEvent)
    }

    @Test
    fun `Event is registered when Article is published`() {
        val article = Article(
            generateAggregateRootId(),
            "Test Article",
            "Test headline",
            "Test Article Content",
            CategoryBuilder().build()
        )
        article.pullDomainEvents()

        article.publish()
        assert(article.isPublished())
        assertThat(article.publishedAt).isNotNull()
        val events = article.pullDomainEvents()
        assertThat(events).hasSize(1)
        assert(events.first() is ArticlePublishedEvent)
    }
}