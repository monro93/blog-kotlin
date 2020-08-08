package com.monro.blog.infrastructure.persistance

import com.monro.blog.domain.Article
import com.monro.blog.domain.ArticleRepository
import org.springframework.data.repository.CrudRepository

interface SpringArticleRepository: ArticleRepository, CrudRepository<Article, String> {
}