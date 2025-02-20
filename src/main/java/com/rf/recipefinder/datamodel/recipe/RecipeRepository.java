package com.rf.recipefinder.datamodel.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT DISTINCT r FROM Recipe r JOIN r.categories rc WHERE rc.category.name IN :categories")
    List<Recipe> findAllByCategories(List<String> categories);

    @Query("SELECT DISTINCT r FROM Recipe r JOIN r.ingredients ri WHERE ri.ingredient.name IN :ingredients")
    List<Recipe> findAllByIngredients(List<String> ingredients);

    @Query("SELECT DISTINCT r FROM Recipe r JOIN r.tags rt WHERE rt.tag.name IN :tags")
    List<Recipe> findAllByTags(List<String> tags);

    List<Recipe> findByTitleContainingIgnoreCase(String name);

    @Query("SELECT DISTINCT r.title FROM Recipe r")
    List<String> findAllTitles();

    //@Query("SELECT new com.rf.recipefinder.datamodel.recipe.RecipeDTO(r.title, r.description, r.author, r.image) FROM Recipe r")
    //List<RecipeDTO> findAllSummaries();

}
