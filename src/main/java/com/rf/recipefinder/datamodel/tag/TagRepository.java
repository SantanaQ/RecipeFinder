package com.rf.recipefinder.datamodel.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT t from Tag t WHERE t.name = ?1")
    Optional<Tag> findByName(String name);

}
