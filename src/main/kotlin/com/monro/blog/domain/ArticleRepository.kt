package com.monro.blog.domain

interface ArticleRepository {
    fun findBySlug(slug: String): Article?
    fun findByStatusOrderByPublishedAtDesc(status: ArticleStatus): Iterable<Article>
}