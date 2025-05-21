package com.badr.blog.services.impl;

import com.badr.blog.domain.entities.Category;
import com.badr.blog.repositories.CategoryRepository;
import com.badr.blog.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllByPostCount();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        if(categoryRepository.existsByNameIgnoreCase(category.getName())){
            throw new IllegalArgumentException("Category already exists with name: " + category.getName());
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        // We only delete categories that have no posts associated with them
        Optional<Category> category = categoryRepository.findById(id);

        if (category.isPresent()){
            if (!category.get().getPosts().isEmpty()) {
                throw new IllegalArgumentException("Cannot delete category with id: " + id + " as it has posts associated with it");
            }
            categoryRepository.deleteById(id);
        }
    }
}
