package org.rest.resource.ms.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Artist extends PanacheEntity {

    public String name;
    public String bio;
    public int age;

    public Artist() {
    }

    public Artist(String name, String bio, int age) {
        this.name = name;
        this.bio = bio;
        this.age = age;
    }
}
