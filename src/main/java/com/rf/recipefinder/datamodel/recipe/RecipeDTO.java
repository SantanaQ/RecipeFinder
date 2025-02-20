package com.rf.recipefinder.datamodel.recipe;

import com.rf.recipefinder.datamodel.recipecategory.RecipeCategory;
import java.util.List;

public class RecipeDTO {

    private Long id;
    private String title;
    private String description;
    private String author;
    private List<RecipeCategory> categories;
    private String image;

    public RecipeDTO(Long id, String title, String description, String author,
                     List<RecipeCategory> categories, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.categories = categories;
        this.image = image;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
