package com.monro.blog.ui.html

import com.monro.blog.domain.Article

fun Article.render() = RenderedArticle(
    slug,
    title,
    content,
    getPublishedAt().toString()
)

data class RenderedArticle(
    val slug: String,
    val title: String,
    val content: String,
    val addedAt: String
)
