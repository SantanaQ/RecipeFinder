package com.rf.recipefinder.datamodel.recipecategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeCategoryService {

    private final RecipeCategoryRepository recipeCategoryRepository;

    @Autowired
    public RecipeCategoryService(RecipeCategoryRepository recipeCategoryRepository) {
        this.recipeCategoryRepository = recipeCategoryRepository;
    }

    public RecipeCategory saveRecipeCategory(RecipeCategory recipeCategory) {
        Optional<RecipeCategory> recipeCategoryOptional = recipeCategoryRepository
                .findRecipeCategoryByCategoryAndRecipe(recipeCategory.getCategory(), recipeCategory.getRecipe());
        return recipeCategoryOptional.orElseGet(() -> recipeCategoryRepository.save(recipeCategory));
    }

}
