package com.rf.recipefinder.datamodel.recipeingredient;

import com.rf.recipefinder.datamodel.ingredient.Ingredient;
import com.rf.recipefinder.datamodel.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

    @Query("SELECT DISTINCT ri.unit FROM RecipeIngredient ri")
    List<String> findAllUnits();

    Optional<RecipeIngredient> findRecipeIngredientByIngredientAndRecipe(Ingredient ingredient, Recipe recipe);
}
