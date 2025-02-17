package com.rf.recipefinder.datamodel.unit;

import com.rf.recipefinder.util.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    @Autowired
    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public Unit saveUnit(Unit unit) {
        String cleanedAbbreviation = StringFormatter.trimAndLowercase(unit.getAbbreviation());
        unit.setAbbreviation(cleanedAbbreviation);
        return unitRepository.findByAbbreviation(cleanedAbbreviation)
                .orElseGet(() -> unitRepository.save(unit));
    }

    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

}
