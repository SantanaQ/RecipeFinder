package com.rf.recipefinder.datamodel.category;

import com.rf.recipefinder.util.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(Category category) {
        String cleanedName = StringFormatter.trimAndcapitalizeFirstLetter(category.getName());
        category.setName(cleanedName);
        return categoryRepository.findByName(cleanedName)
                .orElseGet(() -> categoryRepository.save(category));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


}
