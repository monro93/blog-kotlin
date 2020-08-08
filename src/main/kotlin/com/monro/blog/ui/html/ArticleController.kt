package com.monro.blog.ui.html

import com.monro.blog.domain.ArticleRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException

@Controller
class ArticleController (
    private val articleRepository: ArticleRepository
) {
    @GetMapping("/article/{slug}")
    fun article(@PathVariable slug: String, model: Model): String {
        model["title"] = "Artículos"
        model["article"] = articleRepository
            .findBySlug(slug)
            ?.render()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Artículo no encontrado")
        return "article"
    }
}