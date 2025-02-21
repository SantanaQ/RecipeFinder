package com.rf.recipefinder.viewController;

import com.rf.recipefinder.datamodel.recipe.Recipe;
import com.rf.recipefinder.datamodel.recipe.RecipeDTO;
import com.rf.recipefinder.datamodel.recipe.RecipeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recipes")
public class RecipeCatalogController {

    private final RecipeService recipeService;

    public RecipeCatalogController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public String getAllRecipeSummaries(Model model) {
        List<RecipeDTO> summaries = recipeService.findAllSummaries();
        model.addAttribute("recipes", summaries);
        return "/fragments/recipe_list";
    }



}
