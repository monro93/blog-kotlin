package com.monro.blog.domain

import com.monro.shared.src.domain.DomainEvent

class ArticleCreatedEvent(
    articleId: String,
    title: String,
    headline: String,
    content: String,
    slug: String,
    categoryId: String,
    status: String,
    publishedAt: String?
) :
    DomainEvent(
        articleId,
        hashMapOf(
            "title" to title,
            "headline" to headline,
            "content" to content,
            "slug" to slug,
            "categoryId" to categoryId,
            "status" to status,
            "publishedAt" to publishedAt
        )
    ) {
}