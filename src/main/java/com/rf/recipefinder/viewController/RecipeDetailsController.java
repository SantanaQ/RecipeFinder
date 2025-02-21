package com.rf.recipefinder.viewController;

import com.rf.recipefinder.datamodel.recipe.Recipe;
import com.rf.recipefinder.datamodel.recipe.RecipeService;
import com.rf.recipefinder.datamodel.recipeingredient.RecipeIngredient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

@Controller
@RequestMapping("/recipes/details")
public class RecipeDetailsController {

    Recipe currentRecipe;

    private final RecipeService recipeService;

    public RecipeDetailsController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public String getRecipeById(@PathVariable Long id, Model model) {
        currentRecipe = recipeService.findById(id);
        model.addAttribute("recipe", currentRecipe);
        model.addAttribute("ingredients", currentRecipe.getIngredients());
        return "recipe_details";
    }

    @PostMapping("/{id}/calculateServings")
    public String calculateServings(@RequestParam int servings, Model model, @PathVariable String id) {
        if(currentRecipe == null) {
            //NEEDS Error view
            return "recipe_details";
        }

        for(RecipeIngredient recipeIngredient : currentRecipe.getIngredients()) {
            double newAmount = recipeIngredient.getBaseAmount()/ currentRecipe.getBaseServings() * servings;
            BigDecimal bd = BigDecimal.valueOf(newAmount).round(new MathContext(2));
            recipeIngredient.setAmount(bd.doubleValue());
        }
        currentRecipe.setServings(servings);
        model.addAttribute("currentRecipe", currentRecipe);
        model.addAttribute("ingredients", currentRecipe.getIngredients());
        return "fragments/ingredient_list";
    }





}
