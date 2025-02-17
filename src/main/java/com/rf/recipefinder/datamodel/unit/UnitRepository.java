package com.rf.recipefinder.datamodel.unit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit, Long> {

    Optional<Unit> findByAbbreviation(String cleanedAbbreviation);
}
