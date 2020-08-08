package com.monro.blog.ui.html

import org.springframework.boot.web.servlet.error.ErrorController as SpringErrorController
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ErrorController: SpringErrorController {

    @GetMapping("/error")
    fun error(model: Model): String {
        model["title"] = "Error 404"
        model["content"] = "Error 404. Página no encontrada."
        return "error"
    }

    override fun getErrorPath(): String {
       return "/error"
    }
}