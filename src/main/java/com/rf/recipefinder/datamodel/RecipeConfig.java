package com.rf.recipefinder.datamodel;

import com.rf.recipefinder.datamodel.category.CategoryRepository;
import com.rf.recipefinder.datamodel.category.CategoryService;
import com.rf.recipefinder.datamodel.ingredient.IngredientRepository;
import com.rf.recipefinder.datamodel.ingredient.IngredientService;
import com.rf.recipefinder.datamodel.recipe.Recipe;
import com.rf.recipefinder.datamodel.recipe.RecipeRepository;
import com.rf.recipefinder.datamodel.recipe.RecipeService;
import com.rf.recipefinder.datamodel.recipecategory.RecipeCategoryRepository;
import com.rf.recipefinder.datamodel.recipecategory.RecipeCategoryService;
import com.rf.recipefinder.datamodel.recipeingredient.RecipeIngredientRepository;
import com.rf.recipefinder.datamodel.recipeingredient.RecipeIngredientService;
import com.rf.recipefinder.datamodel.recipetag.RecipeTagRepository;
import com.rf.recipefinder.datamodel.recipetag.RecipeTagService;
import com.rf.recipefinder.datamodel.tag.TagRepository;
import com.rf.recipefinder.datamodel.tag.TagService;
import com.rf.recipefinder.json.JSONParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class RecipeConfig {

    @Bean
    CommandLineRunner commandLineRunner(IngredientRepository ingredientRepository,
                                        RecipeRepository recipeRepository,
                                        RecipeIngredientRepository recipeIngredientRepository,
                                        CategoryRepository categoryRepository,
                                        RecipeCategoryRepository recipeCategoryRepository,
                                        TagRepository tagRepository,
                                        RecipeTagRepository recipeTagRepository) {
        return args -> {

            IngredientService ingredientService = new IngredientService(ingredientRepository);
            RecipeIngredientService recipeIngredientService = new RecipeIngredientService(recipeIngredientRepository);
            CategoryService categoryService = new CategoryService(categoryRepository);
            RecipeCategoryService recipeCategoryService = new RecipeCategoryService(recipeCategoryRepository);
            TagService tagService = new TagService(tagRepository);
            RecipeTagService recipeTagService = new RecipeTagService(recipeTagRepository);

            RecipeService recipeService = new RecipeService(recipeRepository,
                    ingredientService,
                    recipeIngredientService,
                    categoryService,
                    recipeCategoryService,
                    tagService,
                    recipeTagService);

            JSONParser jsonParser = new JSONParser();
            List<Recipe> recipes = jsonParser.parseRecipes();
            for (Recipe recipe : recipes) {
                recipeService.saveRecipe(recipe);
            }


        };
    }

}
