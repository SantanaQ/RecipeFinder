package com.rf.recipefinder.datamodel.ingredient;

import jakarta.persistence.*;

@Entity
@Table
public class Ingredient {

    @Id
    @SequenceGenerator(name = "ingredientSequence", sequenceName = "ingredientSequence", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ingredientSequence")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public Ingredient() {}

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
