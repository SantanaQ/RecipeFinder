package com.rf.recipefinder.datamodel.recipeingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

    @Query("SELECT DISTINCT ri.unit FROM RecipeIngredient ri")
    List<String> findAllUnits();

}
