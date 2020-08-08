package com.monro.blog.domain

interface ArticleRepository {
    fun save(article: Article)
    fun findBySlug(slug: String): Article?
    fun findByStatusOrderByPublishedAtDesc(status: ArticleStatus): Iterable<Article>
}