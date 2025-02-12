package com.rf.recipefinder.datamodel.recipe;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rf.recipefinder.datamodel.recipecategory.RecipeCategory;
import com.rf.recipefinder.datamodel.recipeingredient.RecipeIngredient;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Recipe {

    @Id
    @SequenceGenerator(name = "recipeSequence", sequenceName = "recipeSequence", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "recipeSequence")
    //@Column(name = "recipe_id", insertable = false, updatable = false, nullable = false)
    private Long id;

    private String title;
    private String description;
    @Column(length = 4000)
    private String instructions;
    private String author;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RecipeIngredient> ingredients;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RecipeCategory> categories;

    public Recipe() {}

    public Recipe(Long id, String title, String description, String instructions, String author, List<RecipeIngredient> ingredients, List<RecipeCategory> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.author = author;
        this.ingredients = ingredients;
        this.categories = categories;
    }

    public Recipe(String title, String description, String instructions, String author, List<RecipeIngredient> ingredients, List<RecipeCategory> categories) {
        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.author = author;
        this.ingredients = ingredients;
        this.categories = categories;
    }

    public Recipe(String title, String description, String instructions, String author) {
        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
