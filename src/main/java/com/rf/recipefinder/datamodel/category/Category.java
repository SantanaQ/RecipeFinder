package com.rf.recipefinder.datamodel.category;

import jakarta.persistence.*;

@Entity
@Table
public class Category {

    @Id
    @SequenceGenerator(name = "categorySequence", sequenceName = "categorySequence", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "categorySequence")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
