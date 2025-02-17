package com.rf.recipefinder.datamodel.ingredient;

import com.rf.recipefinder.util.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        ingredient.setName(StringFormatter.trimAndcapitalizeFirstLetter(ingredient.getName()));
        return ingredientRepository.findByName(ingredient.getName())
                .orElseGet(() -> ingredientRepository.save(ingredient));
    }

    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

}
