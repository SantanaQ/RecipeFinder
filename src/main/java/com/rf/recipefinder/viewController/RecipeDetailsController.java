package com.rf.recipefinder.viewController;

import com.rf.recipefinder.datamodel.recipe.Recipe;
import com.rf.recipefinder.datamodel.recipe.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/recipes/details")
public class RecipeDetailsController {

    Recipe currentRecipe;

    private final RecipeService recipeService;

    public RecipeDetailsController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }




}
