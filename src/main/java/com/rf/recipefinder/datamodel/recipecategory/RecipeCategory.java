package com.rf.recipefinder.datamodel.recipecategory;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rf.recipefinder.datamodel.category.Category;
import com.rf.recipefinder.datamodel.recipe.Recipe;
import jakarta.persistence.*;

@Entity
@Table
public class RecipeCategory {

    @EmbeddedId
    private RecipeCategoryId id;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    @JsonBackReference
    private Recipe recipe;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private Category category;

    public RecipeCategory() {}

    public RecipeCategory(Recipe recipe, Category category) {
        this.recipe = recipe;
        this.category = category;
        this.id = new RecipeCategoryId(recipe.getId(), category.getId());
    }

    public RecipeCategoryId getId() {
        return id;
    }

    public void setId(RecipeCategoryId id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
