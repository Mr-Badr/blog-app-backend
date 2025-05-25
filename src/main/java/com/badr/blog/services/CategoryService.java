package com.badr.blog.services;

import com.badr.blog.domain.entities.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
    void deleteCategory(UUID id);

    // We use this with Posts filtering
    Category getCategoryById(UUID id);
}
