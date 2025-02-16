package com.rf.recipefinder.datamodel.ingredient;

import com.rf.recipefinder.util.Capitalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        ingredient.setName(Capitalizer.capitalizeFirstLetter(ingredient.getName()));
        Optional<Ingredient> optionalIngredient = ingredientRepository.findByName(ingredient.getName());
        return optionalIngredient.orElseGet(() -> ingredientRepository.save(ingredient));
    }

    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

}
