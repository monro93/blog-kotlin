package com.monro.blog.ui.html

import com.monro.blog.domain.Article
import com.monro.shared.src.domain.format

fun Article.render() = RenderedArticle(
    fullSlug(),
    title,
    headline,
    content,
    publishedAt?.format()
)

data class RenderedArticle(
    val fullSlug: String,
    val title: String,
    val headline: String,
    val content: String,
    val addedAt: String?
)
