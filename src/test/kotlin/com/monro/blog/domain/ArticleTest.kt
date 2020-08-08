package com.monro.blog.domain

import org.assertj.core.api.Assertions.assertThat
import com.monro.shared.src.domain.generateAggregateRootId
import org.junit.jupiter.api.Test

class ArticleTest() {

    @Test
    fun `Can create an Article`() {
        val article = Article(
            generateAggregateRootId(),
            "Test Article",
            "Test Article Content"
        )
        assert(true)
    }

    @Test
    fun `Event is registered when Article is published`() {
        val article = Article(
                generateAggregateRootId(),
                "Test Article",
                "Test Article Content"
        )
        article.publish()
        assert(article.isPublished())
        assertThat(article.getPublishedAt()).isNotNull()
        val events = article.pullDomainEvents()
        assertThat(events).hasSize(1)
    }
}