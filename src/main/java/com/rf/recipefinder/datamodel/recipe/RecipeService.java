package com.rf.recipefinder.datamodel.recipe;


import com.rf.recipefinder.datamodel.category.Category;
import com.rf.recipefinder.datamodel.category.CategoryService;
import com.rf.recipefinder.datamodel.ingredient.Ingredient;
import com.rf.recipefinder.datamodel.ingredient.IngredientService;
import com.rf.recipefinder.datamodel.recipecategory.RecipeCategory;
import com.rf.recipefinder.datamodel.recipecategory.RecipeCategoryService;
import com.rf.recipefinder.datamodel.recipeingredient.RecipeIngredient;
import com.rf.recipefinder.datamodel.recipeingredient.RecipeIngredientService;
import com.rf.recipefinder.datamodel.recipetag.RecipeTag;
import com.rf.recipefinder.datamodel.recipetag.RecipeTagService;
import com.rf.recipefinder.datamodel.tag.Tag;
import com.rf.recipefinder.datamodel.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;
    private final RecipeIngredientService recipeIngredientService;
    private final CategoryService categoryService;
    private final RecipeCategoryService recipeCategoryService;
    private final TagService tagService;
    private final RecipeTagService recipeTagService;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository,
                         IngredientService ingredientService,
                         RecipeIngredientService recipeIngredientService,
                         CategoryService categoryService,
                         RecipeCategoryService recipeCategoryService,
                         TagService tagService,
                         RecipeTagService recipeTagService) {
        this.recipeRepository = recipeRepository;
        this.ingredientService = ingredientService;
        this.recipeIngredientService = recipeIngredientService;
        this.categoryService = categoryService;
        this.recipeCategoryService = recipeCategoryService;
        this.tagService = tagService;
        this.recipeTagService = recipeTagService;
    }


    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public List<String> findSummariesByTitle() {
        return recipeRepository.findAllTitles();
    }

    public List<RecipeDTO> findAllSummaries() {
        List<Recipe> recipes = findAll();
        List<RecipeDTO> recipesSummaries = new ArrayList<>();
        for (Recipe recipe : recipes) {
            recipesSummaries.add(new RecipeDTO(
                    recipe.getId(),
                    recipe.getTitle(),
                    recipe.getDescription(),
                    recipe.getAuthor(),
                    recipe.getCategories(),
                    recipe.getImage()));
        }
        return recipesSummaries;
    }

    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElseThrow() ;
    }

    public List<Recipe> findByCategories(List<String> categories) {
        return recipeRepository.findAllByCategories(categories);
    }

    public List<RecipeDTO> findSummariesByCategory(String category) {
        List<Recipe> recipes = findByCategories(List.of(category));
        return createDTOs(recipes);
    }

    public List<Recipe> findByIngredients(List<String> ingredients) {
        return recipeRepository.findAllByIngredients(ingredients);
    }

    public List<Recipe> findByTags(List<String> tags) {
        return recipeRepository.findAllByTags(tags);
    }

    public List<RecipeDTO> findSummariesByTag(String tag) {
        List<Recipe> recipes = findByTags(List.of(tag));
        System.out.println(recipes.size());
        return createDTOs(recipes);
    }

    public List<Recipe> findByTitle(String title) {
        return recipeRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<RecipeDTO> findSummariesByTitle(String query) {
        if(query == null || query.isEmpty()) {
            return List.of();
        }
        List<Recipe> recipes = recipeRepository.findByTitleContainingIgnoreCase(query);
        return createDTOs(recipes);
    }

    @Transactional
    public Recipe saveRecipe(Recipe recipe) {
        Recipe savedRecipe = recipeRepository.save(recipe);

        for(RecipeIngredient recipeIngredient : recipe.getIngredients()) {
            Ingredient savedIngredient = ingredientService.saveIngredient(recipeIngredient.getIngredient());
            recipeIngredient.setIngredient(savedIngredient);
            recipeIngredient.setRecipe(savedRecipe);
            recipeIngredientService.saveRecipeIngredient(recipeIngredient);
        }

        for (RecipeCategory recipeCategory : recipe.getCategories()) {
            Category savedCategory = categoryService.saveCategory(recipeCategory.getCategory());
            recipeCategory.setCategory(savedCategory);
            recipeCategory.setRecipe(savedRecipe);
            recipeCategoryService.saveRecipeCategory(recipeCategory);
        }

        for (RecipeTag recipeTag : recipe.getTags()) {
            Tag savedTag = tagService.saveTag(recipeTag.getTag());
            recipeTag.setTag(savedTag);
            recipeTag.setRecipe(savedRecipe);
            recipeTagService.saveRecipeTag(recipeTag);
        }
        return savedRecipe;
    }

    private List<RecipeDTO> createDTOs(List<Recipe> recipes) {
        List<RecipeDTO> dtos = new ArrayList<>();
        for (Recipe recipe : recipes) {
            dtos.add(new RecipeDTO(
                    recipe.getId(),
                    recipe.getTitle(),
                    recipe.getDescription(),
                    recipe.getAuthor(),
                    recipe.getCategories(),
                    recipe.getImage()));
        }
        return dtos;
    }

}
