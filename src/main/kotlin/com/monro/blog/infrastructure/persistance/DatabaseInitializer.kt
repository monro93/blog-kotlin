package com.monro.blog.infrastructure.persistance

import com.monro.blog.domain.Article
import com.monro.blog.domain.ArticleRepository
import com.monro.shared.src.domain.generateAggregateRootId
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseInitializer {
    @Bean
    fun run(articleRepository: ArticleRepository) = ApplicationRunner {
        val testArticle = Article(
            id= generateAggregateRootId(),
            title = "Artículo de ejemplo",
            content = "Artículo de prueba mientras construyo la web para ir probando como se va viendo",
            slug = "example"
        )
        testArticle.publish()
        articleRepository.save(testArticle)
    }
}