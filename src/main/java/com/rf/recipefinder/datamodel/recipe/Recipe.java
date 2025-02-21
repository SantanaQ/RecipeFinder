package com.rf.recipefinder.datamodel.recipe;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rf.recipefinder.datamodel.recipecategory.RecipeCategory;
import com.rf.recipefinder.datamodel.recipeingredient.RecipeIngredient;
import com.rf.recipefinder.datamodel.recipetag.RecipeTag;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Recipe {

    @Id
    @SequenceGenerator(name = "recipeSequence", sequenceName = "recipeSequence", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "recipeSequence")
    private Long id;

    private String title;
    private String description;
    @Column(length = 4000)
    private String instructions;
    private String author;
    private int prepTime;
    private int cookingTime;
    private int servings;
    private String image;

    private int baseServings;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.DETACH, orphanRemoval = true)
    @JsonManagedReference
    private List<RecipeIngredient> ingredients;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.DETACH, orphanRemoval = true)
    @JsonManagedReference
    private List<RecipeCategory> categories;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.DETACH, orphanRemoval = true)
    @JsonManagedReference
    private List<RecipeTag> tags;

    public Recipe() {}

    public Recipe(Long id, String title, String description,
                  String instructions, String author, List<RecipeIngredient> ingredients,
                  List<RecipeCategory> categories, List<RecipeTag> tags, int prepTime,
                  int cookingTime, int servings, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.author = author;
        this.ingredients = ingredients;
        this.categories = categories;
        this.tags = tags;
        this.prepTime = prepTime;
        this.cookingTime = cookingTime;
        this.servings = servings;
        this.image = image;
        this.baseServings = servings;
    }

    public Recipe(String title, String description,
                  String instructions, String author, List<RecipeIngredient> ingredients,
                  List<RecipeCategory> categories, List<RecipeTag> tags, int prepTime,
                  int cookingTime, int servings, String image) {
        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.author = author;
        this.ingredients = ingredients;
        this.categories = categories;
        this.tags = tags;
        this.prepTime = prepTime;
        this.cookingTime = cookingTime;
        this.servings = servings;
        this.image = image;
        this.baseServings = servings;
    }

    public Recipe(String title, String description, String instructions, String author,
                  int prepTime, int cookingTime, int servings, String image) {
        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.author = author;
        this.prepTime = prepTime;
        this.cookingTime = cookingTime;
        this.servings = servings;
        this.image = image;
        this.baseServings = servings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }

    public List<RecipeTag> getTags() {
        return tags;
    }

    public void setTags(List<RecipeTag> tags) {
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getBaseServings() {
        return baseServings;
    }
}
