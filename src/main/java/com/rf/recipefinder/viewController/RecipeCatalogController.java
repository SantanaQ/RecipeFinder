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

    @GetMapping("/{id}")
    public String getRecipeById(Model model, @PathVariable Long id) {
        Recipe r = recipeService.findById(id);
        model.addAttribute("recipe", r);
        return "recipe_details";
    }

    @GetMapping("/image")
    public String getRecipeImage(@RequestParam Long id) {
        return recipeService.getRecipeImagePath(id);
    }

/*
    @PostMapping("/calculateAmount")
    public String calculateAmount(@RequestParam int servings, Model model) {
        Recipe recipe = recipeService.getCurrent
        return String.format("%.2f", calculatedAmount);
    }*/

}
