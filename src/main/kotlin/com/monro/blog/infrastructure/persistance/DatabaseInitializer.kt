package com.monro.blog.infrastructure.persistance

import com.monro.blog.domain.Article
import com.monro.blog.domain.ArticleRepository
import com.monro.blog.domain.Category
import com.monro.blog.domain.CategoryRepository
import com.monro.shared.src.domain.generateAggregateRootId
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseInitializer {
    @Bean
    fun run(
        categoryRepository: CategoryRepository,
        articleRepository: ArticleRepository
    ) = ApplicationRunner {
        val category = Category(
            id = generateAggregateRootId(),
            name = "Tecnico"
        )
        categoryRepository.save(category)

        val testArticle = Article(
            id = generateAggregateRootId(),
            title = "Artículo de ejemplo",
            headline = "El contenido de este artículo te sorprenderá",
            content = "Artículo de prueba mientras construyo la web para ir probando como se va viendo",
            category = category,
            slug = "example"
        )
        testArticle.publish()
        articleRepository.save(testArticle)
    }
}