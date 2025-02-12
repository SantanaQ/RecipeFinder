package com.rf.recipefinder.datamodel;

import com.rf.recipefinder.datamodel.category.Category;
import com.rf.recipefinder.datamodel.category.CategoryRepository;
import com.rf.recipefinder.datamodel.category.CategoryService;
import com.rf.recipefinder.datamodel.ingredient.Ingredient;
import com.rf.recipefinder.datamodel.ingredient.IngredientRepository;
import com.rf.recipefinder.datamodel.ingredient.IngredientService;
import com.rf.recipefinder.datamodel.recipe.Recipe;
import com.rf.recipefinder.datamodel.recipe.RecipeRepository;
import com.rf.recipefinder.datamodel.recipecategory.RecipeCategory;
import com.rf.recipefinder.datamodel.recipecategory.RecipeCategoryRepository;
import com.rf.recipefinder.datamodel.recipeingredient.RecipeIngredient;
import com.rf.recipefinder.datamodel.recipeingredient.RecipeIngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class RecipeConfig {

    @Bean
    CommandLineRunner commandLineRunner(IngredientRepository ingredientRepository,
                                        RecipeRepository recipeRepository,
                                        RecipeIngredientRepository recipeIngredientRepository,
                                        CategoryRepository categoryRepository,
                                        RecipeCategoryRepository recipeCategoryRepository) {
        return args -> {

            IngredientService ingredientService = new IngredientService(ingredientRepository);

            Ingredient spaghetti = ingredientService.saveIngredient(new Ingredient("Spaghetti"));
            Ingredient egg = ingredientService.saveIngredient(new Ingredient("Egg"));
            Ingredient bacon = ingredientService.saveIngredient(new Ingredient("Bacon"));
            Ingredient parmesan = ingredientService.saveIngredient(new Ingredient("Parmesan"));
            Ingredient blackPepper = ingredientService.saveIngredient(new Ingredient("Black Pepper"));

            CategoryService categoryService = new CategoryService(categoryRepository);
            Category main = categoryService.saveCategory(new Category("Main Course"));
            /*

            try {
                categoryService.saveCategory(new Category("Main Course"));
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            */

            Recipe carbonara = recipeRepository.save(new Recipe("Spaghetti Carbonara",
                    "Italian pasta dish with creamy egg sauce",
                    "1. Cook the pasta: Fill a large pot with water, add a pinch of salt, and bring it to a boil. Add the spaghetti to the boiling water and cook according to package instructions until al dente, about 8–10 minutes. 2. Prepare the egg and cheese mixture: While the pasta is cooking, crack the eggs into a medium bowl. Add the grated Parmesan cheese and whisk together until smooth and well-combined, forming a creamy mixture. Set aside. 3. Cook the bacon: Place a large skillet over medium heat. Cut the bacon into small pieces and add it to the hot skillet. Sauté until the bacon is crispy and the fat has rendered out, about 5 minutes. Reduce the heat and set the skillet aside so the bacon doesn't burn. 4. Reserve pasta water: When the spaghetti is al dente, scoop out about 1/2 cup of the pasta cooking water and set it aside. Drain the spaghetti but do not rinse it, as the starch on the pasta will help bind the sauce. 5. Combine pasta and bacon: Transfer the drained spaghetti to the skillet with the bacon. Toss to combine, allowing the pasta to be coated with the bacon fat. The residual heat from the skillet and pasta will help to gently cook the sauce in the next step. 6. Add the egg and cheese mixture: Remove the skillet from heat. Pour the egg and cheese mixture over the hot spaghetti, quickly tossing to coat the pasta evenly. The eggs should gently cook in the heat of the pasta, creating a creamy sauce. If the sauce is too thick, add a bit of the reserved pasta water to reach the desired consistency. 7. Season to taste: Add freshly ground black pepper to taste. Additional salt may not be necessary as the bacon and Parmesan are already salty. 8. Serve: Serve the Spaghetti Carbonara immediately, garnishing with extra Parmesan if desired.",
                    "RecipeFinder"));

            recipeRepository.save(carbonara);

            List<RecipeIngredient> ingredients = new ArrayList<>();
            ingredients.add(new RecipeIngredient(carbonara, spaghetti, 200.0, "g"));
            ingredients.add(new RecipeIngredient(carbonara, egg, 2, "large"));
            ingredients.add(new RecipeIngredient(carbonara, bacon, 100, "g"));
            ingredients.add(new RecipeIngredient(carbonara, parmesan, 50, "g"));
            ingredients.add(new RecipeIngredient(carbonara, blackPepper, 1,"tsp"));

            RecipeCategory category = recipeCategoryRepository.save(new RecipeCategory(carbonara, main));

            recipeIngredientRepository.saveAll(ingredients);
        };
    }

}
