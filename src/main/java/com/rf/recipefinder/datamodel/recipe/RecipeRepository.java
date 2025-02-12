package com.rf.recipefinder.datamodel.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT DISTINCT r FROM Recipe r JOIN r.categories rc WHERE rc.category.name IN :categories")
    List<Recipe> findAllByCategories(List<String> categories);

    @Query("SELECT DISTINCT r FROM Recipe r JOIN r.ingredients rc WHERE rc.ingredient.name IN :ingredients")
    List<Recipe> findAllByIngredients(List<String> ingredients);

    List<Recipe> findByTitleContainingIgnoreCase(String name);

}
