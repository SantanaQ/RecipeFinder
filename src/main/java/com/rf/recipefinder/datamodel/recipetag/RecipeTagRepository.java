package com.rf.recipefinder.datamodel.recipetag;

import com.rf.recipefinder.datamodel.recipe.Recipe;
import com.rf.recipefinder.datamodel.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeTagRepository extends JpaRepository<RecipeTag, Long> {
    Optional<RecipeTag> findRecipeTagByTagAndRecipe(Tag tag, Recipe recipe);
}
