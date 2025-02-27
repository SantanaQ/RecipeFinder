package com.rf.recipefinder.viewController;

import com.rf.recipefinder.datamodel.category.CategoryService;
import com.rf.recipefinder.datamodel.recipe.RecipeDTO;
import com.rf.recipefinder.datamodel.recipe.RecipeService;

import com.rf.recipefinder.datamodel.tag.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/recipes")
public class RecipeCatalogController {

    private final RecipeService recipeService;
    private final TagService tagService;
    private final CategoryService categoryService;

    public RecipeCatalogController(RecipeService recipeService,
                                   TagService tagService,
                                   CategoryService categoryService) {
        this.recipeService = recipeService;
        this.tagService = tagService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getAllRecipeSummaries(Model model) {
        List<RecipeDTO> summaries = recipeService.findAllSummaries();
        model.addAttribute("recipes", summaries);
        return "/fragments/recipe_list";
    }

    @PostMapping("/{type}/{concrete}")
    public String getAllByType(@PathVariable String type, @PathVariable String concrete, Model model) {
        List<RecipeDTO> summaries = switch (type) {
            case "category" -> recipeService.findSummariesByCategory(concrete);
            case "tag" -> recipeService.findSummariesByTag(concrete);
            default -> new ArrayList<>();
        };
        model.addAttribute("recipes", summaries);
        return "/fragments/recipe_list";
    }

    @GetMapping("/category/{category}")
    public String categoryPage(@PathVariable String category, Model model) {
        model.addAttribute("category", category);
        return "category";
    }

    @GetMapping("/tag/{tag}")
    public String tagPage(@PathVariable String tag, Model model) {
        model.addAttribute("tag", tag);
        return "tag";
    }

    @PostMapping("/searchResults")
    public String search(@RequestParam String query, Model model) {
        List<RecipeDTO> recipes = recipeService.findSummariesByTitle(query);
        model.addAttribute("recipes", recipes);
        return "fragments/search_results";
    }

}
