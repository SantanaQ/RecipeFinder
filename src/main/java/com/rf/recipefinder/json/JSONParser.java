package com.rf.recipefinder.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.rf.recipefinder.datamodel.category.Category;
import com.rf.recipefinder.datamodel.ingredient.Ingredient;
import com.rf.recipefinder.datamodel.recipe.Recipe;
import com.rf.recipefinder.datamodel.recipecategory.RecipeCategory;
import com.rf.recipefinder.datamodel.recipeingredient.RecipeIngredient;
import com.rf.recipefinder.datamodel.recipetag.RecipeTag;
import com.rf.recipefinder.datamodel.tag.Tag;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {

    final String filepath = "src/main/resources/static/json/recipes.json";

    private final Gson gson;

    public JSONParser() {
        gson = new Gson();
    }

    public List<Recipe> parseRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        try {
            JsonArray jsonArray = gson.fromJson(new FileReader(filepath), JsonArray.class);
            for (JsonElement jsonElement : jsonArray) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String name = jsonObject.get("name").getAsString();
                String description = jsonObject.get("description").getAsString();
                String instructions = jsonObject.get("instructions").getAsString();
                String ingredients = jsonObject.get("ingredients").getAsString();
                String tags = jsonObject.get("tags").getAsString();
                int preptime = jsonObject.get("preptime").getAsInt();
                int cookingtime = jsonObject.get("cookingtime").getAsInt();
                int servings = jsonObject.get("servings").getAsInt();
                String image = jsonObject.get("image").getAsString();
                String categories = jsonObject.get("course").getAsString();
                String creator = jsonObject.get("creator").getAsString();

                Recipe recipe = new Recipe(name, description, instructions,creator ,preptime, cookingtime, servings, image);

                List<RecipeIngredient> recipeIngredients = parseRecipeIngredients(recipe, ingredients);
                List<RecipeTag> recipeTags = parseRecipeTags(recipe, tags);
                List<RecipeCategory> recipeCategories = parseRecipeCategories(recipe, categories);

                recipe.setIngredients(recipeIngredients);
                recipe.setTags(recipeTags);
                recipe.setCategories(recipeCategories);

                recipes.add(recipe);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
        return recipes;
    }

    private List<RecipeIngredient> parseRecipeIngredients(Recipe recipe, String ingredients) {
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        String[] ingredientArray = ingredients.split(", ");
        for (String ingredientString : ingredientArray) {
            String[] ingredientParts = ingredientString.split(" ");
            double amount = Double.parseDouble(ingredientParts[0]);
            String unit = ingredientParts[1];
            StringBuilder ingredientName = new StringBuilder();
            for (int i = 2; i < ingredientParts.length; i++) {
                ingredientName.append(ingredientParts[i]).append(" ");
            }
            String ingredientNameFull = ingredientName.substring(0, ingredientName.length() - 1);
            Ingredient ingredient = new Ingredient(ingredientNameFull);
            RecipeIngredient recipeIngredient = new RecipeIngredient(recipe, ingredient, amount, unit);
            recipeIngredients.add(recipeIngredient);
        }
        return  recipeIngredients;
    }

    private List<RecipeTag> parseRecipeTags(Recipe recipe, String tags) {
        List<RecipeTag> recipeTags = new ArrayList<>();
        String[] tagArray = tags.split(", ");
        for (String tagString : tagArray) {
            Tag tag = new Tag(tagString);
            RecipeTag recipeTag = new RecipeTag(recipe, tag);
            recipeTags.add(recipeTag);
        }
        return recipeTags;
    }

    private List<RecipeCategory> parseRecipeCategories(Recipe recipe, String categories) {
        List<RecipeCategory> recipeCategories = new ArrayList<>();
        String[] categoriesArray = categories.split(",");
        for (String categoryString : categoriesArray) {
            Category category = new Category(categoryString);
            RecipeCategory recipeCategory = new RecipeCategory(recipe, category);
            recipeCategories.add(recipeCategory);
        }
        return recipeCategories;
    }

}
