package com.rf.recipefinder.datamodel.unit;

import jakarta.persistence.*;

@Entity
@Table
public class Unit {

    @Id
    @SequenceGenerator(name = "unitSequence", sequenceName = "unitSequence", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "unitSequence")
    private Long id;

    @Column(unique = true, nullable = false)
    private String abbreviation;

    public Unit() {}

    public Unit(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Unit (Long id, String abbreviation) {
        this.id = id;
        this.abbreviation = abbreviation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
