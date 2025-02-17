package com.rf.recipefinder.datamodel.recipeingredient;

import com.rf.recipefinder.util.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeIngredientService {

    private final RecipeIngredientRepository recipeIngredientRepository;

    @Autowired
    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    public RecipeIngredient saveRecipeIngredient(RecipeIngredient recipeIngredient) {
        String cleanedUnit = StringFormatter.trimAndLowercase(recipeIngredient.getUnit());
        recipeIngredient.setUnit(cleanedUnit);
        Optional<RecipeIngredient> recipeIngredientOptional = recipeIngredientRepository
                .findRecipeIngredientByIngredientAndRecipe(recipeIngredient.getIngredient(), recipeIngredient.getRecipe());
        return recipeIngredientOptional.orElseGet(() -> recipeIngredientRepository.save(recipeIngredient));
    }

}
