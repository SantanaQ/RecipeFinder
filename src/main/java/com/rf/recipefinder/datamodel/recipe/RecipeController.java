package com.rf.recipefinder.datamodel.recipe;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.findById(id);
    }

    @GetMapping("/category")
    public List<Recipe> getRecipesByCategories(@RequestParam List<String> categories) {
        return recipeService.findByCategories(categories);
    }

    @GetMapping("/ingredient")
    public List<Recipe> getRecipesByIngredients(@RequestParam List<String> ingredients) {
        return recipeService.findByIngredients(ingredients);
    }

    @GetMapping("/tag")
    public List<Recipe> getRecipesByTags(@RequestParam List<String> tags) {
        return recipeService.findByTags(tags);
    }

    @GetMapping("/search")
    public List<Recipe> searchRecipes(@RequestParam String title) {
        return recipeService.findByTitle(title);
    }

    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }


}
