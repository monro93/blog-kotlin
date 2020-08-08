package com.monro.blog.ui.html

import com.monro.blog.domain.ArticleRepository
import com.monro.blog.domain.ArticleStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController(
    private val articleRepository: ArticleRepository
) {

    @GetMapping("/")
    fun index(model: Model): String {
        model["title"] = "montol.io blog"
        model["articles"] =
            articleRepository
                .findByStatusOrderByPublishedAtDesc(ArticleStatus.PUBLISHED)
                .map { it.render() }
        return "index"
    }
}