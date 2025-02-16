package com.rf.recipefinder.datamodel.recipeingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientService {

    private final RecipeIngredientRepository recipeIngredientRepository;

    @Autowired
    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    public RecipeIngredient saveRecipeIngredient(RecipeIngredient recipeIngredient) {
        recipeIngredient.setUnit(recipeIngredient.getUnit().toLowerCase());
        return recipeIngredientRepository.save(recipeIngredient);
    }

    //TODO: UnitService
    public List<String> getAllUnits() {
        return recipeIngredientRepository.findAllUnits();
    }

}
