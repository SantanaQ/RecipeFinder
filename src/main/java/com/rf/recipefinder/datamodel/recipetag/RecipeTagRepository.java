package com.rf.recipefinder.datamodel.recipetag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeTagRepository extends JpaRepository<RecipeTag, Long> {
}
