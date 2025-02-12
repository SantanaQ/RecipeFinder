package com.rf.recipefinder.datamodel.ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    @Query("SELECT i from Ingredient i WHERE i.name = ?1")
    Optional<Ingredient> findByName(String name);

}
