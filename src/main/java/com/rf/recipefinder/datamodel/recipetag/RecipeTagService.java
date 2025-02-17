package com.rf.recipefinder.datamodel.recipetag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeTagService {

    private final RecipeTagRepository recipeTagRepository;

    @Autowired
    public RecipeTagService(RecipeTagRepository recipeTagRepository) {
        this.recipeTagRepository = recipeTagRepository;
    }

    public RecipeTag saveRecipeTag(RecipeTag recipeTag) {
        Optional<RecipeTag> recipeTagOptional = recipeTagRepository
                .findRecipeTagByTagAndRecipe(recipeTag.getTag(), recipeTag.getRecipe());
        return recipeTagOptional.orElseGet( () -> recipeTagRepository.save(recipeTag));
    }


}
