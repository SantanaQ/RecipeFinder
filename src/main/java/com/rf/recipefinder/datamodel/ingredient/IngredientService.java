package com.rf.recipefinder.datamodel.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        if(ingredientRepository.findByName(ingredient.getName()).isPresent()) {
            throw new IllegalStateException("Ingredient already exists");
        }
        return ingredientRepository.save(ingredient);
    }

}
