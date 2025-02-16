package com.rf.recipefinder.datamodel.category;

import com.rf.recipefinder.util.Capitalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(Category category) {
        category.setName(Capitalizer.capitalizeFirstLetter(category.getName()));
        Optional<Category> categoryOptional = categoryRepository.findByName(category.getName());
        return categoryOptional.orElseGet(() -> categoryRepository.save(category));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


}
