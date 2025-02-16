package com.rf.recipefinder.datamodel.recipetag;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rf.recipefinder.datamodel.recipe.Recipe;
import com.rf.recipefinder.datamodel.tag.Tag;
import jakarta.persistence.*;

@Entity
@Table
public class RecipeTag {

    @EmbeddedId
    private RecipeTagId id;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    @JsonBackReference
    private Recipe recipe;

    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public RecipeTag() {}

    public RecipeTag(Recipe recipe, Tag tag) {
        this.recipe = recipe;
        this.tag = tag;
        this.id = new RecipeTagId(recipe.getId(), tag.getId());
    }

    public RecipeTagId getId() {
        return id;
    }

    public void setId(RecipeTagId id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
