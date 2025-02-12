package com.rf.recipefinder.datamodel.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(Category category) {
        if(categoryRepository.findByName(category.getName()).isPresent()) {
            throw new IllegalStateException("Category already exists");
        }
        return categoryRepository.save(category);
    }


}
