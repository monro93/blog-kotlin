package com.monro.blog.infrastructure.persistance

import com.monro.blog.domain.Article
import com.monro.blog.domain.ArticleRepository
import com.monro.blog.domain.ArticleStatus
import com.monro.shared.src.domain.generateAggregateRootId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class SpringArticleRepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val articleRepository: ArticleRepository
) {
    @Test
    fun `When findBySlug then return Article`() {
        val article = Article(
            generateAggregateRootId(),
            "Test Article",
            "Test Article Content",
            "test-article"
        )
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findBySlug("test-article")
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByStatusOrderByPublishedAtDesc then return Articles`() {
        val publishedArticle = Article(
            generateAggregateRootId(),
            "Test Article",
            "Test Article Content",
            "test-article"
        )
        publishedArticle.publish()
        val otherArticle = Article(
            generateAggregateRootId(),
            "Test Article2",
            "Test Article Content2",
            "test-article2"
        )
        entityManager.persist(publishedArticle)
        entityManager.persist(otherArticle)
        entityManager.flush()
        val found = articleRepository.findByStatusOrderByPublishedAtDesc(ArticleStatus.PUBLISHED)
        assertThat(found.count()).isEqualTo(1)
        assertThat(found.first()).isEqualTo(publishedArticle)
    }
}