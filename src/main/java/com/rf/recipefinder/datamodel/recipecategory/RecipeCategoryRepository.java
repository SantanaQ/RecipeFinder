package com.rf.recipefinder.datamodel.recipecategory;

import com.rf.recipefinder.datamodel.category.Category;
import com.rf.recipefinder.datamodel.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory, Long> {
    Optional<RecipeCategory> findRecipeCategoryByCategoryAndRecipe(Category category, Recipe recipe);
}
