package com.monro.blog.domain

import com.monro.shared.src.domain.DomainEvent
import java.io.Serializable

class ArticlePublishedEvent(
        var articleId: String
) : DomainEvent(articleId, HashMap()) {
}