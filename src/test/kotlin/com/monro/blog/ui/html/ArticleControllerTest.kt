package com.monro.blog.ui.html

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArticleControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `Assert article page has the expected title`() {
        val entity = restTemplate.getForEntity<String>("/article/tecnico/example")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("<title>Artículo de ejemplo</title>")
    }
}