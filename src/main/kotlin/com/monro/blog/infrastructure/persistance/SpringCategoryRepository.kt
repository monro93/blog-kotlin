package com.monro.blog.infrastructure.persistance

import com.monro.blog.domain.Category
import com.monro.blog.domain.CategoryRepository
import org.springframework.data.repository.CrudRepository

interface SpringCategoryRepository: CategoryRepository, CrudRepository<Category, String> {
}