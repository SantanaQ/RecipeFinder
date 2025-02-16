package com.rf.recipefinder.datamodel.tag;

import jakarta.persistence.*;

@Entity
@Table
public class Tag {

    @Id
    @SequenceGenerator(name = "tagSequence", sequenceName = "tagSequence", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "tagSequence")
    private Long id;

    private String name;

    public Tag(){}

    public Tag(String name) {
        this.name = name;
    }

    public Tag(Long id, String name) {
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
