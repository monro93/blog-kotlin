package com.monro.blog.domain

interface CategoryRepository {
    fun save(category: Category)
    fun findAll(): Iterable<Category>
}