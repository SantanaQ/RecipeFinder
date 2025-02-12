package com.rf.recipefinder.datamodel.recipe;


import com.rf.recipefinder.datamodel.category.CategoryService;
import com.rf.recipefinder.datamodel.ingredient.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final CategoryService categoryService;
    private final IngredientService ingredientService;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository,
                         CategoryService categoryService,
                         IngredientService ingredientService) {
        this.recipeRepository = recipeRepository;
        this.categoryService = categoryService;
        this.ingredientService = ingredientService;
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }









}
